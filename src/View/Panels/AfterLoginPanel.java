package View.Panels;

import Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AfterLoginPanel extends javax.swing.JPanel {
    private Controller controller;
    private Graphics2D graphics;

    public AfterLoginPanel(Controller controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(Color.darkGray);

        JLabel selectionLabel = new JLabel("Select one option!");
        selectionLabel.setForeground(Color.white);
        selectionLabel.setBounds(50, 50, 200, 20);
        add(selectionLabel);

        JButton addAdvertisement = new JButton("Add Advertisement");
        addAdvertisement.setBounds(50, 80, 200, 50);
        addAdvertisement.addActionListener(e -> { this.controller.showAddAdvertisementPanel(); });
        add(addAdvertisement);

        JButton browseAdvertisements = new JButton("Browse Advertisements");
        browseAdvertisements.setBounds(50, 140, 200, 50);
        browseAdvertisements.addActionListener(e -> { this.controller.showAdvertisementsBrowser(); });
        add(browseAdvertisements);
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
