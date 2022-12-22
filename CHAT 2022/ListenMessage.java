package client;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import fenetre.InterfaceClient;

public class ListenMessage extends Thread {
    Socket socket;
    BufferedReader in;
    String reponse;
    InterfaceClient fen;


    public Socket getSocket() { return this.socket; }
    public String getReponse() { return this.reponse; }
    public void setSocket( Socket socket ) { this.socket = socket; }
    public void setReponse( String reponse ) { this.reponse = reponse; }


    public ListenMessage( Socket socket, InterfaceClient fen ) {
        this.socket = socket;
        this.fen = fen;
    }
    @Override 
    public void run() {
        try {
            while(socket.isConnected()) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String res;
                while( (res = in.readLine())!= null ) {
                    System.out.println(res);
                    reponse  = res;
                    fen.getContenu().getChamp().getLab().setText(reponse);
                }
            }
        } catch(Exception e) {
            closeEverything();
        }
    }

    public void closeEverything() {   //Manidy azy rehetra
        try {
            if ( in != null ) {
                in.close();
            }
            if ( socket != null ) {
                socket.close();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}