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
            this.couleur = new Color(0,0,0,0);
        }
        if(i == 1){
            this.code = 1;
            this.nom = "vert";
            this.couleur = Color.GREEN;
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
        if(i == 4){
            this.code = 4;
            this.nom = "jaune";
            this.couleur = Color.YELLOW;
        }
        if(i == 5){
            this.code = 5;
            this.nom = "cyan";
            this.couleur = Color.CYAN;
        }
        if(i == 6){
            this.code = 6;
            this.nom = "orange";
            this.couleur = Color.ORANGE;
        }
        if(i == 7){
            this.code = 7;
            this.nom = "magena";
            this.couleur = Color.MAGENTA;
        }
    }
    
    public Color getCouleur(){
        return this.couleur;
    }
    
    public int getCode(){
        return this.code;
    }
}
