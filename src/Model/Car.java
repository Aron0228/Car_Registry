package Model;

public class Car {
    private String imageId;
    private int price;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String cylinderCapacity;
    private int performanceInHP;
    private int mileageInKm;
    private String drive;
    private String gearbox;

    public Car(String imageId, int price, String brand, String model, int year, String fuelType, String cylinderCapacity, Integer performanceInHP, int mileageInKm, String drive, String gearbox) {
        this.imageId = imageId;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.cylinderCapacity = cylinderCapacity;
        this.performanceInHP = performanceInHP;
        this.mileageInKm = mileageInKm;
        this.drive = drive;
        this.gearbox = gearbox;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + year;
    }

    public String getImageId() {
        return imageId;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public int getPerformanceInHP() {
        return performanceInHP;
    }

    public int getMileageInKm() {
        return mileageInKm;
    }

    public String getDrive() {
        return drive;
    }

    public String getGearbox() {
        return gearbox;
    }
}
