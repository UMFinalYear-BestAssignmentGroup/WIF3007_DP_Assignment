/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpmusic;

import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author User
 */
public class Music {

    String songType;
//    int volume;
    
    AudioFormat audioFormat;
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    boolean stopPlayback =false;

    public String getSong() {
        return songType;
    }
    
    public void setSong (String song) {
        this.songType = song;
    }
    
    public void setStopPlayback(boolean stopPlayBack) {
        this.stopPlayback = stopPlayBack;
    }
    
    public boolean getStopPlayback(){
        return stopPlayback;
    }
    
    void play() {
        try {
            File soundFile = new File(songType);
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioInputStream.getFormat();
            //System.out.println(audioFormat);

            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

            //Create a thread to play back the data and start it running. It will run until the end of file, or Stop button is clicked.
            new PlayThread().start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("File error");
            System.exit(0);
        }
    }
    
    class PlayThread extends Thread {

        byte tempBuffer[] = new byte[10000];

        @Override
        public void run() {
            try {
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                int cnt;
                //Keep looping until the input read method returns -1 for empty stream or the user clicks the Stop button causing stopPlayback to switch from false to true.
                while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1 && stopPlayback == false) {
                    if (cnt > 0) {
                        //Write data to the internal buffer of the data line where it will be delivered to the speaker.
                        sourceDataLine.write(
                                tempBuffer, 0, cnt);
                    }
                }
                //Block and wait for internal buffer of the data line to empty.
                sourceDataLine.drain();
                sourceDataLine.close();
                
                //prepare to playback another file
                stopPlayback = false;
            } catch (IOException | LineUnavailableException e) {
                System.out.println("Error");
                System.exit(0);
            }
        }
    }
    
//    public int getVolume() {
//        return volume;
//    }
//    
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

}


