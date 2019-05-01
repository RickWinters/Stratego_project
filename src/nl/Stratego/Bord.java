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
    public Bord() {
        List<Speelstuk> team1 = this.createteam(0); //De tijdelijk functie om een team aan te maken aante roepen
        List<Speelstuk> team2 = this.createteam(1); //
        Random rand = new Random();
        for (int y = 0; y < 4; y++) { //het bord vullen
            for (int x = 0; x < 10; x++) {
                int ind = rand.nextInt(team1.size());
                speelBord[y][x] = team1.get(ind);
                team1.remove(ind);

                ind = rand.nextInt(team2.size()); //dit kan gelijk voor team 2, de x coordinaat wordt alleen met 6 verhoogd.
                speelBord[y + 6][x] = team2.get(ind);
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
    public List<Speelstuk> createteam(int team) {
        List<Speelstuk> Teamstukken = new ArrayList<>();
        //Elk stuk krijgt een apart object en daarom worden 40 stukken gemaakt hieronder. Deze krijgen allemaal
        //het teamnummer mee zodat er onderscheid gemaakt kan worden.
        for (int i = 0; i < 6; i++) Teamstukken.add(new Bom(team));
        Teamstukken.add(new Maarschalk(team));
        Teamstukken.add(new Generaal(team));
        for (int i = 0; i < 2; i++) Teamstukken.add(new Kolonel(team));
        for (int i = 0; i < 3; i++) Teamstukken.add(new Majoor(team));
        for (int i = 0; i < 4; i++) Teamstukken.add(new Kapitein(team));
        for (int i = 0; i < 4; i++) Teamstukken.add(new Luitenant(team));
        for (int i = 0; i < 4; i++) Teamstukken.add(new Sergeant(team));
        for (int i = 0; i < 5; i++) Teamstukken.add(new Mineur(team));
        for (int i = 0; i < 8; i++) Teamstukken.add(new Verkenner(team));
        Teamstukken.add(new Spion(team));
        Teamstukken.add(new Vlag(team));
        return Teamstukken;
    }

    //method for asking pion (int y, int x)
        // calls method if pion is own team
        // calls method if pion can move in any direction


    public boolean pieceCheck (int pionYLocation, int pionXLocation, Speler spelerAanDeBeurt){
        Speelstuk gekozenSpeelstuk = (Speelstuk)speelBord[pionYLocation][pionXLocation];
        if (spelerAanDeBeurt.getSpelerTeam() == gekozenSpeelstuk.getTeam()) {
            return true;
        } else {
            return false;
        }
    }




    private boolean movementCheck (int pionYLocation, int pionXLocation) {
        //Check of de nieuwe plaats wel op het bord ligt
        if (pionYLocation < 0 || pionYLocation > 10 || pionXLocation < 0 || pionXLocation > 10) {
            System.out.println("Deze locatie zit buiten het bord");
            return false;
        }
        //Check of de nieuwe plaats wel beschikbaar is om heen te gaan
        else if (speelBord[pionYLocation][pionXLocation] instanceof Speelstuk) {
            System.out.println("Dit kan nog niet, hier staat een andere speler");
            return false;
        } else if (speelBord[pionYLocation][pionXLocation] instanceof Blokkade) {
            System.out.println("Hier kun je niet doorheen!");
            return false;
        } else {
            return true;
        }

    }

    //Deze code verplaatst de stukken, maar kan alleen aangeroepen worden nadat de movement check is uitgevoerd
    //Daarom is deze ook private!
    private void movePiece (int pionYLocationNew, int pionXLocationNew, int pionYLocationOld, int pionXLocationOld){
        //Sla het speelstuk op de nieuwe plaats op
        speelBord[pionYLocationNew][pionXLocationNew] = speelBord[pionYLocationOld][pionXLocationOld];
        //Gooi de oude weg
        speelBord[pionYLocationOld][pionXLocationOld] = null;
    }

    public void moveChooser(int pionYLocation, int pionXLocation, Speler speler) {
        MOVELOOP: //Loop hierdoor totdat een geldige optie gekozen wordt
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String movementDirection = scanner.next();

            //Kijk of de input voldoet aan een van de volgende cases "u,d,r,l"
            switch (movementDirection) {
                case "u":
                    //Check of hij wel in deze richting kan bewegen, zo ja: voer move uit, zo nee: nieuwe input vragen
                    if (movementCheck(pionYLocation - 1,pionXLocation)){
                        movePiece(pionYLocation - 1,pionXLocation,pionYLocation,pionXLocation);
                        break MOVELOOP;
                    } break;
                case "d":
                    if (movementCheck(pionYLocation + 1,pionXLocation)){
                        movePiece(pionYLocation + 1,pionXLocation,pionYLocation,pionXLocation);
                        break MOVELOOP;
                    } break;
                case "r":
                    if (movementCheck(pionYLocation,pionXLocation + 1)){
                        movePiece(pionYLocation,pionXLocation + 1,pionYLocation,pionXLocation);
                        break MOVELOOP;
                    } break;
                case "l":
                    if (movementCheck(pionYLocation,pionXLocation - 1)){
                        movePiece(pionYLocation,pionXLocation - 1,pionYLocation,pionXLocation);
                        break MOVELOOP;
                    } break;
                default:
                    //Als geen geldige input wordt ingevuld, als "w,a,s" of "dr", dan komt hij hier in terecht en
                    //vraagt hij om nieuwe input.
                    System.out.println("U heeft een ongeldige richting gekozen, kies uit: Up (u), Down (d), Left (l), Right (r)");
            }
        }
    }

    public String toString() {
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
                    spelstukString = "|   ";
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


