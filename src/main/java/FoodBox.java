
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
public class FoodBox extends VBox {
    
    String raya_food_array[] = {"rendang", "ketupat"};
    String cny_food_array[] = {"yeesang", "dumplings"};
    ComboBox food_choice;
    
    Pane designPane;
    
    FoodItem imageView;
    final int design_width = Constants.WIDTH;
    final int design_height = Constants.HEIGHT;
    
    Button btn_newFood;
    Button btn_remove_food;
    HBox btn_box;
    
    Slider x_slider;
    Slider y_slider;
    Slider size_slider;
    
    ListView listView;
    
    RadioButton btn_visible_true;
    RadioButton btn_visible_false;
    ToggleGroup visible_group;
    HBox visible_group_toggle;
    
    FoodList foodlist = FoodList.getInstance();
    
    public FoodBox(Pane designPane) {
        this.designPane = designPane;
        
        btn_newFood = new Button("Add");
        btn_remove_food = new Button("Remove");
        btn_remove_food.setVisible(false);
        btn_remove_food.setManaged(false);
        btn_box = new HBox(2);
        btn_box.getChildren().addAll(btn_newFood, btn_remove_food);
        
        listView = new ListView();

        //buttons to choose food visibility
        Label visibility_label = new Label("Visibility : ");
        btn_visible_true = new RadioButton("ON");
        btn_visible_true.setUserData(true);
        btn_visible_false = new RadioButton("OFF");
        btn_visible_false.setUserData(false);
        visible_group = new ToggleGroup();
        visible_group.getToggles().addAll(btn_visible_true, btn_visible_false);
        visible_group_toggle = new HBox(2);
        visible_group_toggle.setPadding(new Insets(5));
        visible_group_toggle.getChildren().addAll(visibility_label, btn_visible_true, btn_visible_false);

        //set visibility of button groups
        visible_group_toggle.setVisible(false);
        visible_group_toggle.setManaged(false);
        
        Text txt_x_axis = new Text("X_AXIS");
        Text txt_y_axis = new Text("Y_AXIS");
        Text txt_scale = new Text("SCALE");

        //set sliders
        x_slider = new Slider(0, 100, 0);
        y_slider = new Slider(0, 100, 0);
        size_slider = new Slider(100, 300, 200);
        
        btn_newFood.setOnAction((t) -> {
            showAddFoodScreen();
        });
        
        btn_remove_food.setOnAction((t) -> {
            foodlist.removeFoodItem(listView.getSelectionModel().getSelectedItem().toString(), designPane);
            updateListView();
        });
        
        x_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.setXSlider(x_slider.getValue());
            }
        });
        
        y_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.setYSlider(y_slider.getValue());
            }
        });
        
        size_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            if (imageView != null) {
                imageView.setSize(size_slider.getValue());
            }
        });
        
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object t, Object t1) -> {
            if (t1 != null) {
                System.out.println("Set control to " + t1.toString());
                List<Object> sliders;
                
                visible_group_toggle.setVisible(true);
                visible_group_toggle.setManaged(true);
                btn_remove_food.setVisible(true);
                btn_remove_food.setManaged(true);
                
                imageView = foodlist.getFoodItem(t1.toString());
                
                sliders = imageView.getSlider();
                x_slider.setValue((double) sliders.get(0));
                y_slider.setValue((double) sliders.get(1));
                size_slider.setValue((double) sliders.get(2));
                
                if (imageView.getVisibility()) {
                    btn_visible_true.setSelected(true);
                    btn_visible_false.setSelected(false);
                } else {
                    btn_visible_true.setSelected(false);
                    btn_visible_false.setSelected(true);
                }
            } else {
                visible_group_toggle.setVisible(false);
                visible_group_toggle.setManaged(false);
                btn_remove_food.setVisible(false);
                btn_remove_food.setManaged(false);
            }
        });
        
        visible_group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (visible_group.getSelectedToggle() != null && imageView != null) {
                imageView.setVisibility(Boolean.parseBoolean(visible_group.getSelectedToggle().getUserData().toString()));
            }
        });
        
        setPadding(new Insets(10));
        getChildren().addAll(btn_box, listView, visible_group_toggle, txt_x_axis, x_slider, txt_y_axis, y_slider, txt_scale, size_slider);
    }
    
    public void updateListView() {
        listView.getItems().clear();
        for (int i = 0; i < foodlist.getArray().size(); i++) {
            listView.getItems().add(foodlist.getArray().get(i).getNameId());
        }
    }
    
    public void showAddFoodScreen() {
        Stage stage = new Stage();
        
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);

        //radio button to choose between Raya and CNY
        Label festival_label = new Label("Choose festival : ");
        RadioButton btn_raya = new RadioButton("Raya");
        btn_raya.setUserData("raya");
        RadioButton btn_cny = new RadioButton("CNY");
        btn_cny.setUserData("cny");
        btn_cny.setSelected(true);
        ToggleGroup food_radio_btn = new ToggleGroup();
        food_radio_btn.getToggles().addAll(btn_raya, btn_cny);
        HBox food_radio = new HBox(5);
        food_radio.setPadding(new Insets(10));
        food_radio.getChildren().addAll(festival_label, btn_cny, btn_raya);
        
        food_choice = new ComboBox(FXCollections.observableArrayList(cny_food_array));
        
        food_radio_btn.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (food_radio_btn.getSelectedToggle() != null) {
                System.out.println("Set to " + food_radio_btn.getSelectedToggle().getUserData().toString());
                switch (food_radio_btn.getSelectedToggle().getUserData().toString()) {
                    case "cny":
                        System.out.println("yesycny");
                        food_choice.setItems(FXCollections.observableArrayList(cny_food_array));
                        break;
                    case "raya":
                        food_choice.setItems(FXCollections.observableArrayList(raya_food_array));
                        break;
                }
            }
        });
        
        Button btn_add = new Button("Add");
        btn_add.setOnAction((ActionEvent event) -> {
            List<Object> sliders;
            System.out.println(food_choice.getValue().toString() + " is chosen");
            
            if ("raya".equals(food_radio_btn.getSelectedToggle().getUserData().toString())) {
                new FoodRayaFactory().addFood(food_choice.getValue().toString(), designPane);
            } else if ("cny".equals(food_radio_btn.getSelectedToggle().getUserData().toString())) {
                new FoodCNYFactory().addFood(food_choice.getValue().toString(), designPane);
            }
            
            updateListView();
            stage.close(); // return to main window
        });
        
        box.getChildren().addAll(food_radio, food_choice, btn_add);
        
        Scene scene = new Scene(box, 250, 150);
        stage.setTitle("Add food");
        stage.setScene(scene);
        stage.show();
    }
}
