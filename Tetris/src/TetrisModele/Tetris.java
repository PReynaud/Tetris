package TetrisModele;

import javax.swing.*;
import VueTetris.*;

public class Tetris {


    public static void main(String[] args) {
        Modele jeu = new Modele();
        Controleur c = new Controleur(jeu);
        Clavier cl = new Clavier(c);
        
        FenetrePrincipale fenetre = new FenetrePrincipale();
        fenetre.setVisible(true);//On la rend visible 
        fenetre.addKeyListener(cl);
        
        jeu.addObserver(fenetre);
        jeu.run();
    } 
}
