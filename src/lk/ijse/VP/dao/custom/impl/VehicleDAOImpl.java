package lk.ijse.VP.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.VP.dao.CrudDAO;
import lk.ijse.VP.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class VehicleDAOImpl implements CrudDAO<Vehicle,String > {

    ArrayList<Vehicle> vehicleArrayList=new ArrayList<> ();

    private static VehicleDAOImpl vehicleDAOImpl;

    private VehicleDAOImpl(){
        loadAll();
    }

    public static VehicleDAOImpl getInstance(){
        if (vehicleDAOImpl==null){ vehicleDAOImpl = new VehicleDAOImpl( );
            return vehicleDAOImpl;
        }
        return vehicleDAOImpl;
    }
    @Override
    public boolean save(Vehicle vehicle) throws Exception{
        Vehicle vehicle1=search ( vehicle.getVehicleNumber ( ) );
        if ( vehicle1!=null ){
            new Alert( Alert.AlertType.ERROR,"Duplicate VehicleNumber!" ).show ();
        }else {
            boolean add = vehicleArrayList.add ( vehicle );
            return add;
        }
        return false;
    }

    @Override
    public boolean delete(String vehicleNumber)throws Exception {
        return false;
    }

    @Override
    public boolean update(Vehicle vehicle)throws Exception {
        return false;
    }

    @Override
    public ArrayList<Vehicle> getAll() throws Exception {
        return vehicleArrayList;
    }

    @Override
    public Vehicle search(String vehicleNumber) throws Exception {
        for ( int i = 0; i < vehicleArrayList.size (); i++ ) {
            Vehicle vehicle = vehicleArrayList.get ( i );
            if ( vehicle.getVehicleNumber ().equals ( vehicleNumber ) ){
                return vehicleArrayList.get ( i );
            }
        }
        return null;
    }



    @Override
    public List<Vehicle> loadAll(){
        vehicleArrayList.add ( new Vehicle ( "NA-3434", "Bus", "3500", 60 ) );
        vehicleArrayList.add ( new Vehicle ( "KA-4563", "Van", "1000", 7 ) );
        vehicleArrayList.add ( new Vehicle ( "58-3567", "Van", "1500", 4 ) );
        vehicleArrayList.add ( new Vehicle ( "GF-4358", "Van", "800", 4 ) );
        vehicleArrayList.add ( new Vehicle ( "CCB-3568", "Van", "1800", 8 ) );
        vehicleArrayList.add ( new Vehicle ( "LM-6679", "Van", "1500", 4 ) );
        vehicleArrayList.add ( new Vehicle ( "QA-3369", "Van", "1800", 6 ) );
        vehicleArrayList.add ( new Vehicle ( "KB-3668", "Cargo Lorry", "2500", 2 ) );
        vehicleArrayList.add ( new Vehicle ( "JJ-9878", "Cargo Lorry", "3000", 2 ) );
        vehicleArrayList.add ( new Vehicle ( "GH-5772", "Cargo Lorry", "4000", 3 ) );
        vehicleArrayList.add ( new Vehicle ( "XY-4456", "Cargo Lorry", "3500", 2 ) );
        vehicleArrayList.add ( new Vehicle ( "YQ-3536", "Cargo Lorry", "2000", 2 ) );
        vehicleArrayList.add ( new Vehicle ( "CBB-3566", "Cargo Lorry", "2500", 2 ) );
        vehicleArrayList.add ( new Vehicle ( "QH-3444", "Cargo Lorry", "5000", 4) );

        return vehicleArrayList;
    }
}
