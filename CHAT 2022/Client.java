package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import fenetre.InterfaceClient;

public class Client {
    Socket socket;
    String nom;
    PrintWriter pw;
    Scanner sc = new Scanner(System.in);


    public String getNom() { return this.nom; }
    public Socket getSocket() { return this.socket; }
    public void setname( String nom ) { this.nom = nom; }
    public void setSocket( Socket socket) {  this.socket = socket;}

    public Client( Socket socket, String name) {
        this.socket = socket;
        this.nom = name;
    }
    
    public void sendMessage( String mess, MouseEvent e, InterfaceClient fen) { 
        try {
                if ( e.getSource() == fen.getContenu().getEnvoi().getButton()) {
                    pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println(mess);
                }
        } catch(Exception ex) {
            closeEverything();
        }
    }
    
    public void closeEverything()  { 
        try {
            if ( pw != null) {
                pw.close();
            }
            if ( sc != null ) {
                sc.close();
            }
            if ( socket != null ) {
                socket.close();
            }
            System.out.println("Server deconnecte");
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}