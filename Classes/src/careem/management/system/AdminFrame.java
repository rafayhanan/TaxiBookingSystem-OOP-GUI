package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener{
    JLabel welcome;
    JButton riders,drivers,logout,ridehistory,suspend,update;
    JPanel p1,p2,p3,p4,p5,p6,p7;
    AdminFrame(){
    super.setSize(400,400);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new GridLayout(7,1));
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    p6 = new JPanel();
    p7 = new JPanel();
    super.add(p1);
    super.add(p2);
    super.add(p3);
    super.add(p4);
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    p4.setLayout(new FlowLayout());
    super.add(p5);
    super.add(p6);
    super.add(p7);
    p5.setLayout(new FlowLayout());
    p6.setLayout(new FlowLayout());
    p7.setLayout(new FlowLayout());
    welcome = new JLabel("Welcome to Careem!");
    p1.add(welcome);
    
    riders = new JButton("View Riders");
    drivers = new JButton("View Drivers");
    logout = new JButton("Log Out");
    ridehistory = new JButton("View All Rides");
    suspend = new JButton("Suspend Driver Account");
    update = new JButton("Update Driver Car Info");
    p2.add(riders);
    p3.add(drivers);
    p4.add(ridehistory);
    p5.add(suspend);
    p6.add(update);
    p7.add(logout);
    riders.addActionListener(this);
    drivers.addActionListener(this);
    logout.addActionListener(this);
    ridehistory.addActionListener(this);
    suspend.addActionListener(this);
    update.addActionListener(this);
    super.setVisible(true);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("View Riders")){
            dispose();
            ViewRiderFrame vrf = new ViewRiderFrame();
        }
        else if(e.getActionCommand().equals("View Drivers")){
            dispose();
            ViewDriverFrame vdf = new ViewDriverFrame();        
        }
        else if(e.getActionCommand().equals("Log Out")){
            dispose();
            AdminGUI gui = new AdminGUI();
        }
        else if(e.getActionCommand().equals("View All Rides")){
            dispose();
            ViewAllRidesFrame f = new ViewAllRidesFrame();
        }
        else if(e.getActionCommand().equals("Suspend Driver Account")){
            dispose();
            DeleteDriverFrame ddf = new DeleteDriverFrame();
        }
        else if(e.getActionCommand().equals("Update Driver Car Info")){
            dispose();
            UpdateFrame fr =  new UpdateFrame();
        
        }
        
    }
    
}
