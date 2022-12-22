package fenetre;

import javax.swing.*;
import java.awt.*;
import client.*;
import ecouteur.*;

public class InterfaceClient extends JFrame {

    Boite contenu = new Boite();
    Client client;

    public InterfaceClient( Client client) {
        this.client = client;

        this.add(contenu);
        this.contenu.getEnvoi().getButton().addMouseListener(new UseMouse(this, client));
        //this.setFocusable(true);
        this.setSize(400, 600);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

///Getters et setters
    public Boite getContenu() { return this.contenu; }
    public Client getClient() { return this.client; }

}