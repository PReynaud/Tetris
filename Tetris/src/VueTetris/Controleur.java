package VueTetris;

import TetrisModele.Modele;
import java.awt.event.KeyEvent;

public class Controleur {
    Modele modele;
    
    public Controleur(Modele m){
        this.modele = m;
    }

    void traiter_evenement(int keyChar) {
        switch (keyChar) {
            case KeyEvent.VK_LEFT:
                modele.bouger_piece_gauche();
                break;
            case KeyEvent.VK_RIGHT:
                modele.bouger_piece_droit();
                break;
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_P:
                break;    
        }
    }
}
