package TetrisModele;

import Controleur.Controleur;
import javax.swing.*;
import VueTetris.*;

public class Tetris {

    public static void main(String[] args) {
        Modele jeu = new Modele();
        Controleur c = new Controleur(jeu);
        
        FenetrePrincipale fenetre = new FenetrePrincipale();
        fenetre.setVisible(true);//On la rend visible 
        fenetre.addKeyListener(c);
        
        jeu.addObserver(fenetre);
        jeu.run();
    } 
}
