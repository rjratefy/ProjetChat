package fenetre;

import javax.swing.*;
import java.awt.*;
import boite.*;

public class Boite extends JPanel {
    Champ champ;
    Envoyer mandefa;
    public Boite() {
        champ = new Champ("Message");
        mandefa = new Envoyer("Send");
        this.add(champ.getChamp());
        this.add(champ.getLab());
        this.add(mandefa.getButton());
        this.setBounds(0, 0, 400, 600);
        this.setLayout(null);
        this.setBackground(Color.BLUE);
    }

    public Champ getChamp() {return this.champ; }
    public Envoyer getEnvoi() {return this.mandefa; }
    public void setChamp( Champ champ ) { this.champ = champ; }
    public void setEnvoi( Envoyer mandefa ) { this.mandefa =mandefa; }
}