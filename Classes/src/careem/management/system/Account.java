
package careem.management.system;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName;
    private String password;
    private double wallet;

    public Account(String userName, String password, double wallet) {
        this.userName = userName;
        this.password = password;
        this.wallet = wallet;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "\nAccount{" + "userName=" + userName + ", password=" + password + ", wallet amount=" + wallet + '}';
    }
    
    
}
