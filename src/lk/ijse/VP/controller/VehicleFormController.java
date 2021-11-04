package lk.ijse.VP.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.VP.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.VP.model.Vehicle;
import lk.ijse.VP.view.tblmodel.VehicleTM;

import java.util.List;

public class VehicleFormController {
    public AnchorPane root;
    public TableView<VehicleTM> tblVehicle;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colMaximumWeight;
    public TableColumn colNoOfPassengers;


    public void initialize ( ) {

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colMaximumWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));


        loadAllVehicles();


        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("Vehicle");

    }
    public void loadAllVehicles()  {
        tblVehicle.refresh ();
        try {
            List<Vehicle> vehicleArrayList = VehicleDAOImpl.getInstance ().getAll ( );

            ObservableList< VehicleTM > vehicleTMS = FXCollections.observableArrayList ( );

            for ( Vehicle vehicle : vehicleArrayList ) {
                vehicleTMS.add ( new VehicleTM ( vehicle.getVehicleNumber( ) , vehicle.getWeight ( ) , vehicle.getVehicleType() , vehicle.getNoOfPassengers() ) );
            }
            tblVehicle.setItems ( vehicleTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }
    }
