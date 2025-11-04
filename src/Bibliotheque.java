import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// ActionListener exige actionPerformed(ActionEvent e)

//ItemListener exige itemStateChanged(ItemEvent e)
public class Bibliotheque extends JFrame implements ActionListener, ItemListener{
    // attributs
    // Panels
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JPanel p7;
    private JPanel p8;
    private JPanel p9;
    // labels
    private JLabel LCodeLivre;
    private JLabel LTitreLivre;
    private JLabel LAuteur;
    private JLabel LTotLiv;
    private JLabel LLivDispo;
    private JLabel LCodeLiv;
    // text field
    private JTextField TFcodeLivre;
    private JTextField TFtitreLivre;
    private JTextField TFauteur;
    private JTextField TFtotLiv;
    private JTextField TFlivDispo;
    // buttons
    private JButton BConsulter;
    private JButton BEmprunter;
    private JButton BRendre;
    private JButton BEditer;
    private JButton BAjouter;
    private JButton BSupprimer;
    private JButton BQuitter;
    // radio buttons
    private JRadioButton RBtous;
    private JRadioButton RBempruntes;
    // checkbox - combo
    private JCheckBox
    private ArrayList<Livre> LIV;

    // constructeur
    public Bibliotheque(){
        LIV = new ArrayList<>();
        p1 = new JPanel();
        LCodeLivre = new JLabel("Code livre : ");
        TFcodeLivre = new JTextField("", 5);
        BConsulter = new JButton("Consulter");
        p1.add(LCodeLivre);
        p1.add(TFcodeLivre);
        p1.add(BConsulter);
        p1.setBackground(new Color(145,146,207));
    }
    public static void main(String[] args)
    {
        Bibliotheque MyBib = new Bibliotheque();
        MyBib.setVisible(true);
    }
}