/*
 * BackgroundFactory using Factory Method
 * abstract factory method createLocation
 * let the subclasses handle the object creation
 */
package background;

/**
 *
 * @author Lee Peh Ting
 */
public abstract class BackgroundFactory {
    /*Overriden by concrete classes to handle the object creation*/
    abstract Location createLocation(String locationType);
}
