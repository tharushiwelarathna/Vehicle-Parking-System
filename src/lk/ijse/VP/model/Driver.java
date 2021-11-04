package lk.ijse.VP.model;

public class Driver {
     private String dName;
     private String nic;
     private String dLicenseNo;
     private String dAddress;
     private String contact;

    public Driver ( ) {
    }

    public Driver ( String dName , String nic , String dLicenseNo , String dAddress , String contact ) {
        this.dName = dName;
        this.nic = nic;
        this.dLicenseNo = dLicenseNo;
        this.dAddress = dAddress;
        this.contact = contact;
    }


    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getdLicenseNo() {
        return dLicenseNo;
    }

    public void setdLicenseNo(String dLicenseNo) {
        this.dLicenseNo = dLicenseNo;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString ( ) {
        return "Driver{" +
                "dName='" + dName + '\'' +
                ", nic='" + nic + '\'' +
                ", dLicenseNo='" + dLicenseNo + '\'' +
                ", dAddress='" + dAddress + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

}
