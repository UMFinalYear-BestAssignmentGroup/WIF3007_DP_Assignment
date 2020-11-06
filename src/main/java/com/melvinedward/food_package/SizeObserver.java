/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class SizeObserver extends FoodObserver{
    public SizeObserver(FoodItem fooditem) {
        this.fooditem = fooditem;
    }

    @Override
    public void update() {
        fooditem.setFitHeight(fooditem.size);
    }
}
