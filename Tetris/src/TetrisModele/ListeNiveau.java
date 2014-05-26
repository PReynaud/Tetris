package TetrisModele;

import java.util.ArrayList;

public class ListeNiveau {
    private ArrayList<Niveau> liste;
    
    public ListeNiveau(){
        this.liste = new ArrayList<Niveau>();
        Niveau n1 = new Niveau(1, 1000, 0, 3);
        this.liste.add(n1);
        Niveau n2 = new Niveau(2, 800, 200, 3);
        this.liste.add(n2);
        Niveau n3 = new Niveau(3, 700, 500, 3);
        this.liste.add(n3);
        Niveau n4 = new Niveau(4, 600, 1000, 2);
        this.liste.add(n4);
        Niveau n5 = new Niveau(5, 500, 1500, 2);
        this.liste.add(n5);
        Niveau n6 = new Niveau(6, 400, 3000, 2);
        this.liste.add(n6);   
        Niveau n7 = new Niveau(7, 300, 5000, 1);
        this.liste.add(n7);  
        Niveau n8 = new Niveau(8, 200, 10000, 1);
        this.liste.add(n8);  
        Niveau n9 = new Niveau(9, 150, 20000, 1);
        this.liste.add(n9);  
        Niveau n10 = new Niveau(10, 100, 50000, 0);
        this.liste.add(n10);  
    }

    public Niveau getIemeNiveau(int i) {
        return this.liste.get(i);
        
    }
    
    
}
