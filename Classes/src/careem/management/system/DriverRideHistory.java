
package careem.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverRideHistory extends JFrame implements ActionListener {
    JLabel title;
    JScrollPane sp;
    JTextArea area;
    JPanel p1,p2;
    JButton back;
    JLabel temp1,temp2;
    
    DriverRideHistory(String name){
        super.setSize(500,500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        title = new JLabel("View All Rides");
        area = new JTextArea();
        sp = new JScrollPane(area);
        temp1 = new JLabel();
        temp2 = new JLabel();
        ArrayList<RideHistory> list = new ArrayList<>();
        list = RideHistoryFileOperations.readFromFile();
        
        for(RideHistory r : list){
            if(r.getDriver().equals(name)){
                String str = "\nDriver Name: "+r.getDriver()+"\nCar: "+r.getCar().getCarInfo()+"\nRider Name: "+r.getRider()+"\nPickup: "+r.getPickup()+"\t\tDropoff: "+r.getDropOff()+"\nFare: "+r.getFare()+"\n\n";
                area.append(str);
            }
        }
        
        ArrayList<Driver> driverlist = new ArrayList();
        driverlist = DriverFileOperations.readFromFile();
        
        for(Driver d: driverlist){
            if(d.getName().equals(name)){
                temp1.setText(name);
                temp2.setText(d.getAccount().getUserName());
            }
        
        }
        
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        back = new JButton("Back");
        //table.setBounds(30, 40, 200, 300);
        super.add(p1,BorderLayout.NORTH);
        super.add(sp,BorderLayout.CENTER);
        super.add(p2,BorderLayout.SOUTH);
        p1.add(title);
        p2.add(back);
        back.addActionListener(this);
        
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back")){
        dispose();
        DriverFrame f = new DriverFrame(temp1.getText(),temp2.getText());
        }
    }
}
