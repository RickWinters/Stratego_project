package nl.Stratego;

public class Applicatie {

    public static void main(String[] args) {


        Speler speler1 = new Speler("piet");
        Speler speler2 = new Speler("henk");

        Bord spelerBord = new Bord();
        System.out.println(spelerBord);
        spelerBord.move(3,4,4,4);
        System.out.println(spelerBord);


    }
}
