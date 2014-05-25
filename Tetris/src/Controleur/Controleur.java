package Controleur;

import TetrisModele.Modele;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controleur implements KeyListener {

    Modele modele;

    public Controleur(Modele m) {
        this.modele = m;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        this.traiter_evenement(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    private void traiter_evenement(int keyChar) {
        switch (keyChar) {
            case KeyEvent.VK_LEFT:
                modele.bouger_piece_gauche();
                break;
            case KeyEvent.VK_RIGHT:
                modele.bouger_piece_droit();
                break;
            case KeyEvent.VK_UP:
                modele.rotation_gauche();
                break;
            case KeyEvent.VK_DOWN:
                modele.chute_rapide();
                break;
            case KeyEvent.VK_P:
                modele.pause();
                break;
            case KeyEvent.VK_SPACE:
                modele.conserver_piece();
                break;
        }
    }
}
