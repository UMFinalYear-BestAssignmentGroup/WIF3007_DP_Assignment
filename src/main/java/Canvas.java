
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin
 */
public class Canvas extends JFrame implements ActionListener {

    private final int design_vertical = 600;
    private final int design_horizontal = 850;

    JPanel designPanel;
    JPanel inputPanel;

    FoodItem imgLabel;
    Dumplings dumplings;
    YeeSang yeesang;

    JButton imgButton;
    JSlider verticalSlider;
    JSlider horizontalSlider;
    JSlider scaleSlider;

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
        imgButton = new JButton("Change Food");
        imgButton.addActionListener(this);
        inputPanel.add(imgButton);

        //sliders
        verticalSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        verticalSlider.addChangeListener((e) -> {
            JSlider slider = (JSlider) e.getSource();
            imgLabel.update(slider.getValue(), design_vertical, "vertical");
        });
        inputPanel.add(verticalSlider);

        horizontalSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        horizontalSlider.addChangeListener((e) -> {
            JSlider slider = (JSlider) e.getSource();
            imgLabel.update(slider.getValue(), design_horizontal, "horizontal");
        });
        inputPanel.add(horizontalSlider);

        scaleSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        scaleSlider.addChangeListener((e) -> {
            JSlider slider = (JSlider) e.getSource();
            imgLabel.update(slider.getValue());
        });
        inputPanel.add(scaleSlider);

        //initialize foods
        dumplings = new Dumplings();
        yeesang = new YeeSang();
        designPanel.add(dumplings);
        designPanel.add(yeesang);
        imgLabel = dumplings;
        designPanel.add(imgLabel);

        add(designPanel);
//        add(inputPanel, BorderLayout.EAST);
add(inputPanel);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
         setLayout(null);
        setLocation(300, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == imgButton) {
            if (imgLabel instanceof Dumplings) {
                System.out.println("Set to YeeSang");
                imgLabel = yeesang;
            } else if (imgLabel instanceof YeeSang) {
                System.out.println("Set to Dumplings");
                imgLabel = dumplings;
            }

        }
    }
}
