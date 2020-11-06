package food_package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public abstract class FoodObserver{
    FoodItem fooditem;
    
    public FoodObserver() {};
    public abstract void update();
}

