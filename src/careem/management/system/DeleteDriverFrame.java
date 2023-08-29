
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DeleteDriverFrame extends JFrame implements ActionListener{
    JLabel l1,l2;
    JPanel p1,p2,p3,p4,p5;
    JComboBox c;
    JButton del,back;
    String arr[];
    DeleteDriverFrame(){
    super.setSize(500,500);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLocationRelativeTo(null);
    super.setLayout(new BorderLayout());
    
    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();
    p4 = new JPanel();
    p5 = new JPanel();
    
    super.add(p1,BorderLayout.NORTH);
    super.add(p2,BorderLayout.CENTER);
    super.add(p3,BorderLayout.SOUTH);
    
    l1 = new JLabel("Delete Driver");
    p1.setLayout(new FlowLayout());
    p1.add(l1);
    
    ArrayList<Driver> list = new ArrayList();
    list = DriverFileOperations.readFromFile();
    arr = new String[list.size()];

    for(int i=0;i<list.size();i++){
        arr[i]=list.get(i).getName();
    }
    c = new JComboBox(arr);
    
    l2 = new JLabel("Enter Driver Name: ");
  
    p2.setLayout(new GridLayout(1,2));
//    p2.add(p4);
//    p2.add(p5);

    p4.setLayout(new FlowLayout());
    p4.add(c);
    p5.setLayout(new FlowLayout());
    p5.add(l2);
    
    p2.add(p5);
    p2.add(p4);
    p3.setLayout(new FlowLayout());
    del = new JButton("Delete");
    back = new JButton("Back");
    p3.add(del);
    p3.add(back);
    
    del.addActionListener(this);
    back.addActionListener(this);
    super.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Delete")){
           int result = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure? ");
           if(result==JOptionPane.YES_OPTION){
           DriverFileOperations.deleteDriver(arr[c.getSelectedIndex()]);
           JOptionPane.showMessageDialog(new JFrame(), "Succesful");
           dispose();
           AdminFrame f = new AdminFrame();
           }
        }
        else if(e.getActionCommand().equals("Back")){
            dispose();
            AdminFrame f = new AdminFrame();
        }
    }
    
}
