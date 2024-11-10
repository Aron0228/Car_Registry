package Controller;

import Model.Advertisement;
import Model.Car;
import Model.User;
import View.BaseFrame;
import View.Panels.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Controller {
    private ArrayList<Advertisement> advertisements;
    private BaseFrame frame;
    private JPanel currentPanel;
    private List<User> users;
    private User user;

    public Controller() {
        users = new ArrayList<>();
        advertisements = new ArrayList<>();
        try {
            Path filePath = Paths.get("src/Controller/usernamesPasswords.txt");
            List<String> lines = Files.readAllLines(filePath);

            List<String> usernames = new ArrayList<>();
            List<String> passwords = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                if (i % 2 == 0) {
                    usernames.add(lines.get(i));
                }
                else {
                    passwords.add(lines.get(i));
                }
            }

            for (int i = 0; i < usernames.size(); i++) {
                users.add(new User(usernames.get(i), passwords.get(i)));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Path filePath = Paths.get("src/Controller/advertisedCars.txt");
            List<String> lines = Files.readAllLines(filePath);
            List<String> advertisedCars = new ArrayList<>();
            List<String> usernames = new ArrayList<>();
            List<String> dialNumbers = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                if (i % 3 == 0) {
                    advertisedCars.add(lines.get(i));
                }
                else if (i % 3 == 1) {
                    usernames.add(lines.get(i));
                }
                else if (i % 3 == 2) {
                    dialNumbers.add(lines.get(i));
                }
            }

            for (int i = 0; i < advertisedCars.size(); i++) {
                String imageId = advertisedCars.get(i).split(" ")[0];
                int price = Integer.parseInt(advertisedCars.get(i).split(" ")[1]);
                String brand = advertisedCars.get(i).split(" ")[2];
                String model = advertisedCars.get(i).split(" ")[3];
                int year = Integer.parseInt(advertisedCars.get(i).split(" ")[4]);
                String fuelType = advertisedCars.get(i).split(" ")[5];
                String cylinderCapacity = advertisedCars.get(i).split(" ")[6];
                int performanceInHP = Integer.parseInt(advertisedCars.get(i).split(" ")[7]);
                int mileageInKm = Integer.parseInt(advertisedCars.get(i).split(" ")[8]);
                String drive = advertisedCars.get(i).split(" ")[9];
                String gearbox = advertisedCars.get(i).split(" ")[10];

                this.advertisements.add(new Advertisement(new Car(imageId, price, brand, model, year, fuelType, cylinderCapacity, performanceInHP, mileageInKm, drive, gearbox), usernames.get(i), dialNumbers.get(i)));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        frame = new BaseFrame();
        currentPanel = new LoginPanel(this);
        frame.add(currentPanel);
        frame.setVisible(true);
    }

    public void showLoginPanel(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new LoginPanel(this);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void addAdvertisement(Advertisement advertisement){
        advertisements.add(advertisement);

        String filePath = "src/Controller/advertisedCars.txt";
        String line1 = advertisement.getCar().getImageId() + " " + advertisement.getCar().getPrice() + " " + advertisement.getCar().getBrand() + " " + advertisement.getCar().getModel()
                + " " + advertisement.getCar().getYear() + " " + advertisement.getCar().getFuelType() + " " + advertisement.getCar().getCylinderCapacity()
                + " " + advertisement.getCar().getPerformanceInHP() + " " + advertisement.getCar().getMileageInKm() + " " + " " + advertisement.getCar().getDrive() + " " + advertisement.getCar().getGearbox();
        String line2 = advertisement.getAdvertisingUser();
        String line3 = advertisement.getDialNumber();
        try (FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(line1 + System.lineSeparator() + line2 + System.lineSeparator() + line3 + System.lineSeparator());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void authenticate(String username, String password){
        boolean authenticated = false;
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                authenticated = true;
                this.user = user;
                break;
            }
        }

        if(!authenticated){
            return;
        }

        this.showAfterLoginPanel();
    }

    public String generateImageId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getUsername(){
        return user.getUsername();
    }

    public void showMoreInformationAboutAdvertisement(Advertisement advertisement){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new CarInformationPanel(this, advertisement);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void showAdvertisementsBrowser(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new CarBrowsingPanel(this, this.advertisements);
        this.frame.getContentPane().add(new JScrollPane(currentPanel));
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void showAfterLoginPanel(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new AfterLoginPanel(this);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void showAddAdvertisementPanel(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new AddAdvertisementPanel(this);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void showAdvertisementPostedPanel(Advertisement advertisement){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new AdvertisementPostedPanel(this, advertisement);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void addUser(String username, String password){
        this.users.add(new User(username, password));

        String filePath = "src/Controller/usernamesPasswords.txt";
        String line1 = username;
        String line2 = password;
        try (FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(line1 + System.lineSeparator() + line2 + System.lineSeparator());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showRegistrationPanel(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new RegistrationPanel(this);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }

    public void showRegistrationCompletedPanel(){
        this.frame.getContentPane().removeAll();
        this.currentPanel = new RegistrationCompletedPanel(this);
        this.frame.getContentPane().add(currentPanel);
        this.frame.revalidate();
        this.frame.repaint();
        this.frame.setVisible(true);
    }
}
