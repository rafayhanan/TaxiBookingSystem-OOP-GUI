
package careem.management.system;

import java.io.Serializable;


public class RideHistory implements Serializable{
    private String rider;
    private String driver;
    private String pickup;
    private String dropOff;
    private double fare;
    private Car car;

    public RideHistory(String rider, String driver, String pickup, String dropOff, double fare, Car car) {
        this.rider = rider;
        this.driver = driver;
        this.pickup = pickup;
        this.dropOff = dropOff;
        this.fare = fare;
        this.car = car;
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "\nRideHistory{" + "rider=" + rider + ", driver=" + driver + ", pickup=" + pickup + ", dropOff=" + dropOff + ", fare=" + fare + ", car=" + car + '}';
    }
    
    
    
}
