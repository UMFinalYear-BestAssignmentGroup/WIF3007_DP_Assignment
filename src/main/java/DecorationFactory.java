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
import javafx.scene.transform.Rotate; 
import javax.swing.ImageIcon;
/**
 *
 * @author SyafiqRazak
 */
public abstract class DecorationFactory extends ImageView implements DecorationItem {

    public double size;
    String name;
    String location;
    
    public DecorationFactory(){
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
//        setRotate(90);
//        return this;
    }
    
    @Override
    public void resize(double scale){
        
    }

    
    @Override
    public void resize(double scale, DecorationItem di){
        setFitHeight(scale);
    }

    @Override
    public void rotate(double degree, DecorationItem di){
        setRotate(degree);
    }

    @Override
    public void location(double slider, int length, String orientation, DecorationItem di){
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
