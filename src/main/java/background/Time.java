/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class Time {
    
    
    public Lighting setDecorator(Color c){
        Light.Spot light = new Light.Spot();
        light.setColor(c);
        light.setX(500);
        light.setY(500);
        light.setZ(850);
        light.setSpecularExponent(2);
        light.setPointsAtX(0);
        light.setPointsAtY(0);
        light.setPointsAtZ(0);
          
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularExponent(20.0);
        return lighting;
    }
}
