package View.Panels;

import Controller.Controller;
import Model.Advertisement;
import Model.Car;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AddAdvertisementPanel extends JPanel {
    private Controller controller;
    private BufferedImage image;

    public AddAdvertisementPanel(Controller controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(Color.darkGray);

        JLabel postLabel = new JLabel("Post an advertisement");
        postLabel.setForeground(Color.white);
        postLabel.setBounds(30, 30, 200, 20);
        add(postLabel);

        ///
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(Color.white);
        priceLabel.setBounds(150, 80, 125, 20);
        add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(275, 80, 200, 20);
        add(priceField);

        JLabel forintsLabel = new JLabel("Ft");
        forintsLabel.setForeground(Color.white);
        forintsLabel.setBounds(485, 80, 100, 20);
        add(forintsLabel);
        ///
        ///
        JLabel brandLabel = new JLabel("Brand:");
        brandLabel.setForeground(Color.white);
        brandLabel.setBounds(150, 110, 125, 20);
        add(brandLabel);

        JTextField brandField = new JTextField();
        brandField.setBounds(275, 110, 200, 20);
        add(brandField);
        ///
        ///
        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setForeground(Color.white);
        modelLabel.setBounds(150, 140, 125, 20);
        add(modelLabel);

        JTextField modelField = new JTextField();
        modelField.setBounds(275, 140, 200, 20);
        add(modelField);
        ///
        ///
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setForeground(Color.white);
        yearLabel.setBounds(150, 170, 125, 20);
        add(yearLabel);

        JTextField yearField = new JTextField();
        yearField.setBounds(275, 170, 200, 20);
        add(yearField);
        ///
        ///
        JLabel fuelTypeLabel = new JLabel("Fuel Type:");
        fuelTypeLabel.setForeground(Color.white);
        fuelTypeLabel.setBounds(150, 200, 125, 20);
        add(fuelTypeLabel);

        String[] fuelTypes = { "Gasoline", "Diesel", "Electric" };
        JComboBox fuelTypeComboBox = new JComboBox(fuelTypes);
        fuelTypeComboBox.setBounds(275, 200, 100, 20);
        add(fuelTypeComboBox);
        ///
        ///
        JLabel cylinderCapacityLabel = new JLabel("Cylinder Capacity:");
        cylinderCapacityLabel.setForeground(Color.white);
        cylinderCapacityLabel.setBounds(150, 230, 125, 20);
        add(cylinderCapacityLabel);

        JTextField cylinderCapacityField = new JTextField();
        cylinderCapacityField.setBounds(275, 230, 200, 20);
        add(cylinderCapacityField);

        JLabel capacityLabel = new JLabel("Litres");
        capacityLabel.setForeground(Color.white);
        capacityLabel.setBounds(485, 230, 100, 20);
        add(capacityLabel);
        ///
        ///
        JLabel performanceInHPLabel = new JLabel("Performance In HP:");
        performanceInHPLabel.setForeground(Color.white);
        performanceInHPLabel.setBounds(150, 260, 125, 20);
        add(performanceInHPLabel);

        JTextField performanceInHPField = new JTextField();
        performanceInHPField.setBounds(275, 260, 200, 20);
        add(performanceInHPField);

        JLabel hpLabel = new JLabel("HP");
        hpLabel.setForeground(Color.white);
        hpLabel.setBounds(485, 260, 100, 20);
        add(hpLabel);
        ///
        ///
        JLabel mileageInKmLabel = new JLabel("Mileage In Km:");
        mileageInKmLabel.setForeground(Color.white);
        mileageInKmLabel.setBounds(150, 290, 125, 20);
        add(mileageInKmLabel);

        JTextField mileageInKmField = new JTextField();
        mileageInKmField.setBounds(275, 290, 200, 20);
        add(mileageInKmField);

        JLabel kmLabel = new JLabel("km");
        kmLabel.setForeground(Color.white);
        kmLabel.setBounds(485, 290, 100, 20);
        add(kmLabel);
        ///
        ///
        JLabel driveLabel = new JLabel("Drive:");
        driveLabel.setForeground(Color.white);
        driveLabel.setBounds(150, 320, 125, 20);
        add(driveLabel);

        String[] driveTypes = { "Front Wheel Drive", "Rear Wheel Drive", "All Wheel Drive" };
        JComboBox driveTypeComboBox = new JComboBox(driveTypes);
        driveTypeComboBox.setBounds(275, 320, 100, 20);
        add(driveTypeComboBox);
        ///
        ///
        JLabel gearboxLabel = new JLabel("Gearbox:");
        gearboxLabel.setForeground(Color.white);
        gearboxLabel.setBounds(150, 350, 125, 20);
        add(gearboxLabel);

        String[] gearboxTypes = { "Manual", "Automatic" };
        JComboBox gearboxComboBox = new JComboBox(gearboxTypes);
        gearboxComboBox.setBounds(275, 350, 100, 20);
        add(gearboxComboBox);
        ///
        ///
        JLabel dialNumberLabel = new JLabel("Dial Number:");
        dialNumberLabel.setForeground(Color.white);
        dialNumberLabel.setBounds(150, 380, 125, 20);
        add(dialNumberLabel);

        JTextField dialNumberField = new JTextField();
        dialNumberField.setBounds(275, 380, 200, 20);
        add(dialNumberField);
        ///
        ///
        JLabel imageLabel = new JLabel("Image:");
        dialNumberLabel.setForeground(Color.white);
        dialNumberLabel.setBounds(150, 410, 125, 20);
        add(dialNumberLabel);

        JButton addImageButton = new JButton("Add Image");
        addImageButton.setBounds(275, 410, 200, 20);

        addImageButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select an image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Images", "png"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try{
                    BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
                    this.image = img;
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
        add(addImageButton);

        JButton postButton = new JButton("Post Advertisement");
        postButton.setBounds(500, 450, 150, 20);
        postButton.addActionListener(e -> {
            if (!priceField.getText().isEmpty() && !brandField.getText().isEmpty() && !modelField.getText().isEmpty() && !yearField.getText().isEmpty() &&
                !cylinderCapacityField.getText().isEmpty() && !performanceInHPField.getText().isEmpty() && !mileageInKmField.getText().isEmpty() &&
                !dialNumberField.getText().isEmpty()) {

                String generatedImageId = this.controller.generateImageId();
                int price = Integer.parseInt(priceField.getText());
                String brand = brandField.getText();
                String model = modelField.getText();
                int year = Integer.parseInt(yearField.getText());
                String fuelType = fuelTypeComboBox.getSelectedItem().toString();
                String cylinderCapacity = cylinderCapacityField.getText();
                int performanceInHP = Integer.parseInt(performanceInHPField.getText());
                int mileageInKm = Integer.parseInt(mileageInKmField.getText());
                String drive = driveTypeComboBox.getSelectedItem().toString();
                String gearbox = gearboxComboBox.getSelectedItem().toString();
                Advertisement advertisement = new Advertisement(new Car(generatedImageId, price, brand, model, year, fuelType, cylinderCapacity, performanceInHP, mileageInKm, drive, gearbox), this.controller.getUsername(), dialNumberField.getText());
                this.controller.addAdvertisement(advertisement);

                String newFilePath1 = "src/View/CarImages/" + generatedImageId + ".png";
                String newFilePath2 = "src/View/CarImagesForMoreInformation/" + generatedImageId + ".png";

                File outputFile1 = new File(newFilePath1);
                File outputFile2 = new File(newFilePath2);
                try {
                    ImageIO.write(this.image, "PNG", outputFile1);
                    ImageIO.write(this.image, "PNG", outputFile2);
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                this.controller.showAdvertisementPostedPanel(advertisement);
            }
        });
        add(postButton);
    }
}
