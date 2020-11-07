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
public class RayaSongFactory implements MusicFactory{

    @Override
    public Music prepareSong(String type) {
        Music music = null;
        
        if(type.equalsIgnoreCase("rayaSong1")) {
            music = new rayaSong1();
        } else if (type.equalsIgnoreCase("rayaSong2")) {
            music = new rayaSong2();
        }
        return music;
    }

    
    
}
