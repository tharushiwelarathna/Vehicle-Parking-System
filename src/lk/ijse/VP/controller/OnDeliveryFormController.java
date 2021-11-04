package lk.ijse.VP.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.VP.dao.custom.impl.DeliveryDAOImpl;
import lk.ijse.VP.dao.custom.impl.ParkingDAOImpl;
import lk.ijse.VP.model.Delivery;
import lk.ijse.VP.model.Parking;
import lk.ijse.VP.view.tblmodel.DeliveryTM;

import java.util.ArrayList;
import java.util.List;

public class OnDeliveryFormController {

    public AnchorPane root;
    public TableView<DeliveryTM> tblDelivery;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleT;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;


    public void initialize ( ) throws Exception {


        colVehicleNo.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colVehicleT.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colDriverName.setCellValueFactory ( new PropertyValueFactory<> ( "driverName" ) );
        colLeftTime.setCellValueFactory ( new PropertyValueFactory<> ( "leftTime" ) );


        loadAllOnDeliveryVehicle();

        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();

        observableArrayList.add("On Delivery");

    }

    private void loadAllOnDeliveryVehicle() throws Exception {
        try {
        List<Delivery> all = null;

            all = DeliveryDAOImpl.getInstance ( ).getAll ( );
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList< DeliveryTM > deliveryTM1 = FXCollections.observableArrayList ( );

//            for (Delivery delivery:all) {
//                deliveryTM1.add ( new DeliveryTM ( delivery.getVehicleNumber(),delivery.getVehicleType(),delivery.getDriverName(),delivery.getLeftTime() ) );
//            }
//            tblDelivery.setItems ( deliveryTM1 );


    }



}
