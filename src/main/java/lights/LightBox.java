/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Mahirah binti Mansor
 */
public class LightBox extends VBox{
    Pane designPane;
    Light lights = new Light();
    
    boolean lightsOn = false;  //default value for light switch
    int rhythmType = 0;  //default value for rhythm
    List<Circle> lightRows;    //list to store the lights
    
    //buttons for switch on/off
    Button onButton;
    Button offButton;
    
    //buttons for rhythm on/off
    RadioButton noneButton;
    RadioButton slowButton;
    RadioButton fastButton;
    
    //checkbox buttons for colors
    CheckBox yellowCB;
    CheckBox purpleCB;
    CheckBox greenCB;
    CheckBox blueCB;
    CheckBox pinkCB;
    
    HBox btn_box; //btn box for on/off lights
    HBox slabel_box; //label for switch on/off lights
    HBox lineLights; //box for drawn lights
    
    List<Color> colorSet = new ArrayList<>();
    HBox clabel_box; //label for choose light color
    HBox cBox1;
    HBox cBox2;
    
    HBox rlabel_box; //label for rhythm switch on/off
    ToggleGroup rhythm_group;
    HBox rhythm_group_toggle1;
    
    //button to remove lights
    Button removeButton;
    HBox removeBtn_box;
    HBox removeLabel_box;
    
    public LightBox(Pane designPane) {
        this.designPane = designPane;
        
        //buttons to switch on/off the lights
        onButton = new Button("On");
        offButton = new Button("Off");
        offButton.setVisible(false);
        offButton.setManaged(false);
        
        btn_box = new HBox(2);      //HBox for stroing on/off buttons
        slabel_box = new HBox(1);   //HBox to store the on/off switch label
        clabel_box = new HBox(1);   //HBox to store the color label
        rlabel_box = new HBox(1);   //HBox to store the rhythm label
        lineLights = new HBox(1);   //HBox to store the row of lights
        
        //label for light switch
        Label switchLabel = new Label("Switch on the lights: ");
        slabel_box.getChildren().addAll(switchLabel);
        btn_box.getChildren().addAll(onButton, offButton);
        
        //label for color
        Label colorLabel = new Label("Select light colors: ");
        clabel_box.getChildren().addAll(colorLabel);
        
        //label for rhythm
        Label rhythmLabel = new Label("Switch on the rhythm: ");
        rlabel_box.getChildren().addAll(rhythmLabel);
        
        //set radio buttons for rhythm and their values
        noneButton = new RadioButton("None");
        noneButton.setUserData("none");
        slowButton = new RadioButton("Slow");
        slowButton.setUserData("slow");
        fastButton = new RadioButton("Fast");
        fastButton.setUserData("fast");
        
        rhythm_group = new ToggleGroup();
        rhythm_group.getToggles().addAll(noneButton, slowButton, fastButton);
        rhythm_group_toggle1 = new HBox(3);
        rhythm_group_toggle1.setPadding(new Insets(5));
        rhythm_group_toggle1.getChildren().addAll(noneButton, slowButton, fastButton);
        
        //set checkbox buttons for color and their values
        yellowCB = new CheckBox("Yellow");
        yellowCB.setSelected(true);
        yellowCB.setDisable(true);
        purpleCB = new CheckBox("Purple");
        greenCB = new CheckBox("Green");
        blueCB = new CheckBox("Blue");
        pinkCB = new CheckBox("Pink");
        
        //create HBox to store the color buttons
        cBox1 = new HBox(3);
        cBox2 = new HBox(2);
        
        //add color buttons to HBox
        cBox1.getChildren().addAll(yellowCB, blueCB, pinkCB);
        cBox2.getChildren().addAll(greenCB, purpleCB);
        
        lineLights = new HBox(1);
        
        //Setting color of lights
        purpleCB.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(new_val){
                colorSet.add(Color.PLUM);
                lights.setColor(colorSet);
            }
            else{
                colorSet.remove(Color.PLUM);
                lights.setColor(colorSet);
            }
        });
        greenCB.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(new_val){
                colorSet.add(Color.PALEGREEN);
                lights.setColor(colorSet);
            }
            else{
                colorSet.remove(Color.PALEGREEN);
                lights.setColor(colorSet);
            }
        });
        blueCB.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(new_val){
                colorSet.add(Color.AQUA);
                lights.setColor(colorSet);
            }
            else{
                colorSet.remove(Color.AQUA);
                lights.setColor(colorSet);
            }
        });
        pinkCB.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(new_val){
                colorSet.add(Color.PINK);
                lights.setColor(colorSet);
            }
            else{
                colorSet.remove(Color.PINK);
                lights.setColor(colorSet);
            }
        });

        //setting the rhythm of the lights
        rhythm_group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (rhythm_group.getSelectedToggle() != null) {
                System.out.println("Set to " + rhythm_group.getSelectedToggle().getUserData().toString());
                switch (rhythm_group.getSelectedToggle().getUserData().toString()) {
                    case "none":
                        rhythmType = 0;
                        lights.setRhythm(rhythmType);
                        break;
                    case "slow":
                        rhythmType = 1;
                        lights.setRhythm(rhythmType);
                        break;
                    case "fast":
                        rhythmType = 2;
                        lights.setRhythm(rhythmType);
                        break;
                }
            }
        });
        
        //on button click to on lights
        onButton.setOnAction((t)->{
            lightsOn = true;
            offButton.setVisible(true);
            offButton.setManaged(true);
            lineLights.setVisible(true);
            colorSet.add(Color.YELLOW); //adds yellow color to the list
            showLights(colorSet);
        });
        
        //off button click to off lights
        offButton.setOnAction((t)->{
            lightsOn = false;
            onButton.setVisible(true);
            onButton.setManaged(true);
            removeLights();
        });
        
        
        //add all labels and buttons to the design pane
        getChildren().addAll(clabel_box, cBox1, cBox2, slabel_box, btn_box, rlabel_box, rhythm_group_toggle1);
        designPane.getChildren().addAll(lineLights);
        
    }
    
    //display the lights on design pane
    public void showLights(List<Color> color){
        //call method from Light to draw lights
        lightRows = lights.drawLights(color);

        //adds row of lights to HBox then to design pane
        lineLights.getChildren().addAll(lightRows);
    }
    
    //removes lights from design pane
    public void removeLights(){
        lineLights.setVisible(false);
    }

}
