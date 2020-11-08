/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;

//import Constants;
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
    
    final int design_width = 850;
    final int design_height = 650;
    DecorationFactory festival = new EidDecoration1();
//    DecorationFactory festival = null;
    
    public DecorationBox(Pane designPane){
        VBox decorations_vbox = new VBox(10);
        decorations_vbox.setPadding(new Insets(10));
        
        RadioButton eidDeco1 = new RadioButton("Eid Deco 1");
        RadioButton eidDeco2 = new RadioButton("Eid Deco 2");
        RadioButton cnyDeco1 = new RadioButton("CNY Deco 1");        
        RadioButton cnyDeco2 = new RadioButton("CNY Deco 2");
        ToggleGroup FestivalDeco = new ToggleGroup();
        cnyDeco1.setSelected(true);
        FestivalDeco.getToggles().addAll(eidDeco1, eidDeco2, cnyDeco1, cnyDeco2);
        
        
        FestivalDeco.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,  Toggle old_toggle, Toggle new_toggle) -> {
            RadioButton selectedRadioButton = (RadioButton) FestivalDeco.getSelectedToggle();
                designPane.getChildren().remove(festival);
                festival = null;
              if (selectedRadioButton.getText() == "Eid Deco 1") {
                festival = new EidDecoration1();
                  System.out.println(selectedRadioButton.getText());
              } else if (selectedRadioButton.getText() == "Eid Deco 2") {
                festival = new EidDecoration2();
                  System.out.println(selectedRadioButton.getText());
              } else if (selectedRadioButton.getText() == "CNY Deco 1") {
                festival = new CNYDecoration1();
                  System.out.println(selectedRadioButton.getText());
              } else if (selectedRadioButton.getText() == "CNY Deco 2") {
                festival = new CNYDecoration2();
                  System.out.println(selectedRadioButton.getText());
              }
                festival.selectDecoration();
                designPane.getChildren().addAll(festival);
              DecorationItem di = new DecorationLocation(festival);
              
        });
        
        
        Text txt_select_deco = new Text("Select Decoration:");
        Text txt_x_axis_deco = new Text("X_AXIS");
        Text txt_y_axis_deco = new Text("Y_AXIS");
        Text txt_scale_deco = new Text("SCALE");
        Text txt_rotate_deco = new Text("ROTATION");
        
        Slider x_slider_deco = new Slider(0, 100, 0);
        Slider y_slider_deco = new Slider(0, 100, 0);
        Slider size_slider_deco = new Slider(1, 200, 200);
        Slider rotation_slider_deco = new Slider(0, 360, 0);
        
        
        x_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            DecorationItem di = new DecorationLocation(festival);
            di.location(x_slider_deco.getValue(), design_width-150, "horizontal", di);
        });
        
        y_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            DecorationItem di = new DecorationLocation(festival);
            di.location(y_slider_deco.getValue(), design_height-100, "vertical", di);
        });
        
        size_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
//            imageView.update(size_slider.getValue());
            DecorationItem di = new DecorationResize(festival);
            di.resize(size_slider_deco.getValue(),di);
        });
        rotation_slider_deco.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            DecorationItem di = new DecorationRotation(festival);
            di.rotate(rotation_slider_deco.getValue(), di);
        });
        
        getChildren().addAll(
                txt_select_deco,
                cnyDeco1,
                cnyDeco2,
                eidDeco1,
                eidDeco2,
                txt_x_axis_deco,
                x_slider_deco,
                txt_y_axis_deco,
                y_slider_deco,
                txt_scale_deco,
               size_slider_deco,
                txt_rotate_deco,
                rotation_slider_deco);
    }
    
    
    
}
