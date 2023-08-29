
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverFrame extends JFrame implements ActionListener{
    JLabel title,n,phoneNum,wallet;
    JLabel temp;
    JTextField t1,t2,t3,tempt;
    JPanel p1,p2,p3,p4,rideP,historyP,logoutP;
    JButton ride,logout,history;
    
    DriverFrame(String name,String username){
    super.setSize(500,500);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new BorderLayout());
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    rideP= new JPanel();
    historyP = new JPanel();
    logoutP = new JPanel();
    
    ride = new JButton("Take Ride");
    logout = new JButton("Log Out");
    history = new JButton("Ride History");
    
    rideP.setLayout(new FlowLayout());
    historyP.setLayout(new FlowLayout());
    logoutP.setLayout(new FlowLayout());
    
    rideP.add(ride);historyP.add(history);logoutP.add(logout);
    
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    temp = new JLabel(" ");
    p1.setLayout(new FlowLayout());
    p2.setLayout(new GridLayout(4,1));
    p2.add(p3);
    p2.add(rideP);p2.add(historyP);p2.add(logoutP);
    p3.setLayout(new GridLayout(1,1));
    p3.add(p4);
    p3.add(temp);
    p4.setLayout(new GridLayout(3,2));
    
    
    title = new JLabel("WELCOME TO CAREEM!");
    p1.add(title);
    
    n = new JLabel("Name: ");
    phoneNum = new JLabel("Phone Number: ");
    wallet = new JLabel("Wallet: ");
    
    t1= new JTextField();
    t2= new JTextField();
    t3= new JTextField();
    tempt = new JTextField();
    
    t1.setEditable(false);
    t2.setEditable(false);
    t3.setEditable(false);
    
    
    p4.add(n);p4.add(t1);
    p4.add(phoneNum);p4.add(t2);
    p4.add(wallet);p4.add(t3);
    
    ArrayList<Driver> list = new ArrayList();
    list = DriverFileOperations.readFromFile();
    for(Driver r:list){
        if(r.getName().equals(name)&&r.getAccount().getUserName().equals(username)){
            t1.setText(name);
            t2.setText(r.getPhoneNum());
            t3.setText(Double.toString(r.getAccount().getWallet()));
            tempt.setText(r.getAccount().getUserName());
        }
    }
    ride.addActionListener(this);
    history.addActionListener(this);
    logout.addActionListener(this);
    super.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Log Out")){
        dispose();
        DriverGUI gui = new DriverGUI();
        }
        else if(e.getActionCommand().equals("Take Ride")){
        dispose();
        TakeRideDriver trd = new TakeRideDriver(t1.getText(),tempt.getText());
        }
        else if(e.getActionCommand().equals("Ride History")){
        dispose();
        DriverRideHistory drh =  new DriverRideHistory(t1.getText());
        }
    }
    
}

