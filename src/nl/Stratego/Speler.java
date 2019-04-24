package nl.Stratego;

public class Speler {
    private long id;

    private String speler1;
    private int speler1wins;
    private int speler1losses;
    private boolean gewonnen;
    private int speler1team;


    public void beurt(){};





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpeler1() {
        return speler1;
    }

    public void setSpeler1(String speler1) {
        this.speler1 = speler1;
    }

    public int getSpeler1wins() {
        return speler1wins;
    }

    public void setSpeler1wins(int speler1wins) {
        this.speler1wins = speler1wins;
    }

    public int getSpeler1losses() {
        return speler1losses;
    }

    public void setSpeler1losses(int speler1losses) {
        this.speler1losses = speler1losses;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    public int getSpeler1team() {
        return speler1team;
    }

    public void setSpeler1team(int speler1team) {
        this.speler1team = speler1team;
    }
}
