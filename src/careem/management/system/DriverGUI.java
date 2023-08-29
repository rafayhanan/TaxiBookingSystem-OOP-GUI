
package careem.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverGUI extends JFrame implements ActionListener{
    JLabel homepage;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField pass;
    JButton b1,b2,b3;
    JPanel p1,p2,p3;
    
    DriverGUI(){
    super.setSize(400,400);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new BorderLayout());
    //super.setBackground(Color.GREEN);
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    super.add(p3,BorderLayout.SOUTH);
    
    p1.setLayout(new FlowLayout());
    p2.setLayout(new GridLayout(2,2));
    p3.setLayout(new FlowLayout());
    
    p1.setBackground(Color.white);
    //p2.setBackground(Color.GREEN);
    //p3.setBackground(Color.GREEN);
    
    homepage = new JLabel("DRIVER INTERFACE");
    
    p1.add(homepage);
    
    l1 = new JLabel("USERNAME: ");
    l2 = new JLabel("PASSWORD: ");
    t1 = new JTextField();
    pass = new JPasswordField();
    
    p2.add(l1);p2.add(t1);
    p2.add(l2);p2.add(pass);

    b1 = new JButton("Create Account");
    b2 = new JButton("Log In");
    b3 = new JButton("Back");
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    p3.add(b1);p3.add(b2);p3.add(b3);
    super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Create Account")){
       dispose();
       SignUpDriver sud = new SignUpDriver();
       }
       else if(e.getActionCommand().equals("Log In")){
        ArrayList<Driver> list = new ArrayList();
        list = DriverFileOperations.readFromFile();
        
        int flag=0;
        for(Driver r: list){  
            if(r.getAccount().getUserName().equals(t1.getText())&&r.getAccount().getPassword().equals(pass.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "LOGGED IN");
                dispose();
                DriverFrame frame = new DriverFrame(r.getName(),r.getAccount().getUserName());
                flag++;
            }
        } 
        if(flag==0)
        JOptionPane.showMessageDialog(new JFrame(), "Wrong Username or Password");
        }
       else if(e.getActionCommand().equals("Back")){
       dispose();
       MainFrame fr = new MainFrame();
       }
    }
}
