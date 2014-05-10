package Tetris;

import javax.swing.*;
import VueTetris.*;

public class Tetris {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
        public void run(){
                FenetrePrincipale fenetre = new FenetrePrincipale();
                fenetre.setVisible(true);//On la rend visible
        }
      });
    } 
}
