
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
public class FoodCNYFactory implements FoodFactory{

    @Override
    public FoodItem addFood(String food, Pane designPane) {
        FoodItem tmp = new FoodItem();
        switch(food.toLowerCase()) {
            case "dumplings":
                tmp = FoodList.getInstance().addFoodItem(new Dumplings().setItem());
                break;
            case "yeesang":
                tmp = FoodList.getInstance().addFoodItem(new YeeSang().setItem());
                break;
            default: System.out.println("Invalid food item"); break;
        }
        designPane.getChildren().add(tmp);
        return tmp;
    }
    
}
