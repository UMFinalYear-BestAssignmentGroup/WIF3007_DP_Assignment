
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class FoodItem extends ImageView implements FoodObserver {
    public String name;
    public String location;
    public double size;
    public double x_slider;
    public double y_slider;
    public boolean visible = false;

    public FoodItem() {
        setPreserveRatio(true);
        setFitHeight(200);
        setVisible(false);
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
        setVisible(v);
        visible = v;
    }
    
    public boolean getVisibility() {
        return visible;
    }
    
    @Override
    public void update(double slider, int length, String orientation) {
        if ("horizontal".equals(orientation)) {
            setX((slider * length) / 100);
            x_slider = slider;
        } else if ("vertical".equals(orientation)) {
            setY((slider * length) / 100);
            y_slider = slider;
        }
    }

    @Override
    public void update(double scale) {
        size = scale;
        setFitHeight(scale);
    }
}
