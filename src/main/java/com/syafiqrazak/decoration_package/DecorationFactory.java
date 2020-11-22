/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate; 
import javax.swing.ImageIcon;
//import javafx.scene.layout.Pane;
/**
 *
 * @author SyafiqRazak
 */
public abstract class DecorationFactory extends ImageView implements DecorationItem {

    public double size;
    public double XCoordinate;
    public double YCoordinate;
    public double rotation;
    public boolean visibility = true;
    
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
    }
    
    @Override
    public void resize(double scale, DecorationItem di){
        size = scale;
        setFitHeight(scale);
    }

    @Override
    public void rotate(double degree, DecorationItem di){
        rotation = degree;
        setRotate(degree);
    }
    
    @Override
    public void setVisibility(boolean v, DecorationItem di){
        visibility = v;
        System.out.println("Inside this visible");
        setVisible(v);
    }

    @Override
    public void location(double slider, int length, String orientation, DecorationItem di){
//        setFitHeight(scale);
        if ("horizontal".equals(orientation)) {
            XCoordinate = slider;
            System.out.println("X:" + (slider * length) / 100);
            setX((slider * length) / 100);
        } else if ("vertical".equals(orientation)) {
            YCoordinate = slider;
            setY((slider * length) / 100);
            System.out.println("Y:" + (slider * length) / 100);
        }
    }
    
    public double getSize(DecorationItem di){
        return size;
    }
    
    public double getXCoordinate(DecorationItem di){
        return XCoordinate;
    }
    
    public double getYCoordinate(DecorationItem di){
        return YCoordinate;
    }
    
    public double getRotation(DecorationItem di){
        return rotation;
    }
    
    public boolean getVisibility(DecorationItem di){
        return visibility;
    }
}

