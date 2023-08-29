
package careem.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ViewDriverFrame extends JFrame implements ActionListener{
    JLabel title;
    JScrollPane sp;
    JTable table;
    JPanel p1,p2;
    JButton back;
    ViewDriverFrame(){
        super.setSize(500,500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
        title = new JLabel("View All Drivers");
        String[] col = {"Driver Name","Username","Email","Gender","Age","Car Information"};
        ArrayList<Driver> list = new ArrayList<>();
        list = DriverFileOperations.readFromFile();

        table = new JTable(new DriverTableModel(list));
        sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        back = new JButton("Back");
        //table.setBounds(50, 50, 300, 300);
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
