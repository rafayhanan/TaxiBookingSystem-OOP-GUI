
package careem.management.system;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;
    
    public Date(){
        day=1;
        month=1;
        year=1969;
    
    }
    
    public Date(int a,int b,int c){
        day=a;
        month=b;
        year=c;
    
    }
    
    public Date(Date d){
        this.day=d.day;
        this.month=d.month;
        this.year=d.year;
        
    }
    
    public int getAge(){
    return 2022-year;
    }
    
    public void setDay(int a){
    day=a;
    }
    public void setMonth(int m){
    month=m;
    }
    public void setYear(int y){
    year=y;
    }
    public int getDay(){
    return day;
    }
    public int getMonth(){
    return month;
    }
    public int getYear(){
    return year;
    }

    @Override
    public String toString() {
        return "\nDate{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
    }
    
    
}




