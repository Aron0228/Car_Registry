package View.Panels;

import Controller.Controller;
import Model.Advertisement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AdvertisementPostedPanel extends JPanel {
    private Controller controller;
    private Advertisement advertisement;
    private Graphics2D graphics;

    public AdvertisementPostedPanel(Controller controller, Advertisement advertisement) {
        this.controller = controller;
        this.advertisement = advertisement;

        setLayout(null);
        setBackground(Color.darkGray);

        JLabel advertisementLabel = new JLabel("Your advertisement was posted successfully!");
        advertisementLabel.setForeground(Color.white);
        advertisementLabel.setBounds(50, 50, 100, 20);
        add(advertisementLabel);

        JButton advertisementButton = new JButton("Open Advertisement");
        advertisementButton.setBounds(50, 80, 250, 20);
        advertisementButton.addActionListener(e -> { this.controller.showMoreInformationAboutAdvertisement(advertisement); });
        add(advertisementButton);

        JButton browseAdvertisementsButton = new JButton("Browse Advertisements");
        browseAdvertisementsButton.setBounds(320, 80, 250, 20);
        browseAdvertisementsButton.addActionListener(e -> { this.controller.showAdvertisementsBrowser(); });
        add(browseAdvertisementsButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics = (Graphics2D) g;

        try{
            BufferedImage img = ImageIO.read(new File("src/View/Images/loginImage.png"));
            graphics.drawImage(img, 250, 200, null);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
