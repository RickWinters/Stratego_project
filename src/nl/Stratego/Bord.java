package nl.Stratego;

import nl.Stratego.Speelstukken.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bord {
    //variables
    private long id;
    private String naam = "default";
    Object[][] speelBord = new Object[10][10];
    private Blokkade blokkade = new Blokkade();
    //Constructor(s), de default constructor
    public Bord(){
        List<Speelstuk> team1 = this.createteam(0); //De tijdelijk functie om een team aan te maken aante roepen
        List<Speelstuk> team2 = this.createteam(1); //
        Random rand = new Random();
        for (int y = 0;y < 4; y++){ //het bord vullen
            for (int x = 0; x<10; x++){
                int ind = rand.nextInt(team1.size());
                speelBord[y][x] = team1.get(ind);
                team1.remove(ind);

                ind = rand.nextInt(team2.size()); //dit kan gelijk voor team 2, de x coordinaat wordt alleen met 6 verhoogd.
                speelBord[y+6][x] = team2.get(ind);
                team2.remove(ind);

            }
        }
        //hardcoded blokkades
        speelBord[4][2] = blokkade; //coordinaten 5,3
        speelBord[4][3] = blokkade; //coordinaten 5,4
        speelBord[5][2] = blokkade;
        speelBord[5][3] = blokkade;
        speelBord[4][6] = blokkade;
        speelBord[4][7] = blokkade;
        speelBord[5][6] = blokkade;
        speelBord[5][7] = blokkade;
    }


    //Methode voor het maken van 40 speelstukken
    public List<Speelstuk> createteam (int team){
        List<Speelstuk> Teamstukken = new ArrayList<>();
        //Elk stuk krijgt een apart object en daarom worden 40 stukken gemaakt hieronder. Deze krijgen allemaal
        //het teamnummer mee zodat er onderscheid gemaakt kan worden.
        for (int i = 0; i<6;i++) Teamstukken.add(new Bom(team));
        Teamstukken.add(new Maarschalk(team));
        Teamstukken.add(new Generaal(team));
        for (int i = 0; i<2;i++) Teamstukken.add(new Kolonel(team));
        for (int i = 0; i<3;i++) Teamstukken.add(new Majoor(team));
        for (int i = 0; i<4;i++) Teamstukken.add(new Kapitein(team));
        for (int i = 0; i<4;i++) Teamstukken.add(new Luitenant(team));
        for (int i = 0; i<4;i++) Teamstukken.add(new Sergeant(team));
        for (int i = 0; i<5;i++) Teamstukken.add(new Mineur(team));
        for (int i = 0; i<8;i++) Teamstukken.add(new Verkenner(team));
        Teamstukken.add(new Spion(team));
        Teamstukken.add(new Vlag(team));
        return Teamstukken;
    }

    //method for asking pion (int y, int x)
        // calls method if pion is own team
        // calls method if pion can move in any direction

    //method for checking if pion is of own team and movable



    public void move(int pionYLocation, int pionXLocation) {
        //Voordat een pion bewogen mag worden, wordt eerst gecheckt of deze wel daadwerkelijk mag bewegen.
        //Als het goed is wordt dat al gecheckt in de code bij het kiezen van de pion. Echter moet ik wel
        //een Stringmatrix terug krijgen om de beweging daadwerklijk uit te voeren. Ook zouden wel de matrix
        //in de methodes doorgeven. Dit is dus tijdelijk wel een goede oplossing imo.
        List<String> beweegRichtingMatrix;
        while (true) {
            try {
                //Test of de pion wel in een richting bewogen kan worden. Als dat correct is dan gaat de code verder
                beweegRichtingMatrix = movementCheck(pionYLocation,pionXLocation);
                break;
            } catch (noAvailableMovementException e) {
                System.out.println("Deze pion kan je in geen enekele richting bewegen");
            }

        }

        while(true) {
            Scanner scanner = new Scanner(System.in);
            try {
                //De scanner wordt gecheckt of deze wel een van de geldige opties bevat.
                //Als dat niet zo is dan blijft hij in de while loop. Anders doorloopt hij de code en breakt hij.
                String movementDirection = scanner.next();
                if (!beweegRichtingMatrix.contains(movementDirection)){
                    throw new noViableOption();
                }

                //Vervolgens wordt de locatie aangepast afhankelijk van de user input
                switch (movementDirection){
                    case "u":
                        speelBord[pionYLocation-1][pionXLocation] = speelBord[pionYLocation][pionXLocation];
                        speelBord[pionYLocation][pionXLocation] = null;
                        break;
                    case "d":
                        speelBord[pionYLocation+1][pionXLocation] = speelBord[pionYLocation][pionXLocation];
                        speelBord[pionYLocation][pionXLocation] = null;
                        break;
                    case "r":
                        speelBord[pionYLocation][pionXLocation+1] = speelBord[pionYLocation][pionXLocation];
                        speelBord[pionYLocation][pionXLocation] = null;
                        break;
                    case "l":
                        speelBord[pionYLocation][pionXLocation-1] = speelBord[pionYLocation][pionXLocation];
                        speelBord[pionYLocation][pionXLocation] = null;
                        break;
                    default:
                        //Deze optie zorgt ervoor dat als er een input als "dr" gekozen wordt er ook een error
                        //gegeven wordt.
                        throw new noViableOption();
                }

                break;
            } catch (noViableOption es){
                System.out.println("This is not a viable option, choose from: "+beweegRichtingMatrix);
            }
        }


    }

    public List<String> movementCheck (int pionYLocation, int pionXLocation) throws noAvailableMovementException{
        //beweegRichting wordt gebruikt om de gebruiker te laten zien welke kanten hij kan op bewegen
        //beweegRichtingMatrix wordt gebruikt om in het programma door te geven welke richtingen mogelijk zijn.
        StringBuilder beweegRichting = new StringBuilder();
        List<String> beweegRichtingMatrix = new ArrayList<>();

        //Als eerst wordt gecheckt of de positie niet out of bounds kan gaan
        if (pionYLocation!=0) {
            //Vervolgens wordt gecheckt of de positie met een verplaatsing (in dit geval y-omhoog) wel leeg is)
            if (speelBord[pionYLocation - 1][pionXLocation] == null) {
                beweegRichting.append("[Up (u)]");
                beweegRichtingMatrix.add("u");

            }
        }
        if (pionYLocation!=10) {
            if (speelBord[pionYLocation + 1][pionXLocation] == null) {
                beweegRichting.append(("[Down (d)]"));
                beweegRichtingMatrix.add("d");
            }
        }
        if (pionXLocation!=10) {
            //Vervolgens wordt gecheckt of de positie met een verplaatsing (in dit geval x-rechts) wel leeg is)
            if (speelBord[pionYLocation][pionXLocation + 1] == null) {
                beweegRichting.append(("[Right (r)]"));
                beweegRichtingMatrix.add("r");
            }
        }
        if (pionXLocation!=0) {
            if (speelBord[pionYLocation][pionXLocation - 1] == null) {
                beweegRichting.append(("[Left (l)]"));
                beweegRichtingMatrix.add("u");
            }
        }

        //Als alle locatie om hem heen vol zijn dan zijn beide lijsten leeg.
        //Dan heeft de speler een slechte pion gekozen en krijgt hij een exception die hij moet oplossen.
        if (beweegRichtingMatrix.isEmpty()){
            throw new noAvailableMovementException();
        } else {
            //Is er wel een mogelijkheid om te bewegen dan dan worden deze geprint in de terminal
            System.out.print("U kunt in de volgende richtingen bewegen: ");
            System.out.println(beweegRichting);
        }

        //Voor de move moeten de beweegbare richtingen doorgegeven worden
        return beweegRichtingMatrix;
    }




    public String toString(){
        StringBuilder bordstring = new StringBuilder();
        bordstring.append("+---+---+---+---+---+---+---+---+---+---+\n");
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) { //deze forloop voegt voor ieder vakje de value van het spelstuk toe of een "o" als het vakje leeg is.
                    String spelstukString;
                    if (speelBord[y][x] instanceof Speelstuk) {
                        Speelstuk speelstuk = (Speelstuk) speelBord[y][x];
                        int value = speelstuk.getValue();
                        if (value < 10) {
                            spelstukString = "|  " + value; //een extra spatie toevoegen als de waarde kleiner is dan tien, zodat de uitlijning mooi klopt.
                        } else {
                            spelstukString = "| " + value;
                        }
                    } else if (speelBord[y][x] instanceof Blokkade) { //Als er een String wordt gevonden dan is het een blokkade
                        spelstukString = "| X ";
                    } else { //Leeg stuk ruimte waar heen gelopen kan worden
                        spelstukString = "| O ";
                    }
                    bordstring.append(spelstukString);
                }
                bordstring.append("|\n");//Aan het einde komt nog een rechtstreepje en dan een niewline character
                bordstring.append("+---+---+---+---+---+---+---+---+---+---+\n");
            }
        return bordstring.toString();
    }


    //getters and setter
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

    public Object[][] getSpeelBord() {
        return speelBord;
    }


}


class Blokkade{}


