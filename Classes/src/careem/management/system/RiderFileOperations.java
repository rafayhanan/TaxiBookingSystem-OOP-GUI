
package careem.management.system;

import java.io.*;
import java.util.ArrayList;

public class RiderFileOperations {
    
    public static void writeToFile(Rider r) //throws Exception
    {
        try{
            File f = new File("RiderFile.txt");
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
    
    
    public static ArrayList<Rider> readFromFile(){
        ArrayList<Rider> list = new ArrayList(20);
        try
        {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RiderFile.txt"));
            while(true)
            {
                Rider s = (Rider) ois.readObject();
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
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("RiderFile.txt"));
        }
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    }
    
    public static Rider searchByName(String name){
        ArrayList<Rider> list = new ArrayList();
        list= readFromFile();
        
        for(Rider r:list){
            if(r.getName().equals(name)){
                return r;
            }
        }
    return null;
    }
    
    
    public static void updateWallet(String name,String username,double wallet){
    ArrayList<Rider> list = readFromFile();
    
    
    for(Rider i:list){
        if(i.getName().equals(name) && i.getAccount().getUserName().equals(username)){
            i.getAccount().setWallet(wallet);
        }
    }
    
    try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RiderFile.txt"));
            for(Rider i:list){
            oos.writeObject(i);
            }
        } 
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    
    
    }
}
