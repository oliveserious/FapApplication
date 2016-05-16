/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fapapplication;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 *
 * @author oliver-dom
 */


public class frmSommaire extends JFrame {
           
    BufferedImage img;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 
    public frmSommaire() {
        //parameters jframe
        this.setSize(1024, 768);
        this.setTitle("Rubriques d'aide");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
       try {
           img = ImageIO.read(new File("E:\\Documents\\NetBeansProjects\\FapApplication\\src\\img\\help.jpeg"));
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
 
    
}


 
 
