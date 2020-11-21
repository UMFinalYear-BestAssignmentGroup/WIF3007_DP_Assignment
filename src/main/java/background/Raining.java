/*
 * Concrete of Weather
 */
package background;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

/**
 *
 * @author Lee Peh Ting
 */
public class Raining implements Weather{
    int counter=0; //Used to calculate how many objects have been created
    List<TranslateTransition> objectArr =  new ArrayList<>(); //Store created objects
    Random random = new Random();
    TranslateTransition rain;
    Pane designPane;
    
    @Override
    public void drawRipple(Pane pane) {
         this.designPane = pane;
        Ellipse c[] = new Ellipse[100];
            for(int i=0; i<100; i++){
                c[i] = new Ellipse(0.5,random.nextDouble()*50,0.5, random.nextDouble()*10);
                //c[i].setRadius(random.nextDouble()*3f);
                Color color = Color.rgb(116, 117, 116, random.nextDouble());
                c[i].setFill(color);
                designPane.getChildren().add(c[i]);
                int time = 1 + random.nextInt(5);
                playAnimation(c[i], time);
            }

    }

    @Override
    public void playAnimation(Ellipse c, int time) {
        c.setCenterX(random.nextInt(750)); //Window width = 850
        rain = new TranslateTransition(new Duration(time), c);
        /*Add created object into array*/
        objectArr.add(rain);
        rain.setToY(650+200);
        rain.setToX(random.nextDouble()*c.getCenterX());
        rain.setFromY(-200);
        rain.setCycleCount(Timeline.INDEFINITE);
        rain.setRate(1);
        rain.setDuration(Duration.seconds(time));
        
        rain.play();
        counter++;
    }

    @Override
    public void stopAnimation() {
        /*Stop every created object*/
        for(TranslateTransition tt : objectArr){tt.stop();
        Ellipse tmp = (Ellipse)tt.getNode();
        tmp.setVisible(false);
        }
    }

    @Override
    public boolean isAnimation() {
       if(rain.getStatus()==Animation.Status.RUNNING)
            return true;
        return false;
    }
    
}
