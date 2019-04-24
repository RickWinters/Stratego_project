package nl.Stratego;

import nl.Stratego.Speelstukken.Bom;

import java.util.ArrayList;
import java.util.List;

public class Speelstuk {
    long id;
    private int value;
    private String naam;
    private int team;

    public Speelstuk(int team,int value, String naam){
        this.team = team;
        this.value = value;
        this.naam = naam;
    }

    public Object Teamstukken (int team){
        List Teamstukken = new ArrayList();
        Teamstukken.add(new Bom(team));
        Teamstukken.add(new Bom(team));


        return Teamstukken;
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
