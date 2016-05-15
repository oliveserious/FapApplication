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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oliver-dom
 */
//jdialog configuration ("about" window)
public class Apropos extends JDialog implements ActionListener {
    
    //Private specific fields jdialog "about"
    private JLabel lblDescription = new JLabel ();
    private JLabel lblCopyright = new JLabel ();
    private JLabel lblVersion = new JLabel () ;
    private JLabel lblIcone = new JLabel ();
    private JButton cmdOK = new JButton ("OK");
    
    //parameters jframe
    public Apropos(JFrame parent, String titre)
    {
        super(parent, "A Propos de " + titre, true);
        Point loc = parent.getLocation();
        this.setLocation((int) loc.getX()+50,(int)loc.getY()+100);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        initControls();
    }


    private void initControls()
    {
        JPanel zoneClient = (JPanel) this.getContentPane();
        zoneClient.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel panDroite = new JPanel (new GridLayout(3,1,10,10));
        panDroite.add (lblDescription);
        panDroite.add (lblCopyright);
        panDroite.add (lblVersion);
        JPanel panHaut = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panHaut.add (lblIcone);
        panHaut.add (panDroite);
        JPanel panBas = new JPanel (); // FlowLayout par défaut
        cmdOK.addActionListener(this); // Voir plus bas
        panBas.add(cmdOK);
        zoneClient.add (panHaut, BorderLayout.NORTH);
        zoneClient.add (panBas, BorderLayout.SOUTH);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cmdOK) this.dispose();
    }
    public void setDescription (String texte)
    {
        lblDescription.setText(texte);
        this.pack();
    }
    public void setVersion (String texte)
    {
        lblVersion.setText(texte);
        this.pack();
    }
    public void setCopyright (String texte)
    {
        lblCopyright.setText(texte);
        this.pack();
    }
    public void setIcone (String url)
    {
        lblIcone.setIcon(new ImageIcon(url));
        this.pack();
    }
}
