/*
 * Superclass
 */
package background;

import javafx.scene.layout.Pane;

/**
 *
 * @author User
 */
public abstract class Location {
    /*Three final variables for Location*/
    public static final String LIVINGROOM = "LivingRoom";
    public static final String KITCHEN = "Kitchen";
    public static final String OUTDOOR = "Outdoor";
    /*Image URL*/
    protected String location = "Unknow URL";
    Weather weather;
    /*Return Image URL*/
    public String getImageLocation(){
        return location;
    }
    
//    public void setWeather(Pane designPane, Weather wd){
//        weather = wd;
//        wd.drawRipple(designPane);
//    }
}
