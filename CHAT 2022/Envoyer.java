package boite;

import javax.swing.*;
import java.awt.*;

public class Envoyer extends JButton {
    JButton button;
    public Envoyer(String envoyer) {
        setBounds(10, 400, 100, 100);
        button = new JButton(envoyer);
        this.button.setBounds(310, 500, 70, 50);
    }

    public JButton getButton() { return this.button; }
    public void setButton( JButton button ) {this.button = button;}
}
