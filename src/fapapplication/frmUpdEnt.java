/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fapapplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 

public class frmUpdEnt extends JInternalFrame {

    
    private JButton btnOk = new JButton("Valider");
    private JButton btnQuitter = new JButton("Quitter");
    private JTextField txtRS = new JTextField(40);
    
    public frmUpdEnt() {
  
        super("Modification Entreprise", 
            true, //resizable
            true, //closable
            true, //maximizable
            true);//iconifiable

            setSize(600,400);      
        
            initControls();

    }
    
    private void btnNouveau_click() {

    }
   
    
    class MenuActionListener implements ActionListener {
        
        //A listener with actions
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
      
            if (source == btnOk) btnNouveau_click();
          
        }
    } 
 
    private void initControls() {
        
        JPanel zoneTableau = (JPanel) this.getContentPane();
        zoneTableau.setLayout(new BorderLayout(5,5));
        zoneTableau.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        JPanel modEnt = new JPanel(new GridLayout(10,1)); 
        modEnt.add( new JLabel("Libellé:"));
        txtRS.setBounds (0,0,0,0);
        modEnt.add (txtRS);
        
//        JPanel labModG = new JPanel();
//        labModG.setLayout(new BoxLayout(labModG, BoxLayout.Y_AXIS ));
//        labModG.add( new JLabel("Libellé:")); 
//        labModG.add( new JLabel("Coût:"));
//        labModG.add( new JLabel("Durée:"));
// 
//        JPanel labModD = new JPanel();
//        labModD.setLayout(new BoxLayout(labModD, BoxLayout.Y_AXIS ));
//        labModD.add( new JTextField());
//        labModD.add( new JTextField());
//        
//        JPanel panComplet = new JPanel();
//        panComplet.setLayout(new BoxLayout(panComplet, BoxLayout.X_AXIS ));
//        panComplet.add(labModG);
//        panComplet.add(labModD);

        
        
        
        JPanel panBouton = new JPanel (new GridLayout(2,1,10,10));
        btnOk.addActionListener(new frmUpdEnt.MenuActionListener());
        panBouton.add (btnOk);
        btnQuitter.addActionListener(new frmUpdEnt.MenuActionListener());
        panBouton.add (btnQuitter);
        
//        zoneTableau.add( panComplet, BorderLayout.CENTER);
        zoneTableau.add (modEnt, BorderLayout.CENTER);
        zoneTableau.add (panBouton, BorderLayout.SOUTH);
    
    }
    

  
}



