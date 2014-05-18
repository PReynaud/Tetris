package VueTetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{
    private Controleur controleur;
    
    public Clavier(Controleur c){
        this.controleur = c;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        controleur.traiter_evenement(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
