
package careem.management.system;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RideHistoryTableModel extends AbstractTableModel {
    ArrayList<RideHistory> list;

    public RideHistoryTableModel(ArrayList<RideHistory> list) {
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
        RideHistory r = list.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return r.getRider();
            case 1:
                return r.getDriver();
            case 2:
                return r.getPickup();
            case 3:
                return r.getDropOff();
            case 4:
                return Double.toString(r.getFare());
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
                return "Driver Name";
            case 2:
                return "Pickup";
            case 3:
                return "Dropoff";
            case 4:
                return "Fare";
            default:
                return "";
        }
    }
    
}
