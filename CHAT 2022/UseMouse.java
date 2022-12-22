package ecouteur;

import java.awt.event.*;
import client.*;
import javax.swing.*;
import fenetre.*;
import server.*;

public class UseMouse implements MouseListener
{
    InterfaceClient fen;
    Client client;

    public UseMouse( InterfaceClient fen, Client client) {
        this.fen = fen;
        this.client = client;
    }

    public void mouseClicked( MouseEvent e ) {  //Ce qui se passe lorsqu'on clique sur la souris
        try {
                String mess = ((JTextField)fen.getContenu().getChamp().getChamp()).getText();
                client.sendMessage(mess, e, fen);
        } catch( Exception ex) {
            ex.printStackTrace();
        }
    }
    public void mousePressed(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
}