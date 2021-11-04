package lk.ijse.VP.controller;


import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.VP.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.VP.model.Vehicle;

import java.util.regex.Pattern;


public class AddVehicleFormController {
    public AnchorPane root;

    public ComboBox cmbVehicleType;
    public Button btnAddVehicle;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtWeight;
    public JFXTextField txtNoOfPassengers;


    public void initialize(){
        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("Van");
        observableArrayList.add("Buss");
        observableArrayList.add("Lorry");
        cmbVehicleType.setItems(observableArrayList);


    }

    private void loadAllVehicles() {

    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
//        Vehicle vehicle = new Vehicle(
//                txtVehicleNumber.getText ( ) ,
//                (String) cmbVehicleType.getValue ( ),
//                txtWeight.getText ( ) ,
//                Integer.parseInt ( txtNoOfPassengers.getText ( ) )
//        );
//
//        try {
//            if ( VehicleDAOImpl.getInstance ().save ( vehicle ) ){
//                Alert alert = new Alert( Alert.AlertType.INFORMATION, "Vehicle is Saved");
//                Stage stage = (Stage) btnAddVehicle.getScene().getWindow();
//                stage.close();
//                alert.show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace ( );
//        }

        if ( Pattern.compile ( "^[A-Z]{2}(-)[0-9]{4}$" ).matcher ( txtVehicleNumber.getText () ).matches () ){
            if ( Pattern.compile("^[0-9]{4}$").matcher(txtWeight.getText()).matches() ) {
                if ( Pattern.compile ( "^[0-9]{1,2}$" ).matcher ( txtNoOfPassengers.getText ( ) ).matches ( ) ){
                    Vehicle vehicle=new Vehicle (
                            txtVehicleNumber.getText ( ) ,
                            (String) cmbVehicleType.getValue ( ) ,
                            txtWeight.getText ( ) ,
                            Integer.parseInt ( txtNoOfPassengers.getText ( ) )
                    );
                    try {
                        if ( VehicleDAOImpl.getInstance ( ).save ( vehicle ) ) {
                            Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Vehicle is Saved" );
                            Stage stage=(Stage) btnAddVehicle.getScene ( ).getWindow ( );
                            stage.close ( );
                            alert.show ( );
                        }
                    } catch ( Exception e ) {
                        e.printStackTrace ( );
                    }

                }else {
                    txtNoOfPassengers.setFocusColor ( Paint.valueOf ( "red" ) );
                    txtNoOfPassengers.requestFocus ();
                }

            }else {
                txtWeight.setFocusColor ( Paint.valueOf ( "red" ) );
                txtWeight.requestFocus ();
            }
        }else {
            txtVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
            txtVehicleNumber.requestFocus ();
        }

    }

}
