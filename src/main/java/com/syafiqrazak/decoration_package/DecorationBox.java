/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;

//import Constants;
import java.util.ArrayList;
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
/**
 *
 * @author syafiqrazak
 */
public class DecorationBox extends VBox{
    String cny_decoration_array[] = {"Red Paper", "Tanglong"};
    String raya_decoration_array[] = {"Ketupat 1", "Ketupat 2"};
    ComboBox decoration_choice;
    
    Pane designPane;
    
    final int design_width = 850;
    final int design_height = 650;
    DecorationItem di;
    DecorationFactory festival = new EidDecoration1();
    
    ListView listView;
    ArrayList<DecorationFactory> decorationList = new ArrayList<>();
    int selectedIndex;
    
    Button btn_newFood;
    Button btn_remove_food;
    HBox btn_box;
    
    Slider x_slider;
    Slider y_slider;
    Slider size_slider;
    
    RadioButton btn_visible_true;
    RadioButton btn_visible_false;
    ToggleGroup visible_group;
    HBox visible_group_toggle;
    
    public DecorationBox(Pane designPane){
        this.designPane = designPane;
        
        btn_newFood = new Button("Add");
        btn_remove_food = new Button("Remove");
        btn_remove_food.setVisible(true);
        btn_remove_food.setManaged(true);
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
        
        VBox decorations_vbox = new VBox(10);
        decorations_vbox.setPadding(new Insets(10));
        
        //Radio button
        RadioButton eidDeco1 = new RadioButton("Eid Deco 1");
        RadioButton eidDeco2 = new RadioButton("Eid Deco 2");
        RadioButton cnyDeco1 = new RadioButton("CNY Deco 1");        
        RadioButton cnyDeco2 = new RadioButton("CNY Deco 2");
        ToggleGroup FestivalDeco = new ToggleGroup();
        cnyDeco1.setSelected(true);
        FestivalDeco.getToggles().addAll(eidDeco1, eidDeco2, cnyDeco1, cnyDeco2);
        
        
        
        // Text and slider initilization
        Text txt_select_deco = new Text("Select Decoration:");
        Text txt_x_axis_deco = new Text("X_AXIS");
        Text txt_y_axis_deco = new Text("Y_AXIS");
        Text txt_scale_deco = new Text("SCALE");
        Text txt_rotate_deco = new Text("ROTATION");
        
        Slider x_slider_deco = new Slider(0, 100, 0);
        Slider y_slider_deco = new Slider(0, 100, 0);
        Slider size_slider_deco = new Slider(1, 200, 200);
        Slider rotation_slider_deco = new Slider(0, 360, 0);
        
        btn_newFood.setOnAction((t) -> {
            showAddDecorationScreen();
        });
        
        btn_remove_food.setOnAction((t) -> {
            clearDecorationPane();
            decorationList.remove(selectedIndex);
            updateListView();
        });
        
        //toggle button selection operations
//        FestivalDeco.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,  Toggle old_toggle, Toggle new_toggle) -> {
//            RadioButton selectedRadioButton = (RadioButton) FestivalDeco.getSelectedToggle();
//                designPane.getChildren().remove(festival);
//                festival = null;
//              if (selectedRadioButton.getText() == "Eid Deco 1") {
//                festival = new EidDecoration1();
//                  System.out.println(selectedRadioButton.getText());
//              } else if (selectedRadioButton.getText() == "Eid Deco 2") {
//                festival = new EidDecoration2();
//                  System.out.println(selectedRadioButton.getText());
//              } else if (selectedRadioButton.getText() == "CNY Deco 1") {
//                festival = new CNYDecoration1();
//                  System.out.println(selectedRadioButton.getText());
//              } else if (selectedRadioButton.getText() == "CNY Deco 2") {
//                festival = new CNYDecoration2();
//                  System.out.println(selectedRadioButton.getText());
//              }
//                festival.selectDecoration();
//                designPane.getChildren().addAll(festival);
//               di = new DecorationLocation(festival);
//              
//        });
        
//        //x-coordinate listener
//        x_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
//             di = new DecorationLocation(festival);
//            di.location(x_slider_deco.getValue(), design_width-150, "horizontal", di);
//        });
//        
//        //y-coordinate listener
//        y_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
//             di = new DecorationLocation(festival);
//            di.location(y_slider_deco.getValue(), design_height-100, "vertical", di);
//        });
        
        //resize listener
//        size_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
////            imageView.update(size_slider.getValue());
//             di = new DecorationResize(festival);
//            di.resize(size_slider_deco.getValue(),di);
//        });
        
//        //rotation listener
//        rotation_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
//             di = new DecorationRotation(festival);
//            di.rotate(rotation_slider_deco.getValue(), di);
//        });
        
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object t, Object t1) -> {
            selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (t1 != null) {
                System.out.println("Set control to " + t1.toString());
                System.out.println(listView.getSelectionModel().getSelectedIndex());
                
                visible_group_toggle.setVisible(true);
                visible_group_toggle.setManaged(true);
                btn_remove_food.setVisible(true);
                btn_remove_food.setManaged(true);
                
                //resize listener
                size_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ovo, Number to, Number t1o) -> {
                    di = decorationList.get(listView.getSelectionModel().getSelectedIndex());
                    di.resize(size_slider_deco.getValue(),di);
                });
                
                //rotation listener
                rotation_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ovo, Number to, Number t1o) -> {
                     di = decorationList.get(listView.getSelectionModel().getSelectedIndex());
                    di.rotate(rotation_slider_deco.getValue(), di);
                });
                
                //x-coordinate listener
                x_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ovo, Number to, Number t1o) -> {
                     di = decorationList.get(listView.getSelectionModel().getSelectedIndex());
                    di.location(x_slider_deco.getValue(), design_width-150, "horizontal", di);
                });

                //y-coordinate listener
                y_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ovo, Number to, Number t1o) -> {
                     di = decorationList.get(listView.getSelectionModel().getSelectedIndex());
                    di.location(y_slider_deco.getValue(), design_height-100, "vertical", di);
                });
                
                //visibility listener
                visible_group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ovo, Toggle to, Toggle t1o) -> {
                    di = decorationList.get(listView.getSelectionModel().getSelectedIndex());
                    if (visible_group.getSelectedToggle() != null && di != null) {
                        di.setVisibility(Boolean.parseBoolean(visible_group.getSelectedToggle().getUserData().toString()),di);
                    }
                });
                
            } 
            else {
                visible_group_toggle.setVisible(false);
                visible_group_toggle.setManaged(false);
                btn_remove_food.setVisible(false);
                btn_remove_food.setManaged(false);
            }
        });
        
        
               
        
        // add components
        getChildren().addAll(
                btn_box, listView, visible_group_toggle,
//                txt_select_deco,
//                cnyDeco1,
//                cnyDeco2,
//                eidDeco1,
//                eidDeco2,
                txt_x_axis_deco,
                x_slider_deco,
                txt_y_axis_deco,
                y_slider_deco,
                txt_scale_deco,
               size_slider_deco,
                txt_rotate_deco,
                rotation_slider_deco);
    }
    public void showAddDecorationScreen() {
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
        ToggleGroup decoration_radio_btn = new ToggleGroup();
        decoration_radio_btn.getToggles().addAll(btn_raya, btn_cny);
        HBox decoration_radio = new HBox(5);
        decoration_radio.setPadding(new Insets(10));
        decoration_radio.getChildren().addAll(festival_label, btn_cny, btn_raya);
        
        decoration_choice = new ComboBox(FXCollections.observableArrayList(cny_decoration_array));
        
        decoration_radio_btn.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (decoration_radio_btn.getSelectedToggle() != null) {
                System.out.println("Set to " + decoration_radio_btn.getSelectedToggle().getUserData().toString());
                switch (decoration_radio_btn.getSelectedToggle().getUserData().toString()) {
                    case "cny":
                        System.out.println("yesycny");
                        decoration_choice.setItems(FXCollections.observableArrayList(cny_decoration_array));
                        break;
                    case "raya":
                        decoration_choice.setItems(FXCollections.observableArrayList(raya_decoration_array));
                        break;
                }
            }
        });
        
        Button btn_add = new Button("Add");
        btn_add.setOnAction((ActionEvent event) -> {
            List<Object> sliders;
            System.out.println(decoration_choice.getValue().toString() + " is chosen");
            
            
            if (decoration_choice.getValue().equals("Ketupat 1")) {
                festival = new EidDecoration1();
                festival.selectDecoration();
                decorationList.add(festival);
                System.out.println("Displaying Ketupat 1");
            } else if(decoration_choice.getValue().equals("Ketupat 2")){
                festival = new EidDecoration2();
                festival.selectDecoration();
                decorationList.add(festival);
            } else if(decoration_choice.getValue().equals("Red Paper")){
                festival = new CNYDecoration2();
                festival.selectDecoration();
                decorationList.add(festival);
            } else if(decoration_choice.getValue().equals("Tanglong")){
                festival = new CNYDecoration1();
                festival.selectDecoration();
//                designPane.getChildren().addAll(festival);
                decorationList.add(festival);
            }
//            System.out.println(decorationList);
            
            
            
            updateListView();
            stage.close(); // return to main window
        });
        
        box.getChildren().addAll(decoration_radio, decoration_choice, btn_add);
        
        Scene scene = new Scene(box, 250, 150);
        stage.setTitle("Add decoration");
        stage.setScene(scene);
        stage.show();
    }
    
    public void updateListView() {
        listView.getItems().clear();
        for (int i = 0; i < decorationList.size(); i++) {
            designPane.getChildren().remove(decorationList.get(i));
            listView.getItems().add(decorationList.get(i).name);
            designPane.getChildren().addAll(decorationList.get(i));
        }
    }
    public void clearDecorationPane(){
        for (int i = 0; i < decorationList.size(); i++) {
            designPane.getChildren().remove(decorationList.get(i));
        }
    }

}
