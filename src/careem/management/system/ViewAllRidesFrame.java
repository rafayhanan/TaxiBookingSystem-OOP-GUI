
package careem.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ViewAllRidesFrame extends JFrame implements ActionListener {
    JLabel title;
    JScrollPane sp;
    JTable table;
    JPanel p1,p2;
    JButton back;
    ViewAllRidesFrame(){
        super.setSize(500,500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        title = new JLabel("View All Rides");
        //String[] col = {"Rider Name","Username","Email","Gender","Age"};
        ArrayList<RideHistory> list = new ArrayList<>();
        list = RideHistoryFileOperations.readFromFile();

        table = new JTable(new RideHistoryTableModel(list));
        sp = new JScrollPane(table);
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
        AdminFrame f = new AdminFrame();
        }
    }
    
}
