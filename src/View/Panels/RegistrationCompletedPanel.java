package View.Panels;

import Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RegistrationCompletedPanel extends javax.swing.JPanel {
    private Controller controller;
    private Graphics2D graphics;

    public RegistrationCompletedPanel(Controller controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(Color.darkGray);

        JLabel registrationCompletedLabel = new JLabel("Registration Completed!");
        registrationCompletedLabel.setForeground(Color.white);
        registrationCompletedLabel.setBounds(50, 50, 200, 20);
        add(registrationCompletedLabel);

        JButton okButton = new JButton("OK");
        okButton.setBounds(50, 80, 200, 20);
        okButton.addActionListener(e -> { this.controller.showLoginPanel(); });
        add(okButton);
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
