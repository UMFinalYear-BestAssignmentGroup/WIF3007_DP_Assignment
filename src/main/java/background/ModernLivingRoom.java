/*
 * Concrete class of LivingRoom
 */
package background;

/**
 *
 * @author Lee Peh Ting
 */
public class ModernLivingRoom extends LivingRoom{
    
    public ModernLivingRoom(){
        this.location = "img/background/livingroom/modern.jpg";
    }
    
    @Override
    public String emptyRoom() {
        return "new image location";
    }
    
}
