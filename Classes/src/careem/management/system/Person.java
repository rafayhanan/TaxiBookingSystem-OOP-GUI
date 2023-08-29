
package careem.management.system;

import java.io.Serializable;

public class Person implements Serializable{
    private String name;
    private String email;
    private int age;
    private String gender;
    private String phoneNum;
    private Address address;
    private Date birthDate;
    
    
    public Person(String name, String email,int age,String gender,String phoneNum, Address address, Date birthDate) {
        this.name = name;
        this.email = email;
        this.age=age;
        this.gender=gender;
        this.phoneNum = phoneNum;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
    @Override
    public String toString() {
        return "\nPerson{" + "name=" + name + ", email=" + email +", age="+age+", phone number="+phoneNum+ ", address="+address.toString() + ", birthDate=" + birthDate.toString() + '}';
    }
 
    
}
