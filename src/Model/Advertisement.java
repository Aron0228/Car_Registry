package Model;

public class Advertisement {
    private Car car;
    private String advertisingUser;
    private String dialNumber;

    public Advertisement(Car car, String advertisingUser, String dialNumber) {
        this.car = car;
        this.advertisingUser = advertisingUser;
        this.dialNumber = dialNumber;
    }

    public Car getCar() {
        return car;
    }

    public String getAdvertisingUser() {
        return advertisingUser;
    }

    public String getDialNumber() {
        return dialNumber;
    }
}
