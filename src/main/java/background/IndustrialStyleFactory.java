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
public class IndustrialStyleFactory extends BackgroundFactory{

    @Override
    Location createLocation(String locationType) {
        if(locationType == Location.LIVINGROOM)
            return new IndustrialLivingRoom();
        else if(locationType == Location.OUTDOOR)
            return new IndustrialOutdoor();
        else if(locationType == Location.KITCHEN)
            return new IndustrialKitchen();
        else return null;
    }
    
}
