/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;
/**
 *
 * @author SyafiqRazak
 */
public class CNYDecoration extends ImageView implements DecorationItem {
    public String name = "Tanglong";
    public String location = "img/TanglongDeco1.png";
    public double size;
    
    public CNYDecoration(){
        setPreserveRatio(true);
        setFitHeight(200);
    }
    @Override
    public void selectDecoration() {
        try {
            setImage(new Image(new FileInputStream(location)));
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        size = getFitHeight();
//        return this;
    }
    
    @Override
    public void resize(double scale){
        
    }
    
    /**
     *
     * @param scale
     * @param di
     */
    @Override
    public void resize(double scale, DecorationItem di){
        setFitHeight(scale);
        System.out.println("Inside resizwe method deco 3");
    }

    @Override
    public void location(double slider, int length, String orientation, DecorationItem di){
           System.out.println("Inside location 2");
//        setFitHeight(scale);
        if ("horizontal".equals(orientation)) {
            System.out.println("X:" + (slider * length) / 100);
            setX((slider * length) / 100);
        } else if ("vertical".equals(orientation)) {
            setY((slider * length) / 100);
            System.out.println("Y:" + (slider * length) / 100);
        }
    }
}
