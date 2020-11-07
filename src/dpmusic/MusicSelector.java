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
 * @author YingShan
 */
public class MusicSelector extends VBox {
    Pane designPane;
    final int design_width = Constants.WIDTH;
    final int design_height = Constants.HEIGHT;
    
    MusicFactory musicFactory;
    Music music;
    
    Button play_btn;
    Button pause_btn;
    Button stop_btn;
    HBox btn_box;
    
    Slider volume_slider;
    
    //select festival radio button
    RadioButton cny_btn;
    RadioButton raya_btn;
    ToggleGroup song_radio;
    HBox song_radioGroup;
    
    //select cny song radio button
    RadioButton cny_song1;
    RadioButton cny_song2;
    ToggleGroup cnySong;
    VBox cnySong_group;
    
    //select raya song radio button
    RadioButton raya_song1;
    RadioButton raya_song2;
    ToggleGroup rayaSong;
    VBox rayaSong_group;
    
    public MusicSelector(Pane designPane) {
        this.designPane = designPane;
        
        //play and stop button
        play_btn = new Button("Play");
        pause_btn = new Button("Pause");
        stop_btn = new Button("Stop");
        play_btn.setDisable(true);
        pause_btn.setVisible(false);
        stop_btn.setVisible(false);
        pause_btn.setManaged(false);
        stop_btn.setManaged(false);
        btn_box = new HBox(2);
        btn_box.getChildren().addAll(play_btn, pause_btn, stop_btn);
        
        //buttons to choose festival
        cny_btn = new RadioButton("CNY");
        cny_btn.setUserData("cny");
        raya_btn = new RadioButton("Raya");
        raya_btn.setUserData("raya");
        song_radio= new ToggleGroup();
        song_radio.getToggles().addAll(cny_btn, raya_btn);
        song_radioGroup = new HBox(5);
        song_radioGroup.setPadding(new Insets(10));
        song_radioGroup.getChildren().addAll(cny_btn, raya_btn);
        
        //buttons to choose cny song
        cny_song1 = new RadioButton("Fu Xing Gao Zhao Cai Shen Dao");
        cny_song1.setUserData("cnySong1");
        cny_song2 = new RadioButton("GongXi GongXi");
        cny_song2.setUserData("cnySong2");
        cnySong = new ToggleGroup();
        cnySong.getToggles().addAll(cny_song1, cny_song2);
        cnySong_group = new VBox();
        cnySong_group.setPadding(new Insets(10,5,10,5));
        cnySong_group.getChildren().addAll(cny_song1, cny_song2);
        cnySong_group.setVisible(false);
        cnySong_group.setManaged(false);
        
        //buttons to choose raya song
        raya_song1 = new RadioButton("Suasana Hari Raya");
        raya_song1.setUserData("rayaSong1");
        raya_song2 = new RadioButton("Selamat Hari Raya");
        raya_song2.setUserData("rayaSong2");
        rayaSong = new ToggleGroup();
        rayaSong.getToggles().addAll(raya_song1, raya_song2);
        rayaSong_group = new VBox();
        rayaSong_group.setPadding(new Insets(10,5,10,5));
        rayaSong_group.getChildren().addAll(raya_song1, raya_song2);
        rayaSong_group.setVisible(false);
        rayaSong_group.setManaged(false);
        
        //set text
        Text volume_text = new Text("Volume");
        Text festivalLabel = new Text("Choose festival: ");
        Text songLabel = new Text("Choose song: ");
        songLabel.setVisible(false);
        songLabel.setManaged(false);
        
        //set slider
        volume_slider = new Slider(0, 1, 1);
        
        //set festival radio button action
        song_radio.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (song_radio.getSelectedToggle() != null) {
                System.out.println("Set to " + song_radio.getSelectedToggle().getUserData().toString());
                switch (song_radio.getSelectedToggle().getUserData().toString()) {
                    case "cny":
                        System.out.println("cny music");
                        cnySong_group.setVisible(true);
                        cnySong_group.setManaged(true);
                        rayaSong_group.setVisible(false);
                        rayaSong_group.setManaged(false);
                        songLabel.setVisible(true);
                        songLabel.setManaged(true);
                        break;
                    case "raya":
                        System.out.println("raya music");
                        rayaSong_group.setVisible(true);
                        rayaSong_group.setManaged(true);
                        cnySong_group.setVisible(false);
                        cnySong_group.setManaged(false);
                        songLabel.setVisible(true);
                        songLabel.setManaged(true);
                        break;
                }
            }
        });
        
        //set cny song radio button action
        cnySong.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (cnySong.getSelectedToggle() != null) {
                System.out.println("Set to " + cnySong.getSelectedToggle().getUserData().toString());
                music = new NewYearSongFactory().prepareSong(cnySong.getSelectedToggle().getUserData().toString());
                music.initMusic();
                play_btn.setDisable(false);
            }
        });
        
         //set raya song radio button action
        rayaSong.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (rayaSong.getSelectedToggle() != null) {
                System.out.println("Set to " + rayaSong.getSelectedToggle().getUserData().toString());
                music = new RayaSongFactory().prepareSong(rayaSong.getSelectedToggle().getUserData().toString());
                music.initMusic();
                play_btn.setDisable(false);
            }
        });
        
        //set play button action
        play_btn.setOnAction((t) -> {
            play_btn.setVisible(false);
            play_btn.setManaged(false);
            pause_btn.setVisible(true);
            pause_btn.setManaged(true);
            stop_btn.setVisible(true);
            stop_btn.setManaged(true);
            music.play();
            song_radioGroup.setDisable(true);
            cnySong_group.setDisable(true);
            rayaSong_group.setDisable(true);
        });
        
        //set pause button action
        pause_btn.setOnAction((t) -> {
            play_btn.setVisible(true);
            play_btn.setManaged(true);
            pause_btn.setVisible(false);
            pause_btn.setManaged(false);
            stop_btn.setVisible(true);
            stop_btn.setManaged(true);
            music.pause();
            song_radioGroup.setDisable(false);
            cnySong_group.setDisable(false);
            rayaSong_group.setDisable(false);
        });
        
        //set stop button action
        stop_btn.setOnAction((t) -> {
            play_btn.setVisible(true);
            play_btn.setManaged(true);
            pause_btn.setVisible(false);
            pause_btn.setManaged(false);
            stop_btn.setVisible(false);
            stop_btn.setManaged(false);
            music.stop();
            song_radioGroup.setDisable(false);
            cnySong_group.setDisable(false);
            rayaSong_group.setDisable(false);
        });
        
        //set slider value
        volume_slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            System.out.println(volume_slider.getValue());
            music.setVolume(volume_slider.getValue());
        });
        
        setPadding(new Insets(10));
        getChildren().addAll(festivalLabel, song_radioGroup, songLabel, cnySong_group, rayaSong_group, btn_box, volume_text, volume_slider);
        
    }
}
