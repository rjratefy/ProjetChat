package affichage;

import fenetre.*;
import client.*;
import server.*;
import java.net.Socket;

public class Main{
    public static void main( String [] args ) throws Exception {
        Socket socket = new Socket("localhost", 1234);
        String nom = "jaona";
        Client client = new Client(socket, nom);
        InterfaceClient interfaceClient  = new InterfaceClient(client);
        ListenMessage listenMess = new ListenMessage(socket, interfaceClient);
        listenMess.start();
    }
}
