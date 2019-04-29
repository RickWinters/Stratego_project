package nl.Stratego.Speelstukken;

import nl.Stratego.Speelstuk;
import sun.awt.image.ToolkitImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;



public class Bom extends Speelstuk{
    public Bom(int team){
        super(team,11, "bom");
    }


//    public void getBomImage() {
//        try{
//            BufferedImage image = ImageIO.read(new File("bin/Bom.jpg"));
//        }
//        catch (IOException e){
//            System.out.println("something went wrong: "+e.getMessage());
//        }
//    }

}
