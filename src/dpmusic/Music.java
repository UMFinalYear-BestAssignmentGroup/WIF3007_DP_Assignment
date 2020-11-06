/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmusic;

import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author User
 */
public class Music {

    String songType;
    double volume;
    
    MediaPlayer player = null;
    Media me;

    public String getSong() {
        return songType;
    }
    
    public void setSong (String song) {
        this.songType = song;
    }
    
    void initMusic() {
        String path = new File(songType).getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        player = new MediaPlayer(me);
    }
    
    void play() {
        player.play();
    }
    
    void pause() {
        player.pause();
    }
    
    void stop() {
        player.stop();
    }
    
    public double getVolume() {
        return volume;
    }
    
    public void setVolume(double volume) {
        this.volume = volume;
        player.setVolume(volume);
    }

}


