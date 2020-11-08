
import javafx.scene.layout.Pane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class FoodRayaFactory implements FoodFactory{

    @Override
    public FoodItem addFood(String food, Pane designPane) {
        FoodItem tmp = new FoodItem();
        switch(food.toLowerCase()) {
            case "ketupat":
                tmp = FoodList.getInstance().addFoodItem(new Ketupat().setItem());
                break;
            case "rendang":
                tmp = FoodList.getInstance().addFoodItem(new Rendang().setItem());
                break;
            default: System.out.println("Invalid food item"); break;
        }
        designPane.getChildren().add(tmp);
        return tmp;
    }
    
}
