package nl.Stratego;

public class Speelstuk {
    long id;
    private int value;
    private String naam;

    public Speelstuk(int value, String naam){
        this.value = value;
        this.naam = naam;
    }
    public void Attack(){
        System.out.println("speelstuk valt aan");
    }

    public void Attack(Speelstuk enemy){
        if(enemy.getValue() <= this.value){
            System.out.println("aanvaller heeft gewonnen");
        } else {
            System.out.println("verdediger heeft gewonnen");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
