package View.Panels;

import Controller.Controller;
import Model.Advertisement;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CarInformationPanel extends JPanel {
    private Controller controller;
    private Advertisement advertisement;

    public CarInformationPanel(Controller controller, Advertisement advertisement) {
        this.controller = controller;
        this.advertisement = advertisement;
        setLayout(new GridLayout(2, 2));
        setBackground(Color.darkGray);

        this.advertisementBuilder();
    }

    public void advertisementBuilder(){
        JLabel advertisementLabel = new JLabel("<html>" +
                "<table>" +
                "<tr><td>Advertiser:</td><td>" + advertisement.getAdvertisingUser() + "</td></tr>" +
                "<tr><td>Dial number:</td><td>" + advertisement.getDialNumber() + "</td></tr>" +
                "<tr><td>Price:</td><td>" + advertisement.getCar().getPrice() + " Ft</td></tr>" +
                "<tr><td>Brand:</td><td>" + advertisement.getCar().getBrand() + "</td></tr>" +
                "<tr><td>Model:</td><td>" + advertisement.getCar().getModel() + "</td></tr>" +
                "<tr><td>Year:</td><td>" + advertisement.getCar().getYear() + "</td></tr>" +
                "<tr><td>Fuel type:</td><td>" + advertisement.getCar().getFuelType() + "</td></tr>" +
                "<tr><td>Cylinder capacity:</td><td>" + advertisement.getCar().getCylinderCapacity() + "l</td></tr>" +
                "<tr><td>Performance in horsepower:</td><td>" + advertisement.getCar().getPerformanceInHP() + "HP</td></tr>" +
                "<tr><td>Mileage in kilometers:</td><td>" + advertisement.getCar().getMileageInKm() + " km</td></tr>" +
                "<tr><td>Driving:</td><td>" + advertisement.getCar().getDrive() + " Wheel Drive</td></tr>" +
                "<tr><td>Gearbox:</td><td>" + advertisement.getCar().getGearbox() + "</td></tr>" +
                "</table>" +
                "</html>");
        advertisementLabel.setForeground(Color.white);
        advertisementLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        add(advertisementLabel);

        try {
            BufferedImage img = ImageIO.read(new File("src/View/CarImagesForMoreInformation/" + advertisement.getCar().getImageId() + ".png"));
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            imageLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
            add(imageLabel);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        JButton backButton = new JButton("<- Back to browsing");
        backButton.setBackground(Color.darkGray);
        backButton.setForeground(Color.white);
        backButton.addActionListener(e -> { this.controller.showAdvertisementsBrowser(); });
        add(backButton);
    }
}