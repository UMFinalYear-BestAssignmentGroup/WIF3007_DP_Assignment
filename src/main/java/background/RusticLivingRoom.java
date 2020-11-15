/*
 * Concrete class of LivingRoom
 */
package background;

/**
 *
 * @author Lee Peh Ting
 */
public class RusticLivingRoom extends LivingRoom{
    
    public RusticLivingRoom(){
        this.location = "img/background/livingroom/rustic.jpg";
    }
    
    @Override
    public String emptyRoom() {
        return "new image location";
    }
    
}
