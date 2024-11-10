package View.Panels;

import Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RegistrationPanel extends javax.swing.JPanel {
    private Controller controller;
    private Graphics2D graphics;
    private JTextField usernameTF;
    private JPasswordField passwordTF;

    public RegistrationPanel(Controller controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(Color.darkGray);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.white);
        usernameLabel.setBounds(50, 50, 100, 20);
        add(usernameLabel);

        usernameTF = new JTextField();
        usernameTF.setBounds(50, 80, 200, 30);
        add(usernameTF);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(50, 120, 100, 20);
        add(passwordLabel);

        passwordTF = new JPasswordField(10);
        passwordTF.setBounds(50, 150, 200, 30);
        add(passwordTF);

        JButton registerButton = new JButton("Register Account");
        registerButton.setBounds(50, 190, 200, 30);
        registerButton.addActionListener(e -> {
            this.controller.addUser(usernameTF.getText(), passwordTF.getText());
            this.controller.showRegistrationCompletedPanel();
        });
        add(registerButton);
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
