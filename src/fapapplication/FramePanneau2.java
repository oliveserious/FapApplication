/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fapapplication;

import javax.swing.JInternalFrame;
 

 
/* Used by InternalFrameDemo.java. */
public class FramePanneau2 extends JInternalFrame {
//    static int openFrameCount = 2;
//    static final int xOffset = 30, yOffset = 30;
 
    public FramePanneau2() {
//        super("Document #" + (++openFrameCount), 
        super("Gestion des Entreprises",    
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
 
        //...Create the GUI and put it in the window...
 
        //...Then set the window size or call pack...
        setSize(300,300);
 
        //Set the window's location.
//        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    }
}
