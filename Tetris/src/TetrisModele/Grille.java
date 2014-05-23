package TetrisModele;

public class Grille {

    private Bloc[][] grille_jeu;
    private int x;
    private int y;
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public Grille(int longueur, int largeur) {
        this.grille_jeu = new Bloc[longueur][largeur];
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.grille_jeu[i][j] = new Bloc(i, j, new Couleur(0), false);
            }
        }
        this.x = longueur;
        this.y = largeur;
    }

    public Bloc getBloc(int x, int y){
        return this.grille_jeu[x][y];
    }
    
    public void suppression_ligne(){
        int longueur_grille = getX();
        int largeur_grille = getY();
        boolean ligne_sup = false;
        int[] tab_lignes = new int[longueur_grille];
        for(int i = 0; i < longueur_grille; i++){
            tab_lignes[i] = 0;
        }
        
        /*On va parcourir une première fois la grille pour vérifier si il y a des lignes à vide*/
        for(int i = 0; i < longueur_grille; i++){
            boolean ligne_pleine = true;
            for(int j = 0; j < largeur_grille; j++){
                if(!getBloc(i, j).avoirCouleur())
                    ligne_pleine = false;
            }
            if(ligne_pleine){
                ligne_sup = true;
                for(int k = 0; k < i; k++){
                    tab_lignes[k] += 1;
                }
            }
        }
        
        /*On descend les lignes qui sont présentes au-dessus des lignes pleines*/
        if(ligne_sup){
            for(int i = longueur_grille - 1; i > 0; i--){
                if(tab_lignes[i] != 0){
                   for(int j = 0; j < largeur_grille; j++){
                       getBloc(i + tab_lignes[i], j).setCouleur(getBloc(i, j).getCouleur());
                    } 
                }
            }
        }
        
    }
}
