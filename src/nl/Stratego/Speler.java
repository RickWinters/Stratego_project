package nl.Stratego;

public class Speler {
    private long id;

    private String speler1;
    private int speler1wins;
    private int speler1losses;
    private boolean gewonnen;
    private int speler1team;

    private String speler2;
    private int speler2wins;
    private int speler2losses;
    private int speler2team;

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

    public String getSpeler2() {
        return speler2;
    }

    public void setSpeler2(String speler2) {
        this.speler2 = speler2;
    }

    public int getSpeler2wins() {
        return speler2wins;
    }

    public void setSpeler2wins(int speler2wins) {
        this.speler2wins = speler2wins;
    }

    public int getSpeler2losses() {
        return speler2losses;
    }

    public void setSpeler2losses(int speler2losses) {
        this.speler2losses = speler2losses;
    }

    public int getSpeler2team() {
        return speler2team;
    }

    public void setSpeler2team(int speler2team) {
        this.speler2team = speler2team;
    }
}
