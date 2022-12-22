package boite;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;
import java.util.Vector;

public class Champ extends JComponent {
    JComponent champ;
    JLabel lab;
    Vector<JLabel> labeli;
    String label;
    boolean visible = true;
    public Champ(){}
    public Champ(String label) 
    {
        setBounds(0, 0, 400, 600);
        setBackground(Color.RED);
        setLayout(null);

        champ = new JTextField();
        champ.setBounds(10, 500, 300, 50);
        lab = new JLabel(label);
        lab.setBounds(1, 1, 300, 100);
        setLabel(label);
    }

    // Les getters et les setters
    public JComponent getChamp() { return this.champ; }
    public JLabel getLab() { return this.lab; }
    public String getLabel() { return this.label; }
    public boolean getVisible() { return this.visible; }
    public Vector<JLabel> getLabeli() { return this.labeli; }

    public void setChamp(JComponent jc) { this.champ = jc; }
    public void setLab(JLabel lab) { this.lab = lab; }
    public void setLabel(String text) {
        this.label = text;
    }
    public void setVisible( boolean v) { this.visible = v; }
    public void setLabeli( Vector<JLabel> labeli) { this.labeli = labeli; }
}