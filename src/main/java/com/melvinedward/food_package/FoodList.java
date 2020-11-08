
import java.util.ArrayList;
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
public class FoodList {

    private ArrayList<FoodItem> array = new ArrayList<>();
    private static FoodList instance = new FoodList();

    public FoodList() {
    }

    public static synchronized FoodList getInstance() {
        return instance;
    }

    public ArrayList<FoodItem> getArray() {
        return array;
    }

    public synchronized FoodItem addFoodItem(FoodItem fooditem) {
        fooditem.setId(getSimilarClass(fooditem));
        array.add(fooditem);
        
        System.out.println("Added: "+fooditem.getNameId());
        
        return fooditem;
    }

    public synchronized void removeFoodItem(String id, Pane designPane) {
        int index = getIndex(id);
        designPane.getChildren().remove(array.get(index));
        array.remove(index);
    }
    
    public synchronized FoodItem getFoodItem(String id) {
        int index = getIndex(id);
        return array.get(index);
    }

    private int getSimilarClass(FoodItem fooditem) {
        int tmp = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getClass() == fooditem.getClass()) {
                tmp++;
            }
        }
        return tmp;
    }
    
    private int getIndex(String id) {
        for(int i = 0; i < array.size(); i++) {
           if(array.get(i).getNameId().equals(id)) {
               return i;
           } 
        }
        return -1;
    }
}
