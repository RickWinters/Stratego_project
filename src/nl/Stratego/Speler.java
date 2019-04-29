package nl.Stratego;

public class Speler {
    private long id;

    private String spelerNaam;
    private int spelerWins;
    private int spelerLosses;
    private int spelerTeam;
    private boolean gewonnen;

    public void beurt(){};

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
