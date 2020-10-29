
import java.awt.Point;
import java.io.IOException;
import javax.swing.ImageIcon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class Dumplings extends FoodItem {
    public Dumplings() {
        name = "Dumplings";
        location = "img/dumplings.png";
        scale = 0.1;
        
        try {
            image = resize(location, scale);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        setIcon(new ImageIcon(image));
        setLocation(new Point(1,1));
        Point pt = getLocation();
            x = pt.x;
            y = pt.y;
    }
}
