/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * FAP application project
 * For more information on this code.... GO TO THE WEB !  
 */

//Application name
package fapapplication;

//Java Swing Library
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import static java.awt.SystemColor.desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author oliver-dom
 */

//Principal jframe application (principal window)
public class FenetrePrincipale extends JFrame { 
    
    //Private fields of the various objects (menu, buttons, text, etc...)
    private JMenuItem menuFichierQuitter = new JMenuItem("Quitter", 'Q');
    private JMenuItem menuDonneesStages = new JMenuItem("Stages", 'S');
    private JMenuItem menuDonneesEntreprises = new JMenuItem("Entreprises",'E');
    private JMenuItem menuDonneesTypes = new JMenuItem("Types");
    private JMenuItem menuEvenementsInscription = new JMenuItem("Inscription");
    private JMenuItem menuEvenementsAbsence = new JMenuItem("Absence");
    private JMenuItem menuEvenementsPaiement = new JMenuItem("Paiement");
    private JMenuItem menuAffichageOutils = new JMenuItem("Barre d'Outils");
    private JMenuItem menuAffichageEtat = new JMenuItem("Barre d'état");
    private JMenuItem menuFenetreCascade = new JMenuItem("En cascade");
    private JMenuItem menuFenetreHmozaique = new JMenuItem("Mozaïque horizontale");
    private JMenuItem menuFenetreVmozaique = new JMenuItem("Mozaïque verticale");
    private JMenuItem menuFenetreOrganise = new JMenuItem("Réorganiser les icones");
    private JMenuItem menuAideSommaire = new JMenuItem("Sommaire");
    private JMenuItem menuAideSiteweb = new JMenuItem("Aide sur ...");
    private JMenuItem menuAideApropos = new JMenuItem("A propos de");
    private JButton boutonAide = new JButton("Sommaire");
    private JLabel statusBar = new JLabel(" ");

    //Builder which defined initial status in jframe (principal window)  
    public FenetrePrincipale() {
        // initialization
        initMenu(); 
        initControls();
        
        
        //parameters jframe
        this.setSize(1000, 800);
        this.setTitle("FAP");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(true);
        
        //quit application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                if (JOptionPane.showConfirmDialog(null, "Aller voir ailleurs?", "NON!... SERIEUX?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
    }
      
    //Menus
    private void initMenu() {
        
        //Create menubar
        JMenuBar mbPrincipale = new JMenuBar();
        this.setJMenuBar(mbPrincipale);
        
        //Create menus with keyboard shortcut 
        JMenu menuFichier = new JMenu("Fichier");
        menuFichier.setMnemonic('F');
        mbPrincipale.add(menuFichier);
        JMenu menuDonnees = new JMenu("Données");
        menuDonnees.setMnemonic('D');
        mbPrincipale.add(menuDonnees);
        JMenu menuEvenements = new JMenu("Evénements");
        menuEvenements.setMnemonic('E');
        mbPrincipale.add(menuEvenements);
        JMenu menuAffichage = new JMenu("Affichage");
        menuAffichage.setMnemonic('H');
        mbPrincipale.add(menuAffichage);
        JMenu menuFenetre = new JMenu("Fenêtre");
        menuFenetre.setMnemonic('N');
        mbPrincipale.add(menuFenetre);
        JMenu menuAide = new JMenu("Aide");
        menuAide.setMnemonic('?');
        mbPrincipale.add(menuAide);
        
        //add the elements in menus + add actions listeners  + add events adpaters 
        menuFichierQuitter.addActionListener(new MenuActionListener());
        menuFichierQuitter.addMouseListener(new MenuMouseAdapter());
        menuFichier.add(menuFichierQuitter);
        menuDonneesStages.addActionListener(new MenuActionListener());
        menuDonneesStages.addMouseListener(new MenuMouseAdapter());
        menuDonnees.add(menuDonneesStages);
        menuDonneesEntreprises.addActionListener(new MenuActionListener());
        menuDonneesEntreprises.addMouseListener(new MenuMouseAdapter());
        menuDonnees.add(menuDonneesEntreprises);
        menuDonneesTypes.addActionListener(new MenuActionListener());
        menuDonneesTypes.addMouseListener(new MenuMouseAdapter());
        menuDonnees.add(menuDonneesTypes);   
        menuEvenementsInscription.addActionListener(new MenuActionListener());
        menuEvenementsInscription.addMouseListener(new MenuMouseAdapter());
        menuEvenements.add(menuEvenementsInscription);
        menuEvenementsAbsence.addActionListener(new MenuActionListener());
        menuEvenementsAbsence.addMouseListener(new MenuMouseAdapter());
        menuEvenements.add(menuEvenementsAbsence);
        menuEvenementsPaiement.addActionListener(new MenuActionListener());
        menuEvenementsPaiement.addMouseListener(new MenuMouseAdapter());
        menuEvenements.add(menuEvenementsPaiement); 
        menuAffichageOutils.addActionListener(new MenuActionListener());
        menuAffichageOutils.addMouseListener(new MenuMouseAdapter());
        menuAffichage.add(menuAffichageOutils);
        menuAffichageEtat.addActionListener(new MenuActionListener());
        menuAffichageEtat.addMouseListener(new MenuMouseAdapter());
        menuAffichage.add(menuAffichageEtat);        
        menuFenetreCascade.addActionListener(new MenuActionListener());
        menuFenetreCascade.addMouseListener(new MenuMouseAdapter());
        menuFenetre.add(menuFenetreCascade);
        menuFenetreHmozaique.addActionListener(new MenuActionListener());
        menuFenetreHmozaique.addMouseListener(new MenuMouseAdapter());
        menuFenetre.add(menuFenetreHmozaique);
        menuFenetreVmozaique.addActionListener(new MenuActionListener());
        menuFenetreVmozaique.addMouseListener(new MenuMouseAdapter());
        menuFenetre.add(menuFenetreVmozaique);
        menuFenetreOrganise.addActionListener(new MenuActionListener());
        menuFenetreOrganise.addMouseListener(new MenuMouseAdapter());
        menuFenetre.add(menuFenetreOrganise);             
        menuAideSommaire.addActionListener(new MenuActionListener());
        menuAideSommaire.addMouseListener(new MenuMouseAdapter());
        menuAide.add(menuAideSommaire);
        menuAideSiteweb.addActionListener(new MenuActionListener());
        menuAideSiteweb.addMouseListener(new MenuMouseAdapter());
        menuAide.add(menuAideSiteweb);
        menuAideApropos.addActionListener(new MenuActionListener());
        menuAideApropos.addMouseListener(new MenuMouseAdapter()); 
        menuAide.add(menuAideApropos);
    }
    
    //Action of menus elements 
    private void menuFichierQuitter_click() {
        if (JOptionPane.showConfirmDialog(null, "Aller voir ailleurs?", "NON!... SERIEUX?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }
    private void menuDonneesStages_click() {
//        frmStage framefrmStage = new frmStage();
//        framefrmStage.setVisible(true);
       
        
        
    }
    private void menuDonneesEntreprises_click() {
//        if 
//        }    
        
    }
    private void menuDonneesTypes_click() {
     
    }
    private void menuEvenementsInscription_click() {
        
    }
    private void menuEvenementsAbsence_click() {
        
    }
    private void menuEvenementsPaiement_click() {
        
    }
    private void menuAffichageOutils_click() {
        
    }
    private void menuAffichageEtat_click() {
        
    }
    private void menuFenetreCascade_click() {
        
    }
    private void menuFenetreHmozaique_click() {
        
    }
    private void menuFenetreVmozaique_click() {
        
    }
    private void menuFenetreOrganise_click() {
        
    }
    private void menuAideSommaire_click() {
        
    }
    private void menuAideSiteweb_click() {
        
    }
    private void menuAideApropos_click() {
        Apropos dlg = new Apropos(this, "FAP");
        dlg.setDescription("A description ... Oh shit!\n"
                            + "... I don't know.\n"
                            + "Really,  I've no idea.");
        dlg.setCopyright("LoliveSerious (c) 2016");
        dlg.setVersion("Version 1.0");
        dlg.setIcone("E:\\Documents\\NetBeansProjects\\FapApplication\\src\\img\\hatswtf.jpg");
        dlg.show();
    }  

    //A listener with actions on elements
    class MenuActionListener implements ActionListener {
        
        //A listener with actions
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == menuFichierQuitter) menuFichierQuitter_click();
            if (source == menuDonneesStages) menuDonneesStages_click();
            if (source == menuDonneesEntreprises) menuDonneesEntreprises_click();
            if (source == menuDonneesTypes) menuDonneesTypes_click();
            if (source == menuEvenementsInscription) menuEvenementsInscription_click();
            if (source == menuEvenementsAbsence) menuEvenementsAbsence_click();
            if (source == menuEvenementsPaiement) menuEvenementsPaiement_click();
            if (source == menuAffichageOutils) menuAffichageOutils_click();
            if (source == menuAffichageEtat) menuAffichageEtat_click();
            if (source == menuFenetreCascade) menuFenetreCascade_click();
            if (source == menuFenetreHmozaique) menuFenetreHmozaique_click();
            if (source == menuFenetreVmozaique) menuFenetreVmozaique_click();
            if (source == menuFenetreOrganise) menuFenetreOrganise_click();
            if (source == menuAideSommaire) menuAideSommaire_click();
            if (source == menuAideSiteweb) menuAideSiteweb_click();
            if (source == menuAideApropos) menuAideApropos_click();
      
            if (source == boutonAide) menuAideSommaire_click();
        }
    } 
    
    //A adapter with methods of displaying
    class MenuMouseAdapter extends MouseAdapter {
        
        //Display message on the statusBar 
        public void mouseEntered(MouseEvent e){
            Object source = e.getSource();
     
            if (source == menuFichierQuitter) statusBar.setText("Quitter FAP");
            if (source == menuDonneesStages) statusBar.setText("Gestion des stages");
            if (source == menuDonneesEntreprises) statusBar.setText("Gestion des entreprises");
            if (source == menuDonneesTypes) statusBar.setText("Gestion des types d'écriture");
            if (source == menuEvenementsInscription) statusBar.setText("Gestion des inscriptions");
            if (source == menuEvenementsAbsence) statusBar.setText("Gestion des absences");
            if (source == menuEvenementsPaiement) statusBar.setText("Gestion des paiements");
            if (source == menuAffichageOutils) statusBar.setText(" Afficher barre d'outils");
            if (source == menuAffichageEtat) statusBar.setText("Afficher barre d'état");
            if (source == menuFenetreCascade) statusBar.setText("Mode cascade");
            if (source == menuFenetreHmozaique) statusBar.setText("Mode mozaique horizontal");
            if (source == menuFenetreVmozaique) statusBar.setText("Mode mozaique vertical");
            if (source == menuFenetreOrganise) statusBar.setText("organiser les icones");
            if (source == menuAideSommaire) statusBar.setText("Rubriques d'aide");
            if (source == menuAideSiteweb) statusBar.setText("site web");
            if (source == menuAideApropos) statusBar.setText("A propos de FAP");

            if (source == boutonAide) statusBar.setText("Rubriques d'aide");
        }
        
        //Disappearance of message on the statusBar
        public void mouseExited(MouseEvent e)
        {
            statusBar.setText(" ");
        }
    }
    
    
    private void initControls() {
        
        
        JPanel affichagePrim = (JPanel) this.getContentPane();
        affichagePrim.setLayout(new BorderLayout(3, 3));
        affichagePrim.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        
        JDesktopPane affichageSec1 = new JDesktopPane();
        affichageSec1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        affichageSec1.setBackground(Color.darkGray);
        //create first "window"
        FramePanneau1 Pan1 = new FramePanneau1();
        Pan1.setVisible(true);
        affichageSec1.add(Pan1);
        try {
            Pan1.setSelected(true);
        }catch (java.beans.PropertyVetoException e) {} 
        //create first "window"
        FramePanneau2 Pan2 = new FramePanneau2();
        Pan2.setVisible(false);
        affichageSec1.add(Pan2);
        try {
            Pan2.setSelected(true);
        }catch (java.beans.PropertyVetoException e) {}       
    
        //toolBar 
        JToolBar toolbarPrim = new JToolBar();
        boutonAide.addActionListener(new MenuActionListener());
        boutonAide.addMouseListener(new MenuMouseAdapter());
        boutonAide.setToolTipText("Aide");
        toolbarPrim.add(boutonAide);       
        
        statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
        
        affichagePrim.add(toolbarPrim, BorderLayout.NORTH);
        affichagePrim.add(affichageSec1, BorderLayout.CENTER);
        affichagePrim.add(statusBar, BorderLayout.SOUTH);
        
        
//        setContentPane(desktop);
//        desktop.setLayout(new BorderLayout(-50, -50));
//        desktop.setBackground(Color.cyan);
//        
        
        
//        JPanel milieu = new JPanel();{
//            milieu.setBackground(Color.cyan);
//        }
//        zoneClient.add(milieu, BorderLayout.CENTER);
        
        
        
        
//        JDesktopPane desktop = new JDesktopPane();
//        setContentPane(desktop);
//        desktop.setBackground(Color.cyan);
//        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
//        //create first "window"
//        MyInternalFrame frametest = new MyInternalFrame();
//        frametest.setVisible(true);
//        desktop.add(frametest);
//        try {
//            frametest.setSelected(true);
//        }catch (java.beans.PropertyVetoException e) {}
    }
    
}

