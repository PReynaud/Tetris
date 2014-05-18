package TetrisModele;

import java.awt.Color;


public class Couleur {
    private int code;
    private String nom;
    private Color couleur;
    
    public Couleur(int i){
         if(i == 0){
            this.code = 0;
            this.nom = "blanc";
            this.couleur = Color.WHITE;
        }
        if(i == 1){
            this.code = 1;
            this.nom = "noir";
            this.couleur = Color.BLACK;
        }
        if(i == 2){
            this.code = 2;
            this.nom = "rouge";
            this.couleur = Color.RED;
        }
        if(i == 3){
            this.code = 3;
            this.nom = "bleu";
            this.couleur = Color.BLUE;
        }
        
    }
    
    public Color getCouleur(){
        return this.couleur;
    }
    
    public int getCode(){
        return this.code;
    }
}
