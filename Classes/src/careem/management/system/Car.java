
package careem.management.system;

import java.io.Serializable;


public class Car implements Serializable {
    private String PlateNo;
    private String companyName;
    private String modelName;
    private String color;

    public Car(String PlateNo, String companyName, String modelName, String color) {
        this.PlateNo = PlateNo;
        this.companyName = companyName;
        this.modelName = modelName;
        this.color = color;
    }

    public String getPlateNo() {
        return PlateNo;
    }

    public void setPlateNo(String PlateNo) {
        this.PlateNo = PlateNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarInfo(){
        return color+" "+companyName+" "+modelName+" "+PlateNo;
    }
    
    @Override
    public String toString() {
        return "\nCar{" + "PlateNo=" + PlateNo + ", companyName=" + companyName + ", modelName=" + modelName + ", color=" + color + '}';
    }
    
    
}
