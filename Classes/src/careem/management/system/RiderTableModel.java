
package careem.management.system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RiderTableModel extends AbstractTableModel {
    ArrayList<Rider> list;

    public RiderTableModel(ArrayList<Rider> list) {
        this.list = list;
    }
    
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rider rider = list.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return rider.getName();
            case 1:
                return rider.getAccount().getUserName();
            case 2:
                return rider.getEmail();
            case 3:
                return rider.getGender();
            case 4:
                return Integer.toString(rider.getAge());
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Rider Name";
            case 1:
                return "Username";
            case 2:
                return "Email";
            case 3:
                return "Gender";
            case 4:
                return "Age";
            default:
                return "";
        }
    }
    
}
