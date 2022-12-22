package boite;

import javax.swing.*;

public class Compone extends JComponent{
    JTextField inputText;
    JLabel lab;
    public Compone( JTextField fld, JLabel lb)
    {
        this.inputText = fld;
        this.lab = lb;
    }    
    public JTextField getInputText() { return this.inputText; }
    public JLabel getLab() { return this.lab; }
    public void setInputText( JTextField jt ) { this.inputText = jt; }
    public void setLab( JLabel jt ) { this.lab = jt; }
}