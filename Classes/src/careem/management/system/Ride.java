
package careem.management.system;

import java.io.Serializable;


public class Ride implements Serializable{
    private static String[] locations= {"Rider Location","Hospital","School","University","College","Stadium","Airport","Resturant","Super Market"};
    private static int[][] rates= {{0,250,300,600,450,700,1000,300,200},
                                {250,0,200,500,600,650,1200,250,450}
                               ,{300,200,0,500,700,850,1500,300,350}
                               ,{600,500,500,0,300,500,800,450,450},
                                {450,600,700,300,0,600,900,350,500},
                                {700,650,850,500,600,0,750,800,1200}
                               ,{1000,1200,1500,800,900,750,0,1300,1500},
                                {300,250,300,450,350,800,1300,0,250},
                                {200,450,350,450,500,1200,1500,250,0}
    };
    
    public static double rate(int index1,int index2,Rider r){
        if(index1==0 || index2==0){
            return r.getAddress().getStreet()*1.2 + rates[index1][index2];
        }
        else{
            return rates[index1][index2];
        }
    }
    
    public static double driversCut(double fare){
        return fare-fare*0.2;
    }
    
    public static double companyCut(double fare){
        return fare*0.2;
    }

    public static String[] getLocations() {
        return locations;
    }
    
    
}
