package nl.Stratego;

import java.util.Scanner;

import static javax.swing.text.html.HTML.Tag.HEAD;

public class Applicatie {

    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer naam speler 1 in:");
        Speler speler1 = new Speler(scanner.nextLine(),0);
        System.out.print("Voer naam speler 2 in:");
        Speler speler2 = new Speler(scanner.nextLine(),1);

        System.out.println(speler1);
        System.out.println(speler2);

        Bord spelerBord = new Bord();

        spelerBord.bordPrinten();
        spelerBord.bordPrinten(0);

        speler1.beurt(spelerBord);
        System.out.println(spelerBord);




    }
}
