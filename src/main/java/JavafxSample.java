
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin
 */
public class JavafxSample extends Application {
    private final int design_width = 850;
    private final int design_height = 600;

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
        designPane.setPrefSize(design_width, design_height);
        bPane.setRight(designPane);
        
        inputPane.setStyle("-fx-background-color: grey;");
        inputPane.setPrefSize(200, 600);
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
        RadioButton button4 = new RadioButton("HBase");
        RadioButton button5 = new RadioButton("MongoDB");
        RadioButton button6 = new RadioButton("Neo4j");
        ToggleGroup group2 = new ToggleGroup();
        group2.getToggles().addAll(button4, button5, button6);
        
        VBox music_vbox = new VBox(10);
        music_vbox.setPadding(new Insets(10));
        music_vbox.getChildren().addAll(button4, button5, button6);
        
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
        FoodItem imageView = new YeeSang().setItem(); 
        designPane.getChildren().addAll(imageView);
        CNYDecoration cny = new CNYDecoration();
        cny.selectDecoration();
        designPane.getChildren().addAll(cny);
        
        RadioButton btn_raya = new RadioButton("Raya");
        RadioButton btn_cny = new RadioButton("CNY");
        ToggleGroup food_radio_btn = new ToggleGroup();
        
        food_radio_btn.getToggles().addAll(btn_raya, btn_cny);
        Button btn_yeesang = new Button("Yee Sang");
        
        Text txt_x_axis = new Text("X_AXIS");
        Text txt_y_axis = new Text("Y_AXIS");
        Text txt_scale = new Text("SCALE");
        
        Slider x_slider = new Slider(0, 100, 0);
        Slider y_slider = new Slider(0, 100, 0);
        Slider size_slider = new Slider(1, 200, 200);
        
        x_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            imageView.update(x_slider.getValue(), design_width-150, "horizontal");
        });
        
        y_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            imageView.update(y_slider.getValue(), design_height-100, "vertical");
        });
        
        size_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            imageView.update(size_slider.getValue());
        });
        
        VBox food_vbox = new VBox(10);
        food_vbox.setPadding(new Insets(10));
        food_vbox.getChildren().addAll(btn_raya, btn_cny, btn_yeesang, txt_x_axis, x_slider, txt_y_axis, y_slider, txt_scale, size_slider);
        
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
        Scene scene = new Scene(group, 1050, 600);
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
