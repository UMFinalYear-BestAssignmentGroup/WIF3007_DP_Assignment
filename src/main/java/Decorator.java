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
public abstract class Decorator extends ImageView implements DecorationItem{
    protected DecorationItem decorationItem;
    
    public Decorator(DecorationItem decorationItem){
        this.decorationItem = decorationItem;
    }
    
    @Override
    public void selectDecoration() {
        decorationItem.selectDecoration();
    }
    @Override
    public void resize(double scale){
        setFitHeight(scale);
    }
    
    @Override
    public void location(double slider, int length, String orientation, DecorationItem di){
        
    }
    
}
