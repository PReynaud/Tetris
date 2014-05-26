package TetrisModele;

public class Niveau {

    private int numero_niveau;
    private int delai;
    private int score_a_atteindre;
    private int bonus;

    public Niveau(int niveau, int delai, int score_a_atteindre, int bonus) {
        this.numero_niveau = niveau;
        this.delai = delai;
        this.score_a_atteindre = score_a_atteindre;
        this.bonus = bonus;
    }
    
    public int getNumeroNiveau() {
        return numero_niveau;
    }

    public int getDelai() {
        return delai;
    }

    public int getScore_a_atteindre() {
        return score_a_atteindre;
    }

    public int getBonus() {
        return bonus;
    }

    public void setNumeroNiveau(int niveau) {
        this.numero_niveau = niveau;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public void setScore_a_atteindre(int score_a_atteindre) {
        this.score_a_atteindre = score_a_atteindre;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
     
}
