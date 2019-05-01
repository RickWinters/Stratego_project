package nl.Stratego;

import java.util.Scanner;

public class Speler {
    private Scanner scanner = new Scanner; // een scanner aanmaken zodat om user input gevraagd kan worden
    private long id;

    private String spelerNaam;
    private int spelerWins;
    private int spelerLosses;
    private int spelerTeam;
    private boolean gewonnen;

    public void beurt() {
        //Eerst vragen om de x locatie van het pion dat je wilt verplaatsten
        while(true){
            try {
                System.out.println("geef de X locatie van de pion dat je wilt verplaatsen");
                int X = scanner.nextInt();
                System.out.println("geef de Y locatie van de pion dat je wilt verplaatsen");
                int Y = scanner.nextInt();
                if (X < 1 || X > 11){throw new InvalidInputException()};
                break;
            }
            catch (InvalidInputException IIE){
                System.out.println("Verkeerde waarde ingevoerd ");
            }
        }
    }


    public Speler(String spelerNaam,int spelerTeam) {
        this.spelerNaam = spelerNaam;
        this.spelerTeam = spelerTeam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpeler() {
        return spelerNaam;
    }

    public void setSpeler(String speler) {
        this.spelerNaam = speler;
    }

    public int getSpelerWins() {
        return spelerWins;
    }


    public void setSpelerWins(int spelerWins) {
        this.spelerWins = spelerWins;
    }

    public int getSpelerLosses() {
        return spelerLosses;
    }

    public void setSpelerLosses(int spelerLosses) {
        this.spelerLosses = spelerLosses;
    }

    public int getSpelerTeam() {
        return spelerTeam;
    }

    public void setSpelerTeam(int spelerteam) {
        this.spelerTeam = spelerteam;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    @Override
    public String toString() {
        return "Speler{" +
                "Naam='" + spelerNaam + '\'' +
                ", Team=" + (spelerTeam==0 ? "Red":"Blue") +
                '}';
    }
}
