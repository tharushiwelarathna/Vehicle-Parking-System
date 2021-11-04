package lk.ijse.VP.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.VP.dao.custom.impl.DeliveryDAOImpl;
import lk.ijse.VP.dao.custom.impl.DriverDAOImpl;
import lk.ijse.VP.dao.custom.impl.ParkingDAOImpl;
import lk.ijse.VP.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.VP.model.Delivery;
import lk.ijse.VP.model.Parking;
import lk.ijse.VP.model.Vehicle;
import lk.ijse.VP.model.Driver;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class DashBoardFormController {
    public AnchorPane root1;
    public ComboBox cmbVehicleNumber;
    public ComboBox cmbDriverName;
    public TextField txtVehicleType;
    public Button btnOnDiliveryShift;
    public Button btnParkVehicle;
    public Label lblSlotNumber;
    public Label lblDate;
    public Label lblTime;

    public void initialize()  {
        generateDateTime ();
        getAllVehicle();
        getAllDrives();
    }

    private void getAllDrives() {
        try {
            List<Driver> all = DriverDAOImpl.getInstance ( ).getAll ( );
            System.out.println (all );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for (Driver driver : all) {
                observableList.add ( driver.getdName() );
            }

            cmbDriverName.setItems ( observableList );
        } catch (Exception e) {
            e.printStackTrace ( );
        }

    }

    private void getAllVehicle() {
        cmbDriverName.setItems (null);
        try {
            List< Vehicle > all = VehicleDAOImpl.getInstance ().getAll ( );

            ObservableList<String> observableList = FXCollections.observableArrayList ( );

            for (Vehicle vehicle:all ) {
                observableList.add ( vehicle.getVehicleNumber () ) ;
            }
            cmbVehicleNumber.setItems (observableList);
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    private void generateDateTime() {
        lblDate.setText( LocalDate.now().toString());

        Timeline timeline = new Timeline( new KeyFrame( Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "hh:mm:ss a");
            lblTime.setText( LocalDateTime.now().format( formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount( Animation.INDEFINITE);
        timeline.play();

    }

    public void cmbVehicleNumberOnAction(ActionEvent actionEvent) {
        try {
            List< Vehicle > all = VehicleDAOImpl.getInstance ( ).getAll ( );

            for ( Vehicle vehicle : all ) {
                try {
                    if ( cmbVehicleNumber.getValue ( ).equals ( vehicle.getVehicleNumber ( ) ) ) {
                        txtVehicleType.setText ( vehicle.getVehicleType ( ) );

                        switch (txtVehicleType.getText ( )) {
                            case "Bus":
                                lblSlotNumber.setText ( "14" );
                                break;
                            case "Van":
                                String s = ParkingDAOImpl.getInstance ( ).vanSlot ( );
                                lblSlotNumber.setText ( s );
                                break;
                            case "Cargo Lorry":
                                String s1=ParkingDAOImpl.getInstance ( ).cargoSlot ( );
                                lblSlotNumber.setText ( s1 );
                                break;
                        }
                    }
                    Parking parking = ParkingDAOImpl.getInstance ( ).search ( (String) cmbVehicleNumber.getValue ( ) );
                    if ( parking != null ) {
                        btnParkVehicle.setDisable ( true );
                    }
                    else {
                        btnParkVehicle.setDisable ( false );
                    }
                    Delivery delivery = DeliveryDAOImpl.getInstance ( ).search( (String) cmbVehicleNumber.getValue ( ) );
                    btnOnDiliveryShift.setDisable ( delivery != null );
                } catch ( NullPointerException ignored ) {

                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void cmdSelectDriverOnAction(ActionEvent actionEvent) {
        try {
            List< Parking > all = ParkingDAOImpl.getInstance ( ).getAll ( );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for ( Parking parking : all) {
                observableList.add ( parking.getVehicleType () );
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }

    }


    public static class ExampleDate {
        public static void main(String[] args) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            System.out.println(formatter.format(date));
        }
    }


    public void openManagementLogInOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");

//        Scene scene = null;
//        try {
//            scene = new Scene ( FXMLLoader.load( getClass().getResource( "../view/LoginForm.fxml")));
//        } catch (IOException e) {
//            e.printStackTrace ( );
//        }
//        Stage primaryStage = new Stage();
//        primaryStage.setScene(scene);
//        primaryStage.show ();
    }

    void setUi(String location) throws IOException {
        Scene scene =
                new Scene(FXMLLoader.load(getClass()
                        .getResource("../view/"+location+".fxml")));
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addParkVehicleOnAction(ActionEvent actionEvent) {
        try {
            SimpleDateFormat formatter=new SimpleDateFormat ( "dd/MM/yyyy HH:mm" );
            Date date=new Date ( );

            DeliveryDAOImpl deliveryDAOImpl=DeliveryDAOImpl.getInstance ( );
            Delivery delivery=deliveryDAOImpl.search ( (String) cmbVehicleNumber.getValue ( ) );
            if ( delivery != null ) {
                deliveryDAOImpl.delete ( delivery.getVehicleNumber ( ) );
            }
            else {
                if ( ( cmbVehicleNumber.getValue () )!=null ){
                    Parking parking=new Parking(
                            (String) cmbVehicleNumber.getValue ( ) ,
                            txtVehicleType.getText ( ) ,
                            lblSlotNumber.getText ( ) ,
                            formatter.format ( date )
                    );


                    if ( ParkingDAOImpl.getInstance ( ).save ( parking ) ) {
                        Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Vehicle is Park" );
                        alert.show ( );
                        clearText ( );
                    }
                }else {
                  //  cmbVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
                    cmbVehicleNumber.requestFocus ();
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void addOnDiliveryShiftOnAction(ActionEvent actionEvent) {
        try {
            boolean delete = ParkingDAOImpl.getInstance ( ).delete ((String) cmbVehicleNumber.getValue () );
            if ( delete ){
                SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm");
                Date date = new Date();

                if ( cmbVehicleNumber.getValue ( ) != null ) {
                    if ( cmbDriverName.getValue ( ) != null ) {
                        Delivery delivery = new Delivery (
                                (String) cmbVehicleNumber.getValue ( ) ,
                                txtVehicleType.getText ( ) ,
                                (String) cmbDriverName.getValue ( ) ,
                                formatter.format ( date )
                        );
                        try {
                            if ( DeliveryDAOImpl.getInstance ( ).save ( delivery ) ) {
                                Alert alert = new Alert ( Alert.AlertType.INFORMATION , "Its Deliver" );
                                alert.show ( );
                            }
                        } catch ( Exception e ) {
                            e.printStackTrace ( );
                        }
                    }
                    else {
                       // cmbDriverName.setFocusColor ( Paint.valueOf ( "red" ) );
                        cmbDriverName.requestFocus ( );
                    }
                }
                else {
                    //cmbVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
                    cmbVehicleNumber.requestFocus ( );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
        clearText();
    }

    public void btnRefreshOnAction ( ActionEvent actionEvent ) {
        initialize ();
        clearText ();
        lblSlotNumber.setText ( null );
    }

    private void clearText(){
        cmbVehicleNumber.setValue ( null );
        txtVehicleType.setText ( "" );
        cmbDriverName.setValue ( null );
        btnOnDiliveryShift.setDisable ( false );
        btnParkVehicle.setDisable ( false );
    }
}
