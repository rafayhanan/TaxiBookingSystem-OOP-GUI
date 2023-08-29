
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class TakeRideRider extends JFrame implements ActionListener,ItemListener{
    JLabel title;
    JRadioButton rb1;
    JLabel source,destination,rate;
    JTextField t1,t2,t3;
    JComboBox c1,c2;
    JButton ride,back;
    JScrollPane sp;
    JTextArea area;
    JPanel p1,p2,p3,p4;
    JLabel n;
    TakeRideRider(String name){
    super.setSize(500,500);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new BorderLayout());
    n = new JLabel(name);
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    super.add(p3,BorderLayout.SOUTH);
    
    c1 = new JComboBox(Ride.getLocations());
    c2 = new JComboBox(Ride.getLocations());
    
    p1.setLayout(new FlowLayout());
    title = new JLabel("BOOK A RIDE");
    p1.add(title);
    
    p2.setLayout(new BorderLayout());
    source = new JLabel("From: ");
    t1 = new JTextField();
    destination = new JLabel("To: ");
    t2 = new JTextField();
    rate = new JLabel("Rate: ");
    t3 = new JTextField();
    t3.setEditable(false);
    
    p2.add(p4,BorderLayout.NORTH);
    p4.setLayout(new GridLayout(3,2));
    p4.add(source);p4.add(c1);
    p4.add(destination);p4.add(c2);
    p4.add(rate);p4.add(t3);
    
    area = new JTextArea();
    sp = new JScrollPane(area);
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    p2.add(sp,BorderLayout.CENTER);
    
    p3.setLayout(new FlowLayout());
    ride = new JButton("Book");
    back = new JButton("Back");
    p3.add(ride);p3.add(back);
    
    
    c1.addItemListener(this);
    c2.addItemListener(this);
    ride.addActionListener(this);
    back.addActionListener(this);
    
    super.setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Book")){
            if(t3.getText().equals("Set Different Locations!")){
            JOptionPane.showMessageDialog(new JFrame(), "Please set different locations beforing booking.");
            }
        else{
        Driver d = DriverFileOperations.getRandomDriver();
        Rider r = RiderFileOperations.searchByName(n.getText());
        String[] arr = Ride.getLocations();
        
        RideHistory ride = new RideHistory(r.getName(),d.getName(),arr[c1.getSelectedIndex()],arr[c2.getSelectedIndex()],Double.parseDouble(t3.getText()),d.getCar());
        String str = "\nYour Name: "+r.getName()+"\nDriver Name: "+d.getName()+"\nFrom: "+arr[c1.getSelectedIndex()]+"\nTo: "+arr[c2.getSelectedIndex()]+"\nFare: "+ride.getFare()+"\n\nCar: "+d.getCar().getCarInfo()+"\n";
//        area.append(str);
        area.insert(str,0);
        //JOptionPane.showMessageDialog(new JFrame(), "Ride Completed! Thank you for travelling with Careem!");
        int result = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to take this ride?");
        if(result==JOptionPane.YES_OPTION){
            area.append("RIDE COMPLETED");
            RideHistoryFileOperations.writeToFile(ride);
            //d.getAccount().setWallet(Ride.driversCut(ride.getFare())); //wallet ko file mai write krwao
            DriverFileOperations.updateWallet(d.getName(), d.getAccount().getUserName(),Ride.driversCut(ride.getFare()));
            
            ArrayList<Driver> list = new ArrayList();
            list = DriverFileOperations.readFromFile();
            System.out.println();
        }
        
        
        
       

            }
        }
        else if(e.getActionCommand().equals("Back")){
        dispose();
        Rider r = RiderFileOperations.searchByName(n.getText());
        RiderFrame rf = new RiderFrame(r.getName(),r.getAccount().getUserName());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED){
            Rider r = RiderFileOperations.searchByName(n.getText());
            int rate = (int) Ride.rate(c1.getSelectedIndex(), c2.getSelectedIndex(), r);
            
            if(rate!=0){
            t3.setText(Double.toString(rate));
            }
            else{
            t3.setText("Set Different Locations!");
            }
            
            
        }
    }
    
}
