/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class DecorationRotation extends Decorator {
    public DecorationRotation(DecorationItem decorationItem) {
      super(decorationItem);	
//        setRotate(200);	
   }

    @Override
    public void rotate(double degree, DecorationItem di) {
        decorationItem.rotate(degree, di);
    }

    @Override
    public void resize(double arg0, DecorationItem arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
