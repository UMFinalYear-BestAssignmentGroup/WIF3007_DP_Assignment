/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmusic;

/**
 *
 * @author YingShan
 */
public class NewYearSongFactory implements MusicFactory{

    @Override
    public Music prepareSong(String type) {
        Music music = null;
        
        if(type.equalsIgnoreCase("cnySong1")) {
            music = new cnySong1();
        } else if (type.equalsIgnoreCase("cnySong2")) {
            music = new cnySong2();
        }
        return music;
    }

    
    
}
