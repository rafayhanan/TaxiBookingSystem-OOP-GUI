
package careem.management.system;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class DriverTableModel extends AbstractTableModel {
    ArrayList<Driver> list;

    public DriverTableModel(ArrayList<Driver> list) {
        this.list = list;
    }
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Driver driver = list.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return driver.getName();
            case 1:
                return driver.getAccount().getUserName();
            case 2:
                return driver.getEmail();
            case 3:
                return driver.getGender();
            case 4:
                return Integer.toString(driver.getAge());
            case 5:
                return driver.getCar().getCarInfo();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Driver Name";
            case 1:
                return "Username";
            case 2:
                return "Email";
            case 3:
                return "Gender";
            case 4:
                return "Age";
            case 5:
                return "Car Information";
            default:
                return "";
        }
    }
    
}
