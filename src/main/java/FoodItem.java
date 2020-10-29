
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public class FoodItem extends JLabel implements FoodObserver{
    public String name;
    public String location;
    public int x;
    public int y;
    public double scale;
    public BufferedImage image;
    
    public FoodItem() {}
    
    public BufferedImage resize(String inputImagePath,
            int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 1, 1, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
    }

    public BufferedImage resize(String inputImagePath,
            double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        BufferedImage outputImage = resize(inputImagePath, scaledWidth, scaledHeight);
        return outputImage;
    }

    @Override
    public void update(int slider, int length, String orientation) {
        if(orientation == "horizontal") {
            x = (int) (slider * length) / 100;
        } else if (orientation == "vertical") {
            y = (int)(slider * length) / 100;
        }
        setLocation(x, y);
    }

    @Override
    public void update(int scale) {
        double scaleTmp = (double)scale/10;
        try {
            image = resize(location, scaleTmp);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        setIcon(new ImageIcon(image));
    }
}
