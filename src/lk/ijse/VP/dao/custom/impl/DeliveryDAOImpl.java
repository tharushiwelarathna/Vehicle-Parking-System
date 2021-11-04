package lk.ijse.VP.dao.custom.impl;

import lk.ijse.VP.dao.CrudDAO;
import lk.ijse.VP.model.Delivery;


import java.util.ArrayList;
import java.util.List;

public class DeliveryDAOImpl implements CrudDAO<Delivery,String > {
    ArrayList< Delivery > deliveryArrayList=new ArrayList<> ();

    private static DeliveryDAOImpl deliveryDAOImpl;

    private DeliveryDAOImpl(){

    }

    public static DeliveryDAOImpl getInstance(){
        if ( deliveryDAOImpl== null){
            deliveryDAOImpl=new DeliveryDAOImpl ();
            return deliveryDAOImpl;
        }
        return deliveryDAOImpl;
    }




    @Override
    public boolean save(Delivery delivery) throws Exception {
        boolean add = deliveryArrayList.add ( delivery );
        return add;
    }

    @Override
    public boolean delete(String vehicleNumber) throws Exception {
        Delivery delivery = search ( vehicleNumber );
        if ( delivery!=null ){
            deliveryArrayList.remove ( delivery );
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Delivery delivery) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Delivery> getAll() throws Exception {
        return null;
    }

    @Override
    public Delivery search(String vehicleNumber) throws Exception {
        for ( int i = 0; i < deliveryArrayList.size (); i++ ) {
            Delivery delivery = deliveryArrayList.get ( i );
            if ( delivery.getVehicleNumber ( ).equals ( vehicleNumber ) ){
                return deliveryArrayList.get ( i );
            }
        }
        return null;
    }

    @Override
    public List<Delivery> loadAll()  {
        return null;
    }
}
