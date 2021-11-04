package lk.ijse.VP.view.tblmodel;

public class VehicleTM {

    private String vehicleNumber;
    private String vehicleType;
    private String weight;
    private int noOfPassengers;

    public VehicleTM() {
    }

    public VehicleTM ( String vehicleNumber  , String vehicleType , String weight, int noOfPassengers ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.weight = weight;
        this.noOfPassengers = noOfPassengers;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString ( ) {
        return "VehicleTM{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", weight='" + weight + '\'' +
                ", noOfPassengers=" + noOfPassengers +
                '}';
    }
}