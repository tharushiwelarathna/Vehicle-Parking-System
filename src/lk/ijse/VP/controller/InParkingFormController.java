package lk.ijse.VP.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.VP.dao.custom.impl.ParkingDAOImpl;
import lk.ijse.VP.model.Parking;
import lk.ijse.VP.view.tblmodel.ParkingTM;

import java.util.List;

public class InParkingFormController {
    public AnchorPane root;
    public TableView<ParkingTM> tblParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public void initialize ( )  {


        colVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colParkingSlot.setCellValueFactory ( new PropertyValueFactory<> ( "ParkingSlot" ) );
        colParkedTime.setCellValueFactory ( new PropertyValueFactory<> ( "parkedTime" ) );



        loadAllInParkingVehicle();


        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("In Parking");

    }

    public void loadAllInParkingVehicle(){
        try {
            List<Parking> all = ParkingDAOImpl.getInstance ( ).getAll ( );

            ObservableList< ParkingTM > parkingTMS = FXCollections.observableArrayList ( );

            for (Parking parking:all) {
                parkingTMS.add ( new ParkingTM ( parking.getVehicleNumber (),parking.getVehicleType (),parking.getParkingSlot (),parking.getParkedTime() ) );
            }
            tblParking.setItems ( parkingTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }
}
