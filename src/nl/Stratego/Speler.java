package nl.Stratego;

import java.util.Scanner;

public class Speler {
    private long id;

    private String speler;
    private int spelerwins;
    private int spelerlosses;
    private int spelerteam;
    private boolean gewonnen;

    public void beurt() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("voer coordinaten in om te selecteren welke speelstuk je wilt bewegen");
                String antwoord = scanner.nextLine();
                int coords = Integer.parseInt(antwoord);
                /*
                convert antwoord naar integers,
                gebruik integers als coordinaten
                vraag bord of het mogelijk is (rickloop)
                
                 */
                break;
            }
            catch (Exception e){
                    System.out.println();
            }
        }
    }


    public Speler(String speler) {
        this.speler = speler;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpeler() {
        return speler;
    }

    public void setSpeler(String speler) {
        this.speler = speler;
    }

    public int getSpelerwins() {
        return spelerwins;
    }

    public void setSpelerwins(int spelerwins) {
        this.spelerwins = spelerwins;
    }

    public int getSpelerlosses() {
        return spelerlosses;
    }

    public void setSpelerlosses(int spelerlosses) {
        this.spelerlosses = spelerlosses;
    }

    public int getSpelerteam() {
        return spelerteam;
    }

    public void setSpelerteam(int spelerteam) {
        this.spelerteam = spelerteam;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }
}
