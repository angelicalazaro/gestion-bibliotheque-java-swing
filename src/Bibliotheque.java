import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// ActionListener exige actionPerformed(ActionEvent e)

//ItemListener exige itemStateChanged(ItemEvent e)
public class Bibliotheque extends JFrame implements ActionListener, ItemListener {
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
    private JLabel LListeLivres;
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
    private JComboBox<String> comboLivres;
    private ArrayList<Livre> LIV;

    // constructeur
    public Bibliotheque() {
        LIV = new ArrayList<>();

        LIV.add(new Livre(1, "Harry Potter", "Rowling", 10, 7));
        LIV.add(new Livre(2, "Le Seigneur des Anneaux", "Tolkien", 5, 0));
        LIV.add(new Livre(3, "1984", "Orwell", 8, 8));

        p1 = new JPanel();
        LCodeLivre = new JLabel("Code livre : ");
        TFcodeLivre = new JTextField("", 5);
        p1.add(LCodeLivre);
        p1.add(TFcodeLivre);
        p1.setBackground(new Color(145, 146, 207));

        p2 = new JPanel();
        LTitreLivre = new JLabel("Titre livre : ");
        TFtitreLivre = new JTextField("", 20);
        p2.add(LTitreLivre);
        p2.add(TFtitreLivre);

        p3 = new JPanel();
        LAuteur = new JLabel("Auteur :");
        TFauteur = new JTextField("", 20);
        p3.add(LAuteur);
        p3.add(TFauteur);

        p4 = new JPanel();
        LTotLiv = new JLabel("Nbr Tot Exemplaires :");
        TFtotLiv = new JTextField("", 10);
        p4.add(LTotLiv);
        p4.add(TFtotLiv);

        p5 = new JPanel();
        LLivDispo = new JLabel("Nbr Tot Disponible : ");
        TFlivDispo = new JTextField("", 10);
        p5.add(LLivDispo);
        p5.add(TFlivDispo);

        p6 = new JPanel();
        LListeLivres = new JLabel("Liste des livres : ");
        RBtous = new JRadioButton("Tous", true);
        RBempruntes = new JRadioButton("Empruntés");
        ButtonGroup groupe = new ButtonGroup();
        groupe.add(RBtous);
        groupe.add(RBempruntes);
        p6.add(LListeLivres);
        p6.add(RBtous);
        p6.add(RBempruntes);

        p7 = new JPanel();
        comboLivres = new JComboBox<>();
        BConsulter = new JButton("Consulter");
        p7.add(BConsulter);
        p7.add(comboLivres);

        p8 = new JPanel();
        BEmprunter = new JButton("Emprunter");
        BRendre = new JButton("Rendre");
        p8.add(BEmprunter);
        p8.add(BRendre);

        p9 = new JPanel();
        BEditer = new JButton("Editer");
        BAjouter = new JButton("Ajouter");
        BSupprimer = new JButton("Supprimer");
        BQuitter = new JButton("Quitter");
        p9.add(BEditer);
        p9.add(BAjouter);
        p9.add(BSupprimer);
        p9.add(BQuitter);

        BConsulter.addActionListener(this);
        BEmprunter.addActionListener(this);
        BEditer.addActionListener(this);
        BAjouter.addActionListener(this);
        BRendre.addActionListener(this);
        BSupprimer.addActionListener(this);
        BQuitter.addActionListener(this);

        RBtous.addItemListener(this);
        RBempruntes.addItemListener(this);

        this.setTitle("Gestion des Livres");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(9, 1));

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.add(p8);
        this.add(p9);

        this.setLocationRelativeTo(null);
        actualiserComboBox(true);
    }

    // Méthodes utilitaires -> fonctionnement des boutons

    private void actualiserComboBox(boolean tousLesLivres) {
        comboLivres.removeAllItems();

        for (Livre l : LIV) {
            if (tousLesLivres) {
                comboLivres.addItem(l.getCode() + " - " + l.getTitre());
            } else {
                if (l.getDispoLivres() < l.getTotalLivres()) {
                    comboLivres.addItem(l.getCode() + " - " + l.getTitre());
                }
            }
        }
    }

    private Livre trouverLivreParCode(int code) {
        for (Livre l : LIV) {
            if (l.getCode() == code) {
                return l;
            }
        }
        return null;
    }

    private Livre trouverLivreSelectionne() {
        String selection = (String) comboLivres.getSelectedItem();

        if (selection == null) {
            return null;
        }
        String[] parts = selection.split(" - ");
        int code = Integer.parseInt(parts[0]);

        return trouverLivreParCode(code);
    }

    private void viderChamps() {
        TFcodeLivre.setText("");
        TFtitreLivre.setText("");
        TFauteur.setText("");
        TFtotLiv.setText("");
        TFlivDispo.setText("");
    }

    private void afficherLivre(Livre l) {
        TFcodeLivre.setText(String.valueOf(l.getCode()));
        TFtitreLivre.setText(l.getTitre());
        TFauteur.setText(l.getAuteur());
        TFtotLiv.setText(String.valueOf(l.getTotalLivres()));
        TFlivDispo.setText(String.valueOf(l.getDispoLivres()));
    }

    public static void main(String[] args) {
        Bibliotheque MyBib = new Bibliotheque();
        MyBib.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BConsulter) {
            actualiserComboBox(RBtous.isSelected());
        }

        // BOUTON EDITER
        else if (e.getSource() == BEditer) {
            Livre livreSelectionne = trouverLivreSelectionne();

            if (livreSelectionne == null) {
                JOptionPane.showMessageDialog(this,
                        "Aucun livre n'est sélectionné !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                afficherLivre(livreSelectionne);
            }
        }

        // BOUTON AJOUTER
        else if (e.getSource() == BAjouter) {
            try {
                int code = Integer.parseInt(TFcodeLivre.getText());
                String titre = TFtitreLivre.getText();
                String auteur = TFauteur.getText();
                int total = Integer.parseInt(TFtotLiv.getText());
                int dispo = Integer.parseInt(TFlivDispo.getText());

                Livre nouveauLivre = new Livre(code, titre, auteur, total, dispo);
                LIV.add(nouveauLivre);

                actualiserComboBox(RBtous.isSelected());
                viderChamps();

                JOptionPane.showMessageDialog(this,
                        "Livre ajouté avec succès !",
                        "Succès",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Veuillez remplir tous les champs correctement !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // BOUTON SUPPRIMER
        else if (e.getSource() == BSupprimer) {
            Livre livreSelectionne = trouverLivreSelectionne();

            if (livreSelectionne == null) {
                JOptionPane.showMessageDialog(this,
                        "Aucun livre n'est sélectionné !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                LIV.remove(livreSelectionne);
                actualiserComboBox(RBtous.isSelected());
                viderChamps();

                JOptionPane.showMessageDialog(this,
                        "Livre supprimé avec succès !",
                        "Succès",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // BOUTON EMPRUNTER
        else if (e.getSource() == BEmprunter) {
            Livre livreSelectionne = trouverLivreSelectionne();

            if (livreSelectionne == null) {
                JOptionPane.showMessageDialog(this,
                        "Aucun livre n'est sélectionné !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                boolean succes = livreSelectionne.emprunter();

                if (succes) {
                    afficherLivre(livreSelectionne);
                    JOptionPane.showMessageDialog(this,
                            "Livre emprunté avec succès !",
                            "Succès",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Impossible d'emprunter : aucun exemplaire disponible !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // BOUTON RENDRE
        else if (e.getSource() == BRendre) {
            Livre livreSelectionne = trouverLivreSelectionne();

            if (livreSelectionne == null) {
                JOptionPane.showMessageDialog(this,
                        "Aucun livre n'est sélectionné !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                boolean succes = livreSelectionne.rendre();

                if (succes) {
                    afficherLivre(livreSelectionne);
                    JOptionPane.showMessageDialog(this,
                            "Livre rendu avec succès !",
                            "Succès",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Impossible de rendre : tous les exemplaires sont déjà en bibliothèque !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // BOUTON QUITTER
        else if (e.getSource() == BQuitter) {
            System.exit(0);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == RBtous || e.getSource() == RBempruntes) {
            actualiserComboBox(RBtous.isSelected());
        }
    }
}