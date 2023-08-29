
package careem.management.system;


import java.io.*;
import java.util.ArrayList;
public class RideHistoryFileOperations {
    
    public static void writeToFile(RideHistory r) //throws Exception
    {
        try{
            File f = new File("RideHistoryFile.txt");
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
    
    
    public static ArrayList<RideHistory> readFromFile(){
        ArrayList<RideHistory> list = new ArrayList(20);
        try
        {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RideHistoryFile.txt"));
            while(true)
            {
                RideHistory s = (RideHistory) ois.readObject();
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
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("RideHistoryFile.txt"));
        }
        catch (IOException e) {
            System.out.println("Error File Writing");
        }
    
    }
}
