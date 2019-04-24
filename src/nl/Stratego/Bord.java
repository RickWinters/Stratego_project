package nl.Stratego;

public class Bord {

    private long id;
    private String naam;

    int[][] SpeelStukken = new int [10][10];

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

    public Bord() {
    }
}


