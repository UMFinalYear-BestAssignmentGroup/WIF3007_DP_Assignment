/*
 * Concrete class of Location
 * implemented one abstract method which allows user to get a background image with no furnitures
 */
package background;

/**
 *
 * @author User
 */
public abstract class LivingRoom extends Location{
    /*Replace the Background Image with a new ImageURL*/
    public abstract String emptyRoom();
}
