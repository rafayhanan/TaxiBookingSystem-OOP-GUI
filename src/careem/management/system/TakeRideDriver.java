
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TakeRideDriver extends JFrame implements ActionListener{
    JLabel title;
    JButton b1,b2,b3,b4,b5,b6;
    JButton[] b_array = {b1,b2,b3,b4,b5,b6};
    JPanel p1,p2,p3;
    JButton close;
    JLabel temp1,temp2;
    int rideNo;
    ArrayList<RideAccept> rideList= new ArrayList();
    TakeRideDriver(String name,String username){
    super.setSize(500,500);
    super.setLocationRelativeTo(null);
    
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    title = new JLabel("TAKE A RIDE");
    super.setLayout(new BorderLayout());
    p1 = new JPanel();
    p2= new JPanel();
    p3= new JPanel();
    close = new JButton("Back");
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    super.add(p3,BorderLayout.SOUTH);
    
    p1.setLayout(new FlowLayout());
    p1.add(title);
    Random rand = new Random();
    rideNo = rand.nextInt(1,6);
    p2.setLayout(new GridLayout(6,1));
    ArrayList<Rider> list = new ArrayList();
    list = RiderFileOperations.readFromFile();
    
    String[] arr = Ride.getLocations();
    
    for(int i=0;i<rideNo;i++){
        if(!list.isEmpty()){
        int source = rand.nextInt(arr.length);
        int destination = rand.nextInt(arr.length);
        if(source == destination){
        if(destination==0){
        destination++;
        }
        else if(destination==arr.length-1){
        destination--;
        }
        else{
            destination++;
        }
        }
        int index = rand.nextInt(list.size()) ;
        String str;
        str = "Name: "+list.get(index).getName()+" Pick-Up: "+arr[source]+" Drop-off: "+arr[destination]+"  Fare: "+Ride.rate(source, destination, list.get(index));
        rideList.add(new RideAccept(list.get(index).getName(),arr[source],arr[destination],Ride.rate(source, destination, list.get(index))));
        list.remove(index);
        b_array[i] = new JButton(str);
        p2.add(b_array[i]);
        b_array[i].addActionListener(this);
        }
        else{
        rideNo=i;
        break;
        }
    }
    p3.setLayout(new FlowLayout());
    p3.add(close);
   
    
    temp1 = new JLabel();
    temp2 = new JLabel();
    temp1.setText(name);
    temp2.setText(username);
    
    close.addActionListener(this);
    
    super.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back")){
        dispose();
        DriverFrame df = new DriverFrame(temp1.getText(),temp2.getText());
        }
        
        ArrayList<Rider> list = new ArrayList();
        list = RiderFileOperations.readFromFile();
        
        ArrayList<Driver> drList = new ArrayList();
        drList = DriverFileOperations.readFromFile();
        Driver dr= drList.get(0);
        for(Driver d: drList){
            if(temp1.getText().equals(d.getName())){
                dr=d;
                break;
            }
        }
        for(int i=0;i<rideNo;i++){
            if(e.getActionCommand().equals(b_array[i].getText())){
                for(Rider r:list){
                    if(b_array[i].getText().contains(r.getName())){
                       RideHistory ride = new RideHistory(r.getName(),temp1.getText(),rideList.get(i).getPickup(),rideList.get(i).getDropOff(),rideList.get(i).getFare(),dr.getCar());
                       int result = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to take this ride?");
                       if(result==JOptionPane.YES_OPTION){
                       RideHistoryFileOperations.writeToFile(ride);
//                       ArrayList<RideHistory> ridehistoryList = new ArrayList();
//                       ridehistoryList = RideHistoryFileOperations.readFromFile();
//                       System.out.println(ridehistoryList);
                       JOptionPane.showMessageDialog(new JFrame(), "RIDE COMPLETED");
                       DriverFileOperations.updateWallet(dr.getName(),dr.getAccount().getUserName(),Ride.driversCut(rideList.get(i).getFare()) );
                       dispose();
                       DriverFrame newFrame = new DriverFrame(temp1.getText(),temp2.getText());
                       }
                    }
                }
            }
        }   
   
    }
    
}

