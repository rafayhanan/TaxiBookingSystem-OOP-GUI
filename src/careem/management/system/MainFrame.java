
package careem.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainFrame extends JFrame implements ActionListener {
    JLabel title;
    JPanel p1,p2,p3,p4;
    //JPanel[] panels = {p1,p2,p3,p4};
    JButton admin,rider,driver;
    //Icon i = new ImageIcon(getClass().getResource("careem.png"));
    MainFrame(){
    super.setSize(400,400);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setName("Careem");
    super.setLocationRelativeTo(null);
    super.setLayout((new GridLayout(4,1)));
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    title = new JLabel("CAREEM MANAGEMENT SYSTEM");
    title.setFont(new Font("Seriff",Font.BOLD,19));
    
    admin = new JButton("Admin");
    rider = new JButton("Rider");
    driver = new JButton("Driver");
    
    super.add(p1);
    super.add(p2);
    super.add(p3);
    super.add(p4);
    p1.setLayout(new FlowLayout());
    p2.setLayout(new FlowLayout());
    p3.setLayout(new FlowLayout());
    p4.setLayout(new FlowLayout());
    
    p1.add(title);
    
    p2.add(admin);
    p3.add(rider);
    p4.add(driver);
    
    admin.addActionListener(this);
    rider.addActionListener(this);
    driver.addActionListener(this);
    
    
    super.setVisible(true);
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Admin")){
        dispose();
        AdminGUI newFrame = new AdminGUI();
        }
        if(e.getActionCommand().equals("Rider")){
        dispose();
        RiderGUI r = new RiderGUI();
        }
        else if(e.getActionCommand().equals("Driver")){
        dispose();
        DriverGUI d = new DriverGUI();
        }
    }
    
}
