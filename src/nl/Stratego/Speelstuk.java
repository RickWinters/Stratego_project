package nl.Stratego;

public class Speelstuk {
    public int value;
    public String naam;

    public Speelstuk(int value, String naam){
        this.value = value;
        this.naam = naam;
    }
    public void Attack(){
        System.out.println("speelstuk valt aan");
    }
}
