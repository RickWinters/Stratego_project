package nl.Stratego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bord {
    //variables
    private long id;
    private String naam = "default";
    private String blokkade = "blokkade";
    Object[][] SpeelStukken = new Object[10][10];

    //Constructor(s), de default constructor
    public Bord(){
        List<Speelstuk> team1 = this.createteam(); //De tijdelijk functie om een team aan te maken aante roepen
        List<Speelstuk> team2 = this.createteam(); //
        Random rand = new Random();
        for (int x = 0;x < 4; x++){ //het bord vullen
            for (int y = 0; y<10; y++){
                int ind = rand.nextInt(team1.size());
                SpeelStukken[x][y] = team1.get(ind);
                team1.remove(ind);

                ind = rand.nextInt(team2.size()); //dit kan gelijk voor team 2, de x coordinaat wordt alleen met 6 verhoogd.
                SpeelStukken[x+6][y] = team2.get(ind);
                team2.remove(ind);

            }
        }
        //hardcoded blokkades
        SpeelStukken[4][2] = blokkade; //coordinaten 5,3
        SpeelStukken[4][3] = blokkade; //coordinaten 5,4
        SpeelStukken[5][2] = blokkade;
        SpeelStukken[5][3] = blokkade;
        SpeelStukken[4][6] = blokkade;
        SpeelStukken[4][7] = blokkade;
        SpeelStukken[5][6] = blokkade;
        SpeelStukken[5][7] = blokkade;
    }

    //Methodes (en temporary)
    //check inbouwen voor move functie vlag en bom + checkbound
    private List<Speelstuk> createteam(){
        //deze methode creert een lijst van 40 Speelstukken,
        //Temporary methode om te testen of het vullen van het bord werkt in de constructor van bord
        List<Speelstuk> team = new ArrayList<>();
        for (int i = 0; i < 40; i++){
            team.add(new Speelstuk(i, "test-speelstuk"));
        }
        return team;
    }

    public void move(int x, int y, int x_new, int y_new){
        //op dit moment heb ik de updates van alle spelstukken nog niet om te bepalen bij welke team ze horen.
        //het is dus niet mogelijk om te implementeren dat het niet mogelijk is om op een plek van je eigen team te komen
        //of om te bepalen dat je een andere team aanvalt
        //de enige check die ik kan doen is om te kijken of de plek waar je naartoe wil een blokkade is (instanceof String)
        //en om te kijken of de plek waar je naar toe wil leeg is ()
        if (SpeelStukken[x_new][y_new] instanceof String){
            System.out.println("dit is een een blokkade waar je naartoe wilt spelen");
        } else if (SpeelStukken[x_new][y_new] == null){
            SpeelStukken[x_new][y_new] = SpeelStukken[x][y];
            SpeelStukken[x][y] = null;
        }
    }

    public String toString(){
        StringBuilder bordstring = new StringBuilder();
        bordstring.append("+---+---+---+---+---+---+---+---+---+---+\n");
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){ //deze forloop voegt voor ieder vakje de value van het spelstuk toe of een "o" als het vakje leeg is.
                String spelstukString;
                if (SpeelStukken[x][y] instanceof Speelstuk){
                    Speelstuk speelstuk = (Speelstuk)SpeelStukken[x][y];
                    int value = speelstuk.getValue();
                    if (value < 10){
                        spelstukString = "|  " + value; //een extra spatie toevoegen als de waarde kleiner is dan tien, zodat de uitlijning mooi klopt.
                    } else {
                        spelstukString = "| " + value;
                    }
                } else if (SpeelStukken[x][y] instanceof String){ //als er niet naar een object wordt verwezen op deze plek is deze plek leeg
                    spelstukString = "| x ";
                } else { // en anders is het een muur.
                    spelstukString = "| o ";
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

    public Object[][] getSpeelStukken() {
        return SpeelStukken;
    }

    public void setSpeelStukken(int[][] speelStukken) {
        SpeelStukken = speelStukken;
    }

}


