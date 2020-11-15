/*
 * Weather interface 
 */
package background;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Lee Peh Ting
 */
public interface Weather{
    /*Draw the shape*/
    void drawRipple(Pane pane);
    /*Play the Animation*/
    void playAnimation(Ellipse c, int time);
    /*Stop the Animation*/
    void stopAnimation();
    /*Check the Animation status*/
    boolean isAnimation();
}
