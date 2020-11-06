/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmusic;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Constants;

/**
 *
 * @author User
 */
public class MusicSelector extends VBox {
    Pane designPane;
    final int design_width = Constants.WIDTH;
    final int design_height = Constants.HEIGHT;
    
    MusicFactory musicFactory = new MusicFactory();
    Music music;
    
    Button play_btn;
    Button stop_btn;
    HBox btn_box;
    
    Slider volume_slider;
    
    RadioButton cny_btn;
    RadioButton raya_btn;
    ToggleGroup song_radio;
    HBox song_radioGroup;
    
    public MusicSelector(Pane designPane) {
        this.designPane = designPane;
        
        //play and stop button
        play_btn = new Button("Play");
        stop_btn = new Button("Pause");
        stop_btn.setVisible(false);
        stop_btn.setManaged(false);
        btn_box = new HBox(2);
        btn_box.getChildren().addAll(play_btn, stop_btn);
        
        //buttons to choose song
        cny_btn = new RadioButton("CNY");
        cny_btn.setUserData("cny");
        raya_btn = new RadioButton("Raya");
        raya_btn.setUserData("raya");
        song_radio= new ToggleGroup();
        song_radio.getToggles().addAll(cny_btn, raya_btn);
        song_radioGroup = new HBox(5);
        song_radioGroup.setPadding(new Insets(10));
        song_radioGroup.getChildren().addAll(cny_btn, raya_btn);
        
        //set text
        Text volume_text = new Text("Volume");
        Text songLabel = new Text("Choose festival: ");
        
        //set slider
        volume_slider = new Slider(0, 10, 10);
        
        //set radio button action
        song_radio.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (song_radio.getSelectedToggle() != null) {
                System.out.println("Set to " + song_radio.getSelectedToggle().getUserData().toString());
                switch (song_radio.getSelectedToggle().getUserData().toString()) {
                    case "cny":
                        System.out.println("cny music");
                        music = musicFactory.prepareSong("cny");
                        break;
                    case "raya":
                        System.out.println("raya music");
                        music = musicFactory.prepareSong("raya");
                        break;
                }
            }
        });
        
        //set play button action
        play_btn.setOnAction((t) -> {
            play_btn.setVisible(false);
            play_btn.setManaged(false);
            stop_btn.setVisible(true);
            stop_btn.setManaged(true);
            
            //play the song
            music.play();
        });
        
        //set stop button action
        stop_btn.setOnAction((t) -> {
            play_btn.setVisible(true);
            play_btn.setManaged(true);
            stop_btn.setVisible(false);
            stop_btn.setManaged(false);
            music.setStopPlayback(true);
        });
        
        //set slider value
        volume_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            System.out.println(volume_slider.getValue());
        });
        
        setPadding(new Insets(10));
        getChildren().addAll(songLabel, song_radioGroup, btn_box, volume_text, volume_slider);
        
    }
}
