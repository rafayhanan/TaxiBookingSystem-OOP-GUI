
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UpdateFrame extends JFrame implements ActionListener {
    JLabel title,l1,l2,l3,l4,l5;
    JComboBox c;
    String[] arr;
    JPanel top,center,bottom,p1;
    JTextField t2,t3,t4,t5;
    JButton update,back;
    UpdateFrame(){
    super.setSize(500,500);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new BorderLayout());
    
    title = new JLabel("Update Car Information");
    
    ArrayList<Driver> list = DriverFileOperations.readFromFile();
    arr = new String[list.size()];
    
    for(int i=0;i<list.size();i++){
        arr[i]=list.get(i).getName();
    }
    
    c = new JComboBox(arr);
    
    top = new JPanel();
    center = new JPanel();
    bottom = new JPanel();
    
    super.add(top,BorderLayout.NORTH);
    super.add(center,BorderLayout.CENTER);
    super.add(bottom,BorderLayout.SOUTH);
    
    update = new JButton("Update");
    back = new JButton("Back");
    
    bottom.setLayout(new FlowLayout());
    bottom.add(update);
    bottom.add(back);
    
    top.setLayout(new FlowLayout());
    top.add(title);
    
    center.setLayout(new GridLayout(5,2));
    l1 = new JLabel("Driver Name: ");
    center.add(l1);
    p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(c);
    center.add(p1);
    
    l2 = new JLabel("Plate no: ");
    l3 = new JLabel("Company name: ");
    l4 = new JLabel("Model no: ");
    l5= new JLabel("Color: ");
    
    t2= new JTextField();
    t3= new JTextField();
    t4 = new JTextField();
    t5 = new JTextField();
    
    center.add(l2);center.add(t2);
    center.add(l3);center.add(t3);
    center.add(l4);center.add(t4);
    center.add(l5);center.add(t5);
    
    update.addActionListener(this);
    back.addActionListener(this);
    
    super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Update")){
        Car car = new Car(t2.getText(),t3.getText(),t4.getText(),t5.getText());
        DriverFileOperations.updateCarInfo(arr[c.getSelectedIndex()],car);
        JOptionPane.showMessageDialog(new JFrame(), "Succesful");
        dispose();
        AdminFrame f = new AdminFrame();
        }
        else if(e.getActionCommand().equals("Back")){
        dispose();
        AdminFrame f1 = new AdminFrame();
        }
    }
    
}
