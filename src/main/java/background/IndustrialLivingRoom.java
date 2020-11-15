/*
 * Concrete class of LivingRoom
 */
package background;

/**
 *
 * @author Lee Peh Ting
 */
public class IndustrialLivingRoom extends LivingRoom{
    
    public IndustrialLivingRoom(){
        this.location = "img/background/livingroom/industrial.jpg";
    }
    
    @Override
    public String emptyRoom() {
        return "new image location";
    }
    
}
