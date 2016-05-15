/*
 *
 * FAP application project - The code in this file start the application.
 * For more information on this code.... GO TO THE WEB !  
 */

//Application name
package fapapplication;

//Java Swing Library
import fapapplication.FenetrePrincipale;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author loliveserious
 */
public class FapApplication { //this class containing static main method, the entry point of application which defined the "look and feel"

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true) ;
            }
        catch(Exception e) { }
        new FapApplication ();
    }
    
    // this is a builder which create a new object
    public FapApplication() {
        FenetrePrincipale frame = new FenetrePrincipale(); //new JFrame 
        frame.setVisible(true);      
    }    
}
