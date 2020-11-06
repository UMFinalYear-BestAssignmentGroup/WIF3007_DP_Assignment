
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin
 */
public class FoodItem extends ImageView {
    public String id;
    public String name;
    public String location;
    public double size;
    public double x_slider;
    public double y_slider;
    public boolean visible = true;
    private ArrayList<FoodObserver> observers = new ArrayList<>();

    public FoodItem() {
        setPreserveRatio(true);
        setFitHeight(200);
        setVisible(true);
        
        observers.add(new YPositionObserver(this));
        observers.add(new XPositionObserver(this));
        observers.add(new SizeObserver(this));
    }

    public FoodItem setItem() {
        try {
            setImage(new Image(new FileInputStream(location)));
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        size = getFitHeight();
        return this;
    }
    
    public List<Object> getSlider() {
        return Arrays.asList(x_slider, y_slider, size);
    }
    
    public void setVisibility(boolean v) {
        System.out.println(name + " visibility set to " + v);
        setVisible(v);
        visible = v;
    }
    
    public boolean getVisibility() {
        return visible;
    }
    
    public void setId(int i) {
        id = name + "_" + i;
    }
    
    public void setXSlider(double slider) {
        x_slider = slider;
        notifyAllObservers();
    }
    
    public void setYSlider(double slider) {
        y_slider = slider;
        notifyAllObservers();
    }
    
    public void setSize(double scale) {
        size = scale;
        notifyAllObservers();
    }
    
    public String getNameId() {
        return id;
    }
    
    public void notifyAllObservers(){
      for (FoodObserver observer : observers) {
         observer.update();
      }
   } 
}
