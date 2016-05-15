/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fapapplication;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
 

public class FramePanneau1 extends JInternalFrame {

    
    private JButton btnNouveau = new JButton("Nouveau");
    private JButton btnQuitter = new JButton("Quitter");

    
    public FramePanneau1() {
  
        super("Gestion des stages", 
            true, //resizable
            true, //closable
            true, //maximizable
            true);//iconifiable
            setSize(600,400);      
        
            initControls();
    }
 
    private void initControls() {
        
        JPanel zoneTableau = (JPanel) this.getContentPane();
        zoneTableau.setLayout(new BorderLayout(10,10));
        zoneTableau.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        
        final Object rowData[][] = { { "1", "one", "I" }, { "2", "two", "II" }, { "3", "three", "III" } };
        final String columnNames[] = { "#", "English", "Roman" };
        
        final JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel panBouton = new JPanel (new GridLayout(2,1,10,10));
        panBouton.add (btnNouveau);
        panBouton.add (btnQuitter);
        
        zoneTableau.add (scrollPane, BorderLayout.CENTER);
        zoneTableau.add (panBouton, BorderLayout.SOUTH);
    
    }
  
}
