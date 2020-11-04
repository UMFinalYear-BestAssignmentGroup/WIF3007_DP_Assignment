/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SyafiqRazak
 */
public abstract class Decorator implements DecorationItem{
    protected DecorationItem decorationItem;
    
    public Decorator(DecorationItem decorationItem){
        this.decorationItem = decorationItem;
    }
    
    @Override
    public void selectDecoration() {
        decorationItem.selectDecoration();
    }
    
}
