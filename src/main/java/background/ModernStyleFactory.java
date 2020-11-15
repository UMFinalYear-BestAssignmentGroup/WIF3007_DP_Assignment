/*
 * Concrete class for BackgroundFactory
 * Override factory method
 * Handle the creation of object according the Type that selected by the user
 */
package background;

/**
 *
 * @author Lee Peh Ting
 */
public class ModernStyleFactory extends BackgroundFactory{
    
    @Override
    Location createLocation(String locationType) {
        if(locationType == Location.LIVINGROOM)
            return new ModernLivingRoom();
        else if(locationType == Location.OUTDOOR)
            return new ModernOutdoor();
        else if(locationType == Location.KITCHEN)
            return new ModernKitchen();
        else return null;
    }
    
}
