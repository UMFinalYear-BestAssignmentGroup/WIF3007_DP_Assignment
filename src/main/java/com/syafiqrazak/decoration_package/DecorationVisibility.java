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
public class DecorationVisibility extends Decorator {
    
     public DecorationVisibility(DecorationItem decorationItem) {
      super(decorationItem);	
        setFitHeight(200);	
   }

    @Override
    public void resize(double arg0, DecorationItem arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
    public void setVisibility(boolean v, DecorationItem di) {
        System.out.println("Inside DecorationVisibility");
        decorationItem.setVisibility(v, di);
    }
    
    @Override
    public boolean getVisibility(DecorationItem di) {
        return di.getVisibility(di);
    }

    @Override
    public double getSize(DecorationItem di) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
