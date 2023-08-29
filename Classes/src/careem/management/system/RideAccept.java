
package careem.management.system;


public class RideAccept {
    private String name;
    private String pickup;
    private String dropOff;
    private double fare;

    public RideAccept(String name, String pickup, String dropOff, double fare) {
        this.name = name;
        this.pickup = pickup;
        this.dropOff = dropOff;
        this.fare = fare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "RideAccept{" + "name=" + name + ", pickup=" + pickup + ", dropOff=" + dropOff + ", fare=" + fare + '}';
    }
    
    
}
