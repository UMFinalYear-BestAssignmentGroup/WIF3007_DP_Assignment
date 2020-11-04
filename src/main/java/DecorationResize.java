/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class DecorationResize extends Decorator {
    
    public DecorationResize(DecorationItem decorationItem) {
      super(decorationItem);		
   }
    
    @Override
    public void selectDecoration(){
        decorationItem.selectDecoration();
//        resize(decorationItem);
    }
    
//    private void resize(double scale){
//        setFitHeight(scale);
//    }
}
