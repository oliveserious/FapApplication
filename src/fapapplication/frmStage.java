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
 

public class frmStage extends JInternalFrame {

    
    private JButton btnNouveau = new JButton("Nouveau");
    private JButton btnQuitter = new JButton("Quitter");
    private JMenuItem menuItem1 = new JMenuItem("Copy");
    private JMenuItem menuItem2 = new JMenuItem("Cut");
    private JMenuItem menuItem3 = new JMenuItem("Paste");
    
    
    public frmStage() {
  
        super("Gestion des stages", 
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
      
            if (source == btnNouveau) btnNouveau_click();
          
        }
    } 
 
    private void initControls() {
        
        JPanel zoneTableau = (JPanel) this.getContentPane();
        zoneTableau.setLayout(new BorderLayout(10,10));
        zoneTableau.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        final Object rowData[][] = {/* { "1", "one", "I" }, { "2", "two", "II" }, { "3", "three", "III" }*/ };
        final String columnNames[] = { "IDSTAGE", "LIBSTAGE", "DUREESTAGE", "COUTSTAGE" };
        
        final JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        
        JPanel panBouton = new JPanel (new GridLayout(2,1,10,10));
        btnNouveau.addActionListener(new frmStage.MenuActionListener());
        panBouton.add (btnNouveau);
        btnQuitter.addActionListener(new frmStage.MenuActionListener());
        panBouton.add (btnQuitter);
        
        zoneTableau.add (scrollPane, BorderLayout.CENTER);
        zoneTableau.add (panBouton, BorderLayout.SOUTH);        
    }
    
}
