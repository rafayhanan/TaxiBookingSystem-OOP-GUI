
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignUpRider extends JFrame implements ActionListener{
    JLabel title;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JComboBox c1,c2,c3,gender;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JTextField[] JTFarr = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    String[] arr = {"Male","Female"};
    String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String[] year = {"1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007"};
    SignUpRider(){
        super.setSize(600, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        p1 =new JPanel();
        p2= new JPanel();
        p3 =new JPanel();
        p4 = new JPanel();
        
        super.add(p1,BorderLayout.NORTH);
        super.add(p2,BorderLayout.CENTER);
        super.add(p4,BorderLayout.SOUTH);
        
        gender = new JComboBox(arr);
        gender.setSelectedIndex(0);
        gender.setMaximumRowCount(3);
        
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(9,2));
        //p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        
        title = new JLabel("Create Account for Rider");
        p1.add(title);
        
        c1 = new JComboBox(days);
        
        
        c2 = new JComboBox(month);
        c1.setMaximumRowCount(2);
        
        c3 = new JComboBox(year);
        c3.setSelectedIndex(15);
        
        c3.setMaximumRowCount(9);
        
        p3.add(c1);
        p3.add(c2);
        p3.add(c3);
        
        
        l1 = new JLabel("Name:");
        l2 = new JLabel("Email:");
        
        l4 = new JLabel("Phone Number:");
        l5 = new JLabel("Gender:");
        l6 = new JLabel("Birth Date:");
        l7 = new JLabel("Enter Username:");
        l8 = new JLabel("Enter Password:");
        //l9 = new JLabel("City:");
        l10 = new JLabel("Home:");
        l11 = new JLabel("Street:");
        
        
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        
        
        
        p2.add(l1);p2.add(t1);
        p2.add(l2);p2.add(t2);
//        p2.add(l3);p2.add(t3);
        p2.add(l4);p2.add(t4);
        p2.add(l5);p2.add(gender);
        p2.add(l6);p2.add(p3);
        p2.add(l7);p2.add(t10);
        p2.add(l8);p2.add(t6);
//        p2.add(l9);p2.add(t7);
        p2.add(l10);p2.add(t8);
        p2.add(l11);p2.add(t9);
        
        
        b1 = new JButton("Submit");
        b2 = new JButton("Back");
        
        p4.add(b1);
        p4.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       super.setVisible(true);
        
    }
    
    public boolean textFieldisEmpty(){
        for(JTextField t : JTFarr){
            if(t.getText().isBlank()){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Submit")){
          
            Date d = new Date(c1.getSelectedIndex()+1,c2.getSelectedIndex()+1,Integer.parseInt(year[c3.getSelectedIndex()]));
            Address a = new Address(t8.getText(),Integer.parseInt(t9.getText()));
            Account account = new Account(t10.getText(),t6.getText(),0.0);
            Rider r = new Rider(account,t1.getText(),t2.getText(),d.getAge(),arr[gender.getSelectedIndex()],t4.getText(),a,d);
            RiderFileOperations.writeToFile(r);
            JOptionPane.showMessageDialog(new JFrame(),"Account Succesfully created!");
            dispose();
            RiderGUI rg = new RiderGUI();
            
        }
        else if(e.getActionCommand().equals("Back")){
        dispose();
        RiderGUI r = new RiderGUI();
        
        }
    }
    
}
