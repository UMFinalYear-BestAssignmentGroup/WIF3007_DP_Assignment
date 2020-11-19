/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Mahirah binti Mansor
 */
public class Light {
    
    List<Color> color;     //list to store colors when user choose multiple colors
    List<Circle> lights;   //list to store the row of lights created
    
    int rhythmType; //determine if rhythm is on/off
    
    //used to randomize color when multiple light color chosen
    Random rand = new Random();
    int setRandom;
    
    //variable for fading transition used for rhythm
    List<FadeTransition> flickerObjs =  new ArrayList<>(); //list to store each light bulbs fade transition 
    FadeTransition ft;
    
    private List<LightObserver> observers = new ArrayList<LightObserver>(); //create list of observers
    
    public Light() {
        this.rhythmType = 0; //rhythm by default is switched off
        
        //add observers to observe rhythm and color
        observers.add(new RhythmObserver(this));
        observers.add(new ColorObserver(this));

        System.out.println("Lights created");
    }
    
    //notifies the observers about the change
    private void notifyObserver(){
        for (LightObserver observer : observers) {
            observer.update();
        }
    }

    //draw the circular lights horizontally
    public List<Circle> drawLights(List<Color> color){
        lights = new ArrayList<>();
        for (int i = 0 ; i < 40 ; i++) {
            Circle e = new Circle(10);
            setRandom = rand.nextInt(color.size());
            e.setFill(color.get(setRandom));
            
            //set drop shadow(shadow behind lights)
            DropShadow dropShadow = new DropShadow(); 
            dropShadow.setBlurType(BlurType.GAUSSIAN);
            dropShadow.setColor(color.get(setRandom));
            dropShadow.setOffsetX(3); 
            dropShadow.setOffsetY(2);

            e.setEffect(dropShadow);
            lights.add(e);
        }
        return lights;
    }

    //sets color when user selects color(s)
    public void setColor(List<Color> color){
        this.color = color;
        notifyObserver();                                                                                                                                                                                                        
    }
    
    //sets rhythm 
    public void setRhythm(int rhythmType){
        this.rhythmType = rhythmType;
        notifyObserver();
    }
    
    //recolor the lights once color is chosen
    public void resetLights(List<Circle> light,List<Color> color){
        Circle lightBulb; 
        for (int i = 0 ; i < light.size() ; i++) {
            lightBulb = light.get(i); //get individual light
            setRandom = rand.nextInt(color.size());
            lightBulb.setFill(color.get(setRandom)); //color individual light
            
            //set drop shadow(shadow behind lights)
            DropShadow dropShadow = new DropShadow(); 
            dropShadow.setBlurType(BlurType.GAUSSIAN);
            dropShadow.setColor(color.get(setRandom));
            dropShadow.setOffsetX(3); 
            dropShadow.setOffsetY(2);

            lightBulb.setEffect(dropShadow);
        }
    }
    
    //get the drawn lights
    public List<Circle> getLights(){
        return this.lights;
    }
    
    //get the status of rhythm
    public int getRhythm(){
        return this.rhythmType;
    }
    
    //set fade animation to lights to give flickering rhythm
    public void flickerLights(List<Circle> light, int rhythmType){   
        Circle lightBulb; 

        for (int i = 0 ; i < light.size() ; i++) {
            lightBulb = light.get(i); //get individual light
            
            if(rhythmType == 1){  
                ft = new FadeTransition(Duration.millis(600), lightBulb);
                flickerObjs.add(ft);
                ft.setFromValue(1.0);
                ft.setToValue(0.1);
                ft.setCycleCount(Timeline.INDEFINITE);
                ft.setAutoReverse(true);
                ft.play();
            }
            else if(rhythmType == 2){
                ft = new FadeTransition(Duration.millis(300), lightBulb);
                flickerObjs.add(ft);
                ft.setFromValue(0.1);
                ft.setToValue(1.0);
                ft.setCycleCount(Timeline.INDEFINITE);
                ft.setAutoReverse(true);
                ft.play();
            } 
            else{
                //stop rhythm
                for(FadeTransition flicker : flickerObjs){
                    flicker.stop();
                    lightBulb.setOpacity(1);
                }
            }
        }
    }

}
