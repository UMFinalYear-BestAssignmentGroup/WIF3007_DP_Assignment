/*
 * Concrete class of Location
 */
package background;

import javafx.scene.layout.Pane;

/**
 *
 * @author Lee Peh Ting
 */
public abstract class Outdoor extends Location{
    Weather wd;
    public void setWeather(Pane pane, Weather wt){
        wt.drawRipple(pane);
    }
}
