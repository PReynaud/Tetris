package TetrisModele;

import java.util.TimerTask;


public class ChuteBloc extends TimerTask{
    private Grille grille;
    private Modele modele;
    
    public ChuteBloc(Modele modele){
        this.modele = modele;
        this.grille = modele.getGrille();
    }
    
   public void tomber_bloc(){
        for (int i = this.grille.getX() - 1; i > 0; i--) {
            for (int j = this.grille.getY() - 1; j > 0; j--) {
                if(this.grille.getBloc(i, j).getActif()){
                    this.grille.getBloc(i + 1, j).setActif(true);
                    this.grille.getBloc(i + 1, j).setCouleur(1);
                    this.grille.getBloc(i, j).setActif(false);
                    this.grille.getBloc(i, j).setCouleur(0);
                }
            }
        }
        modele.majObservateur();
    }  

    @Override
    public void run() {
        tomber_bloc();
    }
}
