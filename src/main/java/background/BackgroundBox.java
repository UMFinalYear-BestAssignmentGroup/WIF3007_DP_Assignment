/*
 * UI Design for Background
 */
package background;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Lee Peh Ting
 */
public class BackgroundBox extends VBox{
    Pane designPane; 
    Background bg;
    BackgroundFactory bgFac;
    BackgroundImage bgImg;
    final BackgroundSize bgSize = new BackgroundSize(750, 650, false, false, false, false);
    Boolean isRainy, isSnowing=false; //Check current selected Weather
    FileInputStream imgURL; //To open Image file
    Image img; 
    Label isSourceLabel;
    Location lc;
    Random random = new Random();
    Time td = new Time();
    VBox isLocation;
    VBox emptyBox; 
    VBox weatherVBox;
    Weather wd;
    
    public BackgroundBox(Pane designPane){
        this.designPane = designPane;
        /*Create an empty box for placing the Locations (hidden until user selected a style)*/
        emptyBox = new VBox();
        /*Control panel design -- Choose a style*/
        /*Display an instruction to ask the user choose a style*/
        Label instruction = new Label("Choose a style:");
        /*Radio button which user can only choose one style*/
        Button btn_industrial = new Button("Industrial");
        Button btn_modern = new Button("Modern");
        Button btn_rustic = new Button("Rustic");
        VBox styleVBox = new VBox(3);
        /*HBox to hold instruction*/
        HBox styleHBoxHdr = new HBox();
        /*First line that consists of two elements of style*/
        HBox styleHBoxL1 = new HBox(2);
        /*Second line that consists of one elements of style*/
        HBox styleHBoxL2 = new HBox(2);
        styleHBoxHdr.getChildren().addAll(instruction);
        styleHBoxL1.setPadding(new Insets(2));
        styleHBoxL1.getChildren().addAll(btn_industrial, btn_modern);
        styleHBoxL2.getChildren().addAll(btn_rustic);
        styleVBox.getChildren().addAll(styleHBoxHdr, styleHBoxL1, styleHBoxL2);
        /*When an Industrial Style has been selected*/
        btn_industrial.setOnAction((t) -> {
            bgFac = new IndustrialStyleFactory();
            /*Display options of Location*/
            showisLocation(bgFac);
        });
        /*When an Modern Style has been selected*/
        btn_modern.setOnAction((t)-> {
            bgFac = new ModernStyleFactory();
            /*Display options of Location*/
            showisLocation(bgFac);
        });
        /*When an Rustic Style has been selected*/
        btn_rustic.setOnAction((t)->{
            bgFac = new RusticStyleFactory();
            /*Display options of Location*/
            showisLocation(bgFac);
        });
        
        setPadding(new Insets(10));
        getChildren().addAll(styleVBox, emptyBox);
        
        /*Allows user to choose Day View or Night View
          Applicable for all location
        */
        /* Instruction to user*/
        Label instruction2 = new Label("Time (Optional): ");
        /*Radio button with two options -- Day or Night*/
        RadioButton dayTime = new RadioButton("Day");
        RadioButton nightTime = new RadioButton("Night");
        ToggleGroup timeGroup = new ToggleGroup();
        timeGroup.getToggles().addAll(dayTime, nightTime);
        VBox timeVBox = new VBox(3);
        HBox timeHBoxHdr = new HBox();
        HBox timeHBoxL1 = new HBox(2);
        timeHBoxHdr.setPadding(new Insets(2));
        timeHBoxHdr.getChildren().addAll(instruction2);
        timeHBoxL1.getChildren().addAll(dayTime, nightTime);
        timeVBox.getChildren().addAll(timeHBoxHdr, timeHBoxL1);
        /*When a Day is selected*/
        dayTime.setOnAction((t)->{
            /*Set the Lighting for BgImage with White color*/
            designPane.setEffect(td.setDecorator(Color.WHITE));
        });
        /*When a Night is selected*/
        nightTime.setOnAction((t)->{
            /*Set the Lighting for BgImage with DeepSkyBlue color*/
            designPane.setEffect(td.setDecorator(Color.DEEPSKYBLUE));
        });
        
        getChildren().addAll(timeVBox);
    }
    
    /*This method will add the options for Location into the emptyBox that created earlier.
      The hidden emptyBox will be displays to the Control Pane
    */
    private void showisLocation(BackgroundFactory bgFac){
        /*If the emptyBox added the options before, remove it
          Because each option for different style lead to a different class to instantiate
        */
        emptyBox.getChildren().remove(isLocation);
        /*Create a VBox to hold the radio button*/
        isLocation = new VBox();
        isLocation.setPadding(new Insets(10));
        isLocation.setAlignment(Pos.BASELINE_LEFT);
        
        RadioButton isKitchen = new RadioButton("Kitchen");
        RadioButton isLivingroom = new RadioButton("Living Room");
        RadioButton isOutdoor = new RadioButton("Outdoor");
        ToggleGroup group1 = new ToggleGroup();
        group1.getToggles().addAll(isKitchen, isLivingroom, isOutdoor);
        /*When a Kitchen is selected*/
        isKitchen.setOnAction((t)->{
            try {
                /*Get the Location class through BackgroundFactory*/
                lc = bgFac.createLocation(Location.KITCHEN);
                /*Find and set the ImageURL*/
                imgURL = new FileInputStream(lc.getImageLocation());
                img = new Image(imgURL);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BackgroundBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Set BackgroundImage*/
            bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);
            bg = new Background(bgImg);
            designPane.setBackground(bg);
            /*Hide the  Weather*/
            hideWeather();
        });
        /*When a LivingRoom is selected*/
        isLivingroom.setOnAction((t)->{
            try {
                /*Get the Location class through BackgroundFactory*/
                lc = bgFac.createLocation(Location.LIVINGROOM);
                /*Find and set the ImageURL*/
                imgURL = new FileInputStream(lc.getImageLocation());
                img = new Image(imgURL);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BackgroundBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Set BackgroundImage*/
            bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);
            bg = new Background(bgImg);
            designPane.setBackground(bg);
            /*Hide the  Weather*/
            hideWeather();
        });
        /*When the Outdoor is selected*/
        isOutdoor.setOnAction((t)->{
            try {
                /*Get the Location class through BackgroundFactory*/
                lc = bgFac.createLocation(Location.OUTDOOR);
                /*Find and set the ImageURL*/
                imgURL = new FileInputStream(lc.getImageLocation());
                img = new Image(imgURL);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BackgroundBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Set BackgroundImage*/
            bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);
            bg = new Background(bgImg);
            designPane.setBackground(bg);
            /*The Weather only visible for Outdoor*/
            displayWeather(lc);
        });
        
        isLocation.setPadding(new Insets(10));
        isLocation.getChildren().addAll(isKitchen, isLivingroom, isOutdoor);
        setPadding(new Insets(10));
        emptyBox.getChildren().addAll(isLocation);
        
    }

    /*Weather options only available for Outdoor*/
    private void displayWeather(Location lc){
        /*Control Panel design*/
        Label instruction3 = new Label("Weather (Optional): ");
        RadioButton raining = new RadioButton("Raining");
        RadioButton snowing = new RadioButton("Snowing");
        ToggleGroup weatherGroup = new ToggleGroup();
        weatherGroup.getToggles().addAll(raining, snowing);
        weatherVBox = new VBox(3);
        HBox weatherHBoxHdr = new HBox();
        HBox weatherHBoxL1 = new HBox(2);
        weatherHBoxHdr.setPadding(new Insets(2));
        weatherHBoxHdr.getChildren().addAll(instruction3);
        weatherHBoxL1.getChildren().addAll(raining, snowing);
        weatherVBox.getChildren().addAll(weatherHBoxHdr, weatherHBoxL1);
        /*When Snowing is selected*/
        snowing.setOnAction((t)->{
            if(isRainy == true){wd.stopAnimation(); isRainy =false;}
            /*Set the Weather to Snowing*/
            wd = new Snowing();
            //wd.drawRipple(designPane);
            /*Downcast Location to Outdoor*/
            Outdoor od = (Outdoor) lc;
            od.setWeather(designPane, wd);
            isSnowing = true;
        });
        /*When Raining is selected*/
        raining.setOnAction((t)->{
            if(isSnowing == true){ wd.stopAnimation(); isSnowing=false;}
            wd = new Raining();
            //wd.drawRipple(designPane);
            /*Downcast Location to Outdoor*/
            Outdoor od = (Outdoor) lc;
            od.setWeather(designPane, wd);
            isRainy = true;
        });
        
        getChildren().addAll(weatherVBox);
    }
    /*Hide the Weather VBox*/
    private void hideWeather(){
        getChildren().remove(weatherVBox);
        /*If the animation started, stop all*/
        if(isSnowing==true || isRainy==true){wd.stopAnimation(); isRainy=false; isSnowing=false;}
    }
}
