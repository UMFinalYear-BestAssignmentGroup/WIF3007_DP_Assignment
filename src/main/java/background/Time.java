/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

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
        light.setSpecularExponent(0.5);
          
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        return lighting;
    }
}
