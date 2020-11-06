/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmusic;

/**
 *
 * @author Ying Shan
 */
public class MusicFactory {
    public Music prepareSong(String type) {
        Music music = null;
        
        if(type.equalsIgnoreCase("cny")) {
            music = new NewYearSong();
        } else if (type.equalsIgnoreCase("raya")) {
            music = new RayaSong();
        }
        return music;
    }
}
