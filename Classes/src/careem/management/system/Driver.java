
package careem.management.system;

import java.io.Serializable;


public class Driver extends Person implements Serializable {
    private Car car;
    private String drivingLisence;
    private Account account;

    public Driver(Car car, String drivingLisence, Account account, String name, String email, int age, String gender, String phoneNum, Address address, Date birthDate) {
        super(name, email, age, gender, phoneNum, address, birthDate);
        this.car = car;
        this.drivingLisence = drivingLisence;
        this.account = account;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDrivingLisence() {
        return drivingLisence;
    }

    public void setDrivingLisence(String drivingLisence) {
        this.drivingLisence = drivingLisence;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return super.toString()+"\nDriver{" + "car=" + car + ", drivingLisence=" + drivingLisence + ", account=" + account + '}';
    }
    
    
    
    
    
    
    
    
}
