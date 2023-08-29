
package careem.management.system;

import java.io.Serializable;


public class Rider extends Person implements Serializable{
    private Account account;

    public Rider(Account account, String name, String email,int age, String gender, String phoneNum, Address address, Date birthDate) {
        super(name, email,age, gender, phoneNum, address, birthDate);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return super.toString()+"\nRider{" + "account=" + account.toString() + '}';
    }

    

   
    
    
}
