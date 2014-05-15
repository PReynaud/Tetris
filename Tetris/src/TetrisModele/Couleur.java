package TetrisModele;

import java.awt.Color;


public class Couleur {
    public int code;
    public String nom;
    public Color couleur;
    
    public Couleur(int i){
        if(i == 1){
            this.code = 1;
            this.nom = "noir";
            this.couleur = Color.BLACK;
        }
    }
    
    public Color getCouleur(){
        return this.couleur;
    }
}
