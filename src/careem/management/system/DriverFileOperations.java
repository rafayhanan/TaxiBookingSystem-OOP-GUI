
package careem.management.system;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class DriverFileOperations {
    
    public static void writeToFile(Driver r) //throws Exception
    {
        try{
            File f = new File("DriverFile.txt");
            ObjectOutputStream oos;
            if(f.exists())
            {
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else
            {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(r);
            oos.close();
            }
        
        
            catch(IOException e){
                System.out.println("Error File Writing");
            }
  
    }
    
    
    public static ArrayList<Driver> readFromFile(){
        ArrayList<Driver> list = new ArrayList(20);
        try
        {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverFile.txt"));
            while(true)
            {
                Driver s = (Driver) ois.readObject();
                list.add(s);
            }
            //ois.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found");
        }
        catch(EOFException e){
            return list;
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        return list;
    }
    
    public static void EmptytheFile(){
        try{
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("DriverFile.txt"));
        }
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    }
    
    public static Driver getRandomDriver(){
        ArrayList<Driver> list = new ArrayList();
        list = readFromFile();
        Random rand = new Random();
        int index = rand.nextInt(0,list.size());
        return list.get(index);
    }
    
    
    public static void updateWallet(String name,String username,double wallet){
    ArrayList<Driver> list = readFromFile();
    
    
    for(Driver i:list){
        if(i.getName().equals(name) && i.getAccount().getUserName().equals(username)){
            i.getAccount().setWallet(wallet+i.getAccount().getWallet());
        }
    }
    
    try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverFile.txt"));
            for(Driver i:list){
            oos.writeObject(i);
            }
        } 
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    
    
    }
    
    public static void deleteDriver(String name){
    ArrayList<Driver> list =  readFromFile();
    
    for(Driver d:list){
        if(d.getName().equals(name)){
            list.remove(d);
            break;
        }
    }
    
    try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverFile.txt"));
            for(Driver i:list){
            oos.writeObject(i);
            }
        } 
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    
    
    }
    
    
    public static void updateCarInfo(String name,Car c){
    ArrayList<Driver> list = readFromFile();
    
    for(Driver d:list){
        if(d.getName().equals(name)){
            d.getCar().setColor(c.getColor());
            d.getCar().setCompanyName(c.getCompanyName());
            d.getCar().setModelName(c.getModelName());
            d.getCar().setPlateNo(c.getPlateNo());
            break;
        }
    }
    
    try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverFile.txt"));
            for(Driver i:list){
            oos.writeObject(i);
            }
        } 
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
  
    }
    
    
    public static Driver searchDriver(String name){
    ArrayList<Driver> list = readFromFile();
    
    for(Driver d:list){
        if(d.getName().equals(name)){
            return d;
        }
    }
    return null;
    }
}
