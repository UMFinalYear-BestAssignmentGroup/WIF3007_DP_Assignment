package food_package;

import main.Constants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class XPositionObserver extends FoodObserver{
    public XPositionObserver(FoodItem fooditem) {
        this.fooditem = fooditem;
    }

    @Override
    public void update() {
        fooditem.setX((fooditem.x_slider * Constants.WIDTH)/100);
    }
    
}
