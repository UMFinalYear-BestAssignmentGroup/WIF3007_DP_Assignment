
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Melvin
 */
public class FoodItem extends ImageView implements FoodObserver {
    public String name;
    public String location;
    public double size;

    public FoodItem() {
        setPreserveRatio(true);
        setFitHeight(200);
    }

    public FoodItem setItem() {
        try {
            setImage(new Image(new FileInputStream(location)));
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        size = getFitHeight();
        return this;
    }
//    public BufferedImage resize(String inputImagePath,
//            int scaledWidth, int scaledHeight)
//            throws IOException {
//        // reads input image
//        File inputFile = new File(inputImagePath);
//        BufferedImage inputImage = ImageIO.read(inputFile);
//
//        // creates output image
//        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
//
//        // scales the input image to the output image
//        Graphics2D g2d = outputImage.createGraphics();
//        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
//        g2d.dispose();
//
//        return outputImage;
//    }
//
//    public BufferedImage resize(String inputImagePath,
//            double percent) throws IOException {
//        File inputFile = new File(inputImagePath);
//        BufferedImage inputImage = ImageIO.read(inputFile);
//        int scaledWidth = (int) (inputImage.getWidth() * percent);
//        int scaledHeight = (int) (inputImage.getHeight() * percent);
//        BufferedImage outputImage = resize(inputImagePath, scaledWidth, scaledHeight);
//        return outputImage;
//    }

    @Override
    public void update(double slider, int length, String orientation) {
        if ("horizontal".equals(orientation)) {
            System.out.println("X:" + (slider * length) / 100);
            setX((slider * length) / 100);
        } else if ("vertical".equals(orientation)) {
            setY((slider * length) / 100);
            System.out.println("Y:" + (slider * length) / 100);
        }
    }

    @Override
    public void update(double scale) {
        setFitHeight(scale);
    }
}
