/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;


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
        
    @Override
    public void resize(double scale, DecorationItem di){
        System.out.println("Inside resizwe method deco 2");
        decorationItem.resize(scale, di);
//        di.setFitHeight(scale);
//        decorationItem.setFitHeight(scale);
    }
    
//    @Override
    public void setVisibility(boolean v, DecorationItem di) {
        System.out.println("Inside DecorationVisibility");
        decorationItem.setVisibility(v, di);
    }
    
    @Override
    public double getSize(DecorationItem di){
        double temp = decorationItem.getSize(di);
        return 0;
    }

    @Override
    public double getXCoordinate(DecorationItem di) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getYCoordinate(DecorationItem di) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getRotation(DecorationItem di) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getVisibility(DecorationItem di) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
