package TetrisModele;

import java.util.Observable;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modele extends Observable implements Runnable {

    private Grille grille;
    private Joueur joueur;
    private Timer timer;
    private boolean joue;
    private boolean partie_en_cours;

    public Modele() {
        Grille g = new Grille(20, 10);
        this.grille = g;
        timer = new Timer();
        joueur = new Joueur();
        this.joue = true;
        this.partie_en_cours = true;
    }

    public Grille getGrille() {
        return this.grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean getJoue() {
        return this.joue;
    }

    public boolean getPartie_finie() {
        return this.partie_en_cours;
    }

    public boolean ajout_piece_grille(Piece une_piece, int x, int y) {
        une_piece.setX(x);
        une_piece.setY(y);

        if (MouvementPiece.test_collision(this.grille, une_piece.getPiece(), x, y)) {
            return false;
        }

        joueur.setPiece_en_cours(une_piece);
        majObservateur();
        return true;
    }

    public void majObservateur() {
        setChanged();
        notifyObservers();
    }

    @Override
    public void run() {
        this.timer.scheduleAtFixedRate(new ChutePiece(this), 1000, 1000);
        while (partie_en_cours) {
            while (joue) {
                if (joueur.getPiece_suivante() == null) {
                    joueur.setPiece_suivante(Piece.election_piece());
                }
                if (joueur.getPiece_en_cours() == null) {
                    joueur.setPiece_en_cours(joueur.getPiece_suivante());
                    if (!this.ajout_piece_grille(joueur.getPiece_en_cours(), 0, 5)) {
                        this.joue = false;
                        this.partie_en_cours = false;
                    }
                    joueur.setPiece_suivante(null);
                }
                while (joueur.getPiece_en_cours() != null && joueur.getPiece_suivante() != null) {
                    majObservateur();
                }
            }
        }
        try {
            synchronized (this) {
                this.timer.cancel();
                this.wait();
            }
        } catch (InterruptedException ex) {
            System.out.println("Erreur Game Over");
        }
    }

    public void afficher_grille() {
        for (int i = 0; i < this.grille.getX(); i++) {
            for (int j = 0; j < this.grille.getY(); j++) {
                System.out.print(this.grille.getBloc(i, j).getCouleur());
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void bouger_piece_gauche() {
        if (joue) {
            MouvementPiece.mouvement_gauche(this.grille, this.joueur.getPiece_en_cours());
        }
    }

    public void bouger_piece_droit() {
        if (joue) {
            MouvementPiece.mouvement_droit(this.grille, this.joueur.getPiece_en_cours());
        }
    }

    public void rotation_gauche() {
        if (joue) {
            MouvementPiece.rotation_gauche(this.grille, this.joueur.getPiece_en_cours());
        }
    }

    public void chute_rapide() {
        if (joue) {
            this.joueur.ajouterScore(MouvementPiece.chute_piece(this.grille, this.joueur.getPiece_en_cours()));
        }
    }

    public void pause() {
        this.joue = false;
        this.timer.cancel();
        this.timer.purge();
    }

    public void play() {
        this.joue = true;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new ChutePiece(this), this.joueur.getNiveau().getDelai(), this.joueur.getNiveau().getDelai());
    }

    public void conserver_piece() {
        if (this.joueur.getBonus() != 0) {
            if (this.joueur.getPiece_conservee() == null) {
                this.joueur.setPiece_conservee(this.joueur.getPiece_en_cours());
                this.joueur.setPiece_en_cours(null);
            } else {
                this.joueur.setPiece_en_cours(this.joueur.getPiece_conservee());
                this.joueur.setPiece_conservee(null);
                this.joueur.supprimerBonus();
            }
        }
    }
}
