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
 

public class frmUpdStage extends JInternalFrame {

    
    private JButton btnOk = new JButton("Valider");
    private JButton btnQuitter = new JButton("Quitter");
    private JTextField txtLib = new JTextField(40);
    private JTextField txtCout = new JTextField(15);
    private JTextField txtDuree = new JTextField(6);
    
    public frmUpdStage() {
  
        super("Modification stage", 
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
        
        JPanel modSta = new JPanel(new GridLayout(10,1)); 
        modSta.add( new JLabel("Libellé:"));
        txtLib.setBounds (0,0,0,0);
        modSta.add (txtLib);
        modSta.add( new JLabel("Coût:"));
        txtCout.setBounds (0,0,0,0);
        modSta.add (txtCout);        
        modSta.add( new JLabel("Durée:"));
        txtDuree.setBounds (0,0,0,0);
        modSta.add (txtDuree);

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
        btnOk.addActionListener(new frmUpdStage.MenuActionListener());
        panBouton.add (btnOk);
        btnQuitter.addActionListener(new frmUpdStage.MenuActionListener());
        panBouton.add (btnQuitter);
        
//        zoneTableau.add( panComplet, BorderLayout.CENTER);
        zoneTableau.add (modSta, BorderLayout.CENTER);
        zoneTableau.add (panBouton, BorderLayout.SOUTH);
    
    }
    

  
}



