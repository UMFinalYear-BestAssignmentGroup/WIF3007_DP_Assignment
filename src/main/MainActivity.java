package main;

import dpmusic.MusicSelector;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import food_package.FoodBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin, YingShan
 */
public class MainActivity extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /* 
      Code for JavaFX application. 
      (Stage, scene, scene graph) 
         */
        BorderPane bPane = new BorderPane();
        VBox inputPane = new VBox();
        Pane designPane = new Pane();
        designPane.setStyle("-fx-background-color: red;");
        designPane.setPrefSize(Constants.WIDTH, Constants.HEIGHT);
        bPane.setRight(designPane);

        inputPane.setStyle("-fx-background-color: grey;");
        inputPane.setPrefSize(200, 650);
        bPane.setLeft(inputPane);

        //settings for background
        RadioButton button1 = new RadioButton("Apache Tika");
        RadioButton button2 = new RadioButton("JavaFX");
        RadioButton button3 = new RadioButton("Java ML");
        ToggleGroup group1 = new ToggleGroup();
        group1.getToggles().addAll(button1, button2, button3);

        VBox background_vbox = new VBox(10);
        background_vbox.setPadding(new Insets(10));
        background_vbox.getChildren().addAll(button1, button2, button3);

        TitledPane background_titledpane = new TitledPane("Background", background_vbox);
        background_titledpane.setLayoutX(1);
        background_titledpane.setLayoutY(1);

        //settings for music
        MusicSelector music_vbox = new MusicSelector(designPane);
        TitledPane music_titledpane = new TitledPane("Music", music_vbox);
        music_titledpane.setLayoutX(1);
        music_titledpane.setLayoutY(1);

        //settings for decorations
        VBox decorations_vbox = new VBox(10);
        decorations_vbox.setPadding(new Insets(10));

        TitledPane decorations_titledpane = new TitledPane("Decorations", decorations_vbox);
        decorations_titledpane.setLayoutX(1);
        decorations_titledpane.setLayoutY(1);

        //settings for animation
        VBox animation_vbox = new VBox(10);
        animation_vbox.setPadding(new Insets(10));

        TitledPane animation_titledpane = new TitledPane("Animation", animation_vbox);
        animation_titledpane.setLayoutX(1);
        animation_titledpane.setLayoutY(1);

        //settings for food
        FoodBox food_vbox = new FoodBox(designPane);
        TitledPane food_titledpane = new TitledPane("Food", food_vbox);
        food_titledpane.setLayoutX(1);
        food_titledpane.setLayoutY(1);

        //Creating a Accordion
        Accordion accor = new Accordion();
        accor.getPanes().add(background_titledpane);
        accor.getPanes().add(music_titledpane);
        accor.getPanes().add(decorations_titledpane);
        accor.getPanes().add(animation_titledpane);
        accor.getPanes().add(food_titledpane);
        VBox vbox = new VBox(accor);
        inputPane.getChildren().addAll(vbox);

        //creating a Group object 
        Group group = new Group(bPane);
        //Creating a Scene by passing the group object, height and width   
        Scene scene = new Scene(group, 1050, 650);
        primaryStage.setResizable(false);
        //setting color to the scene 
        scene.setFill(Color.GREY);
        //Setting the title to Stage. 
        primaryStage.setTitle("Decorator");
        //Adding the scene to Stage 
        primaryStage.setScene(scene);
        //Displaying the contents of the stage 
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
