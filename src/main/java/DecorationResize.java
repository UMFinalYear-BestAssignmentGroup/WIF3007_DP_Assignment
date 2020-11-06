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
 * @author user
 */
public class DecorationResize extends Decorator {
    
    public DecorationResize(DecorationItem decorationItem) {
      super(decorationItem);	
        setFitHeight(200);	
   }
    
    @Override
    public void selectDecoration(){
        decorationItem.selectDecoration();
    }
    
    private void resize(DecorationItem decorationItem){
        
    }
    @Override
    public void resize(double scale){
        System.out.println("Inside resizwe method deco");
        setFitHeight(scale);
    }
        @Override
    public void resize(double scale, DecorationItem di){
        System.out.println("Inside resizwe method deco 2");
        decorationItem.resize(scale, di);
//        di.setFitHeight(scale);
    }
}
