package nl.Stratego;

import java.util.List;
import java.util.Random;

public class Bord {

    private long id;
    private String naam;

    int[][] SpeelStukken = new int [10][10];

    public Bord(){
        List<Speelstuk> team1 //
        List<Speelstuk> team2 //
        Random rand = new Random();
        for (int x = 0;x < 4; x++){
            for (int y = 0; y<10; y++){
                int ind = rand.nextInt(team1.size());
                SpeelStukken[x][y] = team1[ind];
                team1.remove(ind);
            }
        }

    }

    //methodes
    //check inbouwen voor move functie vlag en bom + checkbound
    public void move(){
        System.out.println("het spelstuk beweegt naar");
    }

    public void print(){
        System.out.println("print het bord");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int[][] getSpeelStukken() {
        return SpeelStukken;
    }

    public void setSpeelStukken(int[][] speelStukken) {
        SpeelStukken = speelStukken;
    }
}


