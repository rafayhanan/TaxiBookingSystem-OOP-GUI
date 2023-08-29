
package careem.management.system;

import java.io.Serializable;

public class Address implements Serializable{
   

    private String home;
    private int street;
    
    
    public Address(){
    home = " ";
    street=1;
    
    }
    public Address(String h,int s){
    home=h;
    street=s;
    
    }
    public Address(Address a){
    this.home=a.home;
    this.street=a.street;
    
    }
    public void setHome(String h){
    home=h;
    }
    public void setStreet(int s){
    street =s;
    }
    
    public String getHome(){
    return home;
    }
    public int getStreet(){
    return street;
    }
    

    @Override
    public String toString() {
        return "\nAddress{" + "home=" + home + ", street=" + street + '}';
    }
    
}
