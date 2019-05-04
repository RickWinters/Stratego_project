package nl.Stratego;

import nl.Stratego.Speelstukken.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void move(int x, int y, int x_new, int y_new){
        //op dit moment heb ik de updates van alle spelstukken nog niet om te bepalen bij welke team ze horen.
        //het is dus niet mogelijk om te implementeren dat het niet mogelijk is om op een plek van je eigen team te komen
        //of om te bepalen dat je een andere team aanvalt
        //de enige check die ik kan doen is om te kijken of de plek waar je naartoe wil een blokkade is (instanceof String)
        //en om te kijken of de plek waar je naar toe wil leeg is ()
        if (speelBord[x_new][y_new] instanceof String){
            System.out.println("dit is een een blokkade waar je naartoe wilt spelen");
        } else if (speelBord[x_new][y_new] == null){
            speelBord[x_new][y_new] = speelBord[x][y];
            speelBord[x][y] = null;
        }
    }

    public void bordPrinten(){
        StringBuilder bordstring = new StringBuilder();
        bordstring.append("X:  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| \n"); //deze coordinaten worden geprint boven het bord
        bordstring.append("  -----------------------------------------\n"); // dit is een afscheiding van coordinaten tov gevulde matrix
        bordstring.append("Y:+---+---+---+---+---+---+---+---+---+---+\n");
            for (int y = 0; y < 10; y++) {
                int yCoordinaat = y+1;
                if(yCoordinaat<10) {
                    bordstring.append(" ");
                }
                    bordstring.append(yCoordinaat);
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
                        spelstukString = "| x ";
                    } else { //Leeg stuk ruimte waar heen gelopen kan worden
                        spelstukString = "| o ";
                    }
                    bordstring.append(spelstukString);
                }
                bordstring.append("|\n");//Aan het einde komt nog een rechtstreepje en dan een niewline character
                bordstring.append("  +---+---+---+---+---+---+---+---+---+---+\n");
            }

        System.out.println(bordstring);
    }

    public void bordPrinten(int huidigeTeam){

        StringBuilder bordstring = new StringBuilder();
        bordstring.append("X:  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| \n"); //deze coordinaten worden geprint boven het bord
        bordstring.append("  -----------------------------------------\n"); // dit is een afscheiding van coordinaten tov gevulde matrix
        bordstring.append("Y:+---+---+---+---+---+---+---+---+---+---+\n");
        for (int y = 0; y < 10; y++) {
            int yCoordinaat = y+1;
            if(yCoordinaat<10) {
                bordstring.append(" ");
            }
            bordstring.append(yCoordinaat);
            for (int x = 0; x < 10; x++) { //deze forloop voegt voor ieder vakje de value van het spelstuk toe of een "o" als het vakje leeg is.
                String spelstukString;
                if (speelBord[y][x] instanceof Speelstuk) {
                    Speelstuk speelstuk = (Speelstuk) speelBord[y][x];
                    int team = speelstuk.getTeam();
                    int value = speelstuk.getValue();
                    if (team==huidigeTeam){
                        if (value < 10) {
                            spelstukString = "|  " + value; //een extra spatie toevoegen als de waarde kleiner is dan tien, zodat de uitlijning mooi klopt.
                        } else {
                            spelstukString = "| " + value;
                        }
                    }else {
                        spelstukString = "|xx ";
                    }
                } else if (speelBord[y][x] instanceof Blokkade) { //Als er een String wordt gevonden dan is het een blokkade
                    spelstukString = "| x ";
                } else { //Leeg stuk ruimte waar heen gelopen kan worden
                    spelstukString = "| o ";
                }
                bordstring.append(spelstukString);
            }
            bordstring.append("|\n");//Aan het einde komt nog een rechtstreepje en dan een niewline character
            bordstring.append("  +---+---+---+---+---+---+---+---+---+---+\n");
        }
        System.out.println(bordstring);
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


