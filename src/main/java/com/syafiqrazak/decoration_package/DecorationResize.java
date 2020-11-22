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
}
