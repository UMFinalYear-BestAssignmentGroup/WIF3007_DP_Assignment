/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;

/**
 *
 * @author syafiqrazak
 */
public class DecorationLocation extends Decorator {
    public DecorationLocation(DecorationItem decorationItem) {
      super(decorationItem);	
        setFitHeight(200);	
   }
    
        @Override
    public void selectDecoration(){
        decorationItem.selectDecoration();
    }
    
    @Override
    public void resize(double scale, DecorationItem di){
        
    }
    
    @Override
    public void location(double slider, int length, String orientation, DecorationItem di){
        if ("horizontal".equals(orientation)) {
//            System.out.println("X:" + (slider
            decorationItem.location(slider, length, orientation, di);
        } else if ("vertical".equals(orientation)) {
//            setY((slider * length) / 100);
            decorationItem.location(slider, length, orientation, di);
        }
        System.out.println("Inside location 1");
    }
    
    @Override
    public void setVisibility(boolean v, DecorationItem di) {
        System.out.println("Inside DecorationVisibility");
        decorationItem.setVisibility(v, di);
    }
}
