/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VueTetris;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author p1105624
 */
public class FenetrePrincipale extends JFrame {

    public FenetrePrincipale() {
        super();
        
        build();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
        
        
    }
    
    public void build() {
        

        //JMenu jm = new JMenu();
        JMenuBar jm = new JMenuBar();
        
        JMenu m = new JMenu("Menu");
        
        JMenuItem mi = new JMenuItem("Fermer");
        
        //ItemListener i = new Item
        
        m.add(mi);
        
        jm.add(m);
        
       
        
        setJMenuBar(jm);
        
        
        setTitle("");
        setSize(400, 400);
        JComponent pan = new JPanel (new GridLayout(10,10));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);

        for(int i = 0; i<100;i++){
            JComponent ptest = new Case();
            ptest.setBorder(blackline);
            pan.add(ptest);
        }
        pan.setBorder(blackline);
        add(pan);
        //setContentPane(pan);

        
        
        
    }

    
}

