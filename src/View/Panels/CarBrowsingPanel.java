package View.Panels;

import Controller.Controller;
import Model.Advertisement;
import Model.Car;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class CarBrowsingPanel extends JPanel {
    private Graphics2D graphics;
    private Controller controller;

    public CarBrowsingPanel(Controller controller, ArrayList<Advertisement> advertisements) {
        this.controller = controller;

        setLayout(new GridLayout(advertisements.size(), 3));
        setBackground(Color.darkGray);

        this.advertisementsBuilder(advertisements);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics = (Graphics2D) g;
    }

    void advertisementsBuilder(ArrayList<Advertisement> advertisements) {
        ArrayList<Car> advertisedCars = new ArrayList<Car>();

        for (Advertisement advertisement : advertisements) {
            advertisedCars.add(advertisement.getCar());
        }

        for (Car car : advertisedCars) {
            JLabel carLabel = new JLabel("<html>" + car.getBrand() + " " + car.getModel() + " " + car.getYear() + "<br>" + car.getFuelType() + " " + car.getCylinderCapacity() + "l " + car.getPerformanceInHP() + "HP<br>" + car.getMileageInKm() + " km<br>" + car.getPrice() + " Ft</html>");
            carLabel.setForeground(Color.WHITE);
            carLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
            add(carLabel);

            JButton moreInformationButton = new JButton("More information...");
            moreInformationButton.setBackground(Color.darkGray);
            moreInformationButton.setForeground(Color.WHITE);
            moreInformationButton.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
            moreInformationButton.addActionListener(e -> { this.controller.showMoreInformationAboutAdvertisement(advertisements.get(advertisedCars.indexOf(car))); });
            add(moreInformationButton);

            try{
                String filePath = "src/View/CarImages/" + car.getImageId() + ".png";
                BufferedImage img = ImageIO.read(new File(filePath));
                JLabel imageLabel = new JLabel(new ImageIcon(img));
                imageLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
                add(imageLabel);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}