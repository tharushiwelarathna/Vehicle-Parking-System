package lk.ijse.VP.model;

public class Parking {
      private String vehicleNumber;
      private String vehicleType;
      private String ParkingSlot;
      private String parkedTime;

    public Parking ( ) {
    }

    public Parking ( String vehicleNumber , String vehicleType , String parkingSlot , String parkedTime ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        ParkingSlot = parkingSlot;
        this.parkedTime = parkedTime;
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

    public String getParkingSlot() {
        return ParkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        ParkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    @Override
    public String toString ( ) {
        return "Parking{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", ParkingSlot='" + ParkingSlot + '\'' +
                ", parkedTime='" + parkedTime + '\'' +
                '}';
    }
}
