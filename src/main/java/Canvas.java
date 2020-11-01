
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YShan
 */
public class Canvas extends JFrame{

    private final int design_vertical = 600;
    private final int design_horizontal = 850;

    JPanel designPanel;
    JPanel inputPanel;

    AudioFormat audioFormat;
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    boolean stopPlayback = false;

    final JButton stopBtn = new JButton("Stop");
    final JButton playBtn = new JButton("Play");
    JSlider horizontalSlider;

    public Canvas() {
        //designPanel
        designPanel = new JPanel();
        designPanel.setPreferredSize(new Dimension(design_horizontal, design_vertical));
        designPanel.setBackground(Color.GRAY);
        designPanel.setBounds(0, 0, design_horizontal, design_vertical);

        //inputPanel
        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(250, 600));
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.setBounds(850, 0, 250, 600);

        //set buttons
        stopBtn.setEnabled(false);
        playBtn.setEnabled(true);
        
        inputPanel.add(stopBtn);
        inputPanel.add(playBtn);
        
        //play button action
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopBtn.setEnabled(true);
                playBtn.setEnabled(false);
                //Play the file
                playAudio();
            }
        });
        
        //stop button action
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Terminate playback before EOF
                stopPlayback = true;
            }
        });

        add(designPanel);
        add(inputPanel);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLayout(null);
        setLocation(300, 40);
        setVisible(true);
    }
    
    //Plays back audio data
    private void playAudio() {
        try {
            File soundFile = new File("music/raya2.wav");
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

                //Prepare to playback another file
                stopBtn.setEnabled(false);
                playBtn.setEnabled(true);
                stopPlayback = false;
            } catch (IOException | LineUnavailableException e) {
                System.out.println("Error");
                System.exit(0);
            }
        }
    }

}
