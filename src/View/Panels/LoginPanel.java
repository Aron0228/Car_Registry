package View.Panels;

import Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class LoginPanel extends javax.swing.JPanel {
    private Graphics2D graphics;
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private Controller controller;

    public LoginPanel(Controller controller) {
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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 190, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> { this.controller.authenticate(usernameTF.getText(), passwordTF.getText()); });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(50, 230, 100, 30);
        add(registerButton);

        registerButton.addActionListener(e -> { this.controller.showRegistrationPanel(); });
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
