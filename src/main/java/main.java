
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //main panel
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.GRAY);
        
        //designPanel
        JPanel designPanel = new JPanel();
        designPanel.setPreferredSize(new Dimension(750, 600));
        designPanel.setBackground(Color.GRAY);
        
        //inputPanel
        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(250, 600));
        inputPanel.setBackground(Color.RED);
        
        mainFrame.getContentPane().add(designPanel);
        mainFrame.getContentPane().add(inputPanel, BorderLayout.EAST);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
}
