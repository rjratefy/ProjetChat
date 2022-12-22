package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Server extends Thread{
    int nbClient;
    ArrayList<Conversation> clientConnectes = new ArrayList<>();
    ServerSocket serverSocket;

    public void broadCast(String message, Socket socketSender, int num) {
        try {
            for ( Conversation clientConnecte : clientConnectes ) {
                if ( clientConnecte.socketClient != socketSender ) {
                    PrintWriter pw = new PrintWriter(clientConnecte.socketClient.getOutputStream(), true);
                    pw.println("Client " + num + " : " + message);
                }
            }            
        }   catch( Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            
            serverSocket = new ServerSocket(1234);
            while ( true ) {
                Socket socketClient = serverSocket.accept();    //Accepter la connection d'un client a tout moment
                nbClient++;
                Conversation conversation = new Conversation(socketClient, nbClient);   //Generer un nouveau thread pour la conversation
                clientConnectes.add(conversation);
                conversation.start();
            }
        }   catch(Exception e) {
            closeServer();
        }
    }

    class Conversation extends Thread {
        Socket socketClient;
        int numero;
        public Conversation( Socket socketClient, int nbClient ){ //Gerer une conversation 
            super();
            this.socketClient = socketClient;
            this.numero = nbClient;
        }
        @Override
        public void run() {
            try {
                InputStream is = socketClient.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader in = new BufferedReader(isr);
                
                System.out.println(" Client numero " + numero + " ");
                OutputStream op = socketClient.getOutputStream();
                PrintWriter pw = new PrintWriter(op, true);
                String ip = socketClient.getRemoteSocketAddress().toString();
                pw.println("Bienvenue,Client " + numero);

                while(true) {   //Repondre et recevoir tant que le client est connecte
                    String req;
                    while ((req=in.readLine()) != null) {
                        System.out.println(ip + " a envoye " + req);
                        broadCast(req, socketClient, numero);
                    }
                    closeConversation(socketClient, in, pw);
                }
            } catch ( Exception e) {
                deconnect();
            }
        }

        public void deconnect() {
            try {
                clientConnectes.remove(this);
                System.out.println(" Client number " + numero + " has deconnected");
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void closeServer() {
        try {
            if(serverSocket != null) {
                serverSocket.close();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConversation( Socket socketClient, BufferedReader in, PrintWriter pw) {
        try {
            if ( socketClient != null) {
                socketClient.close();
            }
            if ( in != null ) {
                in.close();
            }
            if ( pw != null ) {
                pw.close();
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    } 
    public static void main( String [] args) {
        new Server().start();
    }
}