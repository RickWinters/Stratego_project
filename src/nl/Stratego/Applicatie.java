package nl.Stratego;

import java.util.Scanner;

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
        System.out.println(spelerBord);

        spelerBord.moveChooser(3,4,speler1);
        System.out.println(spelerBord);


    }
}
