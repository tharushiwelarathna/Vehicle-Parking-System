package lk.ijse.VP.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.VP.dao.custom.impl.ParkingDAOImpl;
import lk.ijse.VP.model.Parking;
import lk.ijse.VP.view.tblmodel.ParkingTM;

import java.io.IOException;
import java.util.List;


public class ManagementDashBoardFormController {
    public AnchorPane root;
    public AnchorPane root1;
    public TableView<ParkingTM> tblParking1;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colparkingSlot;
    public TableColumn colParkedTime;


    public void initialize ( )  {


        colVehicleNumber.setCellValueFactory ( new PropertyValueFactory<>( "vehicleNumber" ) );
        colVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colparkingSlot.setCellValueFactory ( new PropertyValueFactory<> ( "ParkingSlot" ) );
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
            tblParking1.setItems ( parkingTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }




    private void InitUI(String Location) {
        try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + Location)));
        }catch (IOException ex){
            System.out.println(ex);


        }
    }

    public void openInParkingOnAction(ActionEvent actionEvent) {
        InitUI("InParkingForm.fxml");
    }

    public void openOnDeliveryOnAction(ActionEvent actionEvent) {

        InitUI("OnDeliveryForm.fxml");


    }

    public void openAddVehicleOnAction(ActionEvent actionEvent) {
        InitUI("AddVehicleForm.fxml");
    }


    public void openAddDriverOnAction(ActionEvent actionEvent) {
        InitUI("AddDriverForm.fxml");
    }


    public void openVehicleOnAction(ActionEvent actionEvent) {
        InitUI("VehicleForm.fxml");
    }

    public void openDriverOnAction(ActionEvent actionEvent) {
        InitUI("DriverForm.fxml");
    }
}
