package VueTetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.Border;

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
        JMenuBar Barre = new JMenuBar();
        JMenu Menu = new JMenu("Menu");
        JMenuItem ItemFermer = new JMenuItem("Fermer");

        Menu.add(ItemFermer);
        Barre.add(Menu);

        setJMenuBar(Barre);
        setTitle("");
        setSize(600, 600);
        
        BorderLayout bordure_grille = new BorderLayout();
        this.add(new GrilleGraphique(), BorderLayout.WEST);
        this.add(new Interface(), BorderLayout.EAST);
    }

    
}

