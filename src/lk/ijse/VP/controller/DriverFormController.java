package lk.ijse.VP.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.VP.dao.custom.impl.DriverDAOImpl;
import lk.ijse.VP.model.Driver;

import lk.ijse.VP.view.tblmodel.DriverTM;

import java.util.List;


public class DriverFormController {
    public AnchorPane root;
    public TableView<DriverTM> tblDriver;
    public TableColumn colDriverName;
    public TableColumn colNIC;
    public TableColumn colDrivingLicenseNo;
    public TableColumn colAddress;
    public TableColumn colContactNo;

    public void initialize ( ) throws Exception {


        colDriverName.setCellValueFactory(new PropertyValueFactory<>("dName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDrivingLicenseNo.setCellValueFactory(new PropertyValueFactory<>("dLicenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("dAddress"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadAllDrivers ();

        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("Driver");



    }
    public void loadAllDrivers() throws Exception {

        try {
        List<Driver> driverArrayList = DriverDAOImpl.getInstance ().getAll ( );

        ObservableList<DriverTM> driverTM1 = FXCollections.observableArrayList ( );

        for ( Driver driver : driverArrayList ) {
            driverTM1.add ( new DriverTM ( driver.getdName(),driver.getNic(),driver.getdLicenseNo(),driver.getdAddress(),driver.getContact()));
        }
        tblDriver.setItems ( driverTM1 );
    } catch (Exception e) {
        e.printStackTrace ( );
    }
    }

}
