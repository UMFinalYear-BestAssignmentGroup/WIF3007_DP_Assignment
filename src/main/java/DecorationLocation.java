/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
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
//            System.out.println("X:" + (slider * length) / 100);
//            setX((slider * length) / 100);
            decorationItem.location(slider, length, orientation, di);
        } else if ("vertical".equals(orientation)) {
//            setY((slider * length) / 100);
//            System.out.println("Y:" + (slider * length) / 100);
            decorationItem.location(slider, length, orientation, di);
        }
        System.out.println("Inside location 1");
    }
}
