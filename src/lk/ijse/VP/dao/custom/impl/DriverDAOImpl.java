package lk.ijse.VP.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.VP.dao.CrudDAO;
import lk.ijse.VP.model.Driver;


import java.util.ArrayList;
import java.util.List;

public class DriverDAOImpl implements CrudDAO<Driver,String > {
    ArrayList<Driver> driverArrayList=new ArrayList<> ();

    private static DriverDAOImpl driverDAOImpl;

    private DriverDAOImpl (){
        loadAll ();
    }

    public static DriverDAOImpl getInstance(){
        if ( driverDAOImpl==null ){
            driverDAOImpl = new DriverDAOImpl ();
            return driverDAOImpl;
        }
        return driverDAOImpl;
    }
    @Override
    public boolean save(Driver driver)throws Exception {
        Driver driver1=search ( driver.getNic ( ) );
        if ( driver1!=null ){
            new Alert( Alert.AlertType.WARNING,"Duplicate NIC" ).show ();
        }else {
            boolean add = driverArrayList.add ( driver );
            return add;
        }
        return false;
    }

    @Override
    public boolean delete(String vehicleNumber)throws Exception {
        return false;
    }

    @Override
    public boolean update(Driver driver)throws Exception {
        return false;
    }

    @Override
    public ArrayList<Driver> getAll()throws Exception {
        return driverArrayList;
    }

    @Override
    public Driver search(String nic) throws Exception {
        for ( int i = 0; i < driverArrayList.size (); i++ ) {
            Driver driver = driverArrayList.get ( i );
            if ( driver.getNic ().equals ( nic ) ){
                return driverArrayList.get ( i );
            }
        }
        return null;
    }



    @Override
    public List<Driver> loadAll() {

        driverArrayList.add ( new Driver ( "Sumith Kumara" , "7835348345V" , "B6474845" , "Panadura" , "0725637456" ) );
        driverArrayList.add ( new Driver ( "Amila Pathirana" , "8826253734V" , "B3354674" , "Galle" , "0717573583" ) );
        driverArrayList.add ( new Driver ( "Jithmal Perera" , "9425245373V" , "B3674589" , "Horana" , "0772452457" ) );
        driverArrayList.add ( new Driver ( "Sumith Dissanayaka" , "7835348345V" , "B8366399" , "Kaluthara" , "0782686390" ) );
        driverArrayList.add ( new Driver ( "Sumanasiri Herath" , "9283289272V" , "B6474845" , "Beruwala" , "0772534436" ) );
        driverArrayList.add ( new Driver ( "Awantha Fernando " , "7835348345V" , "B3554789" , "Colombo 5" , "0714534356" ) );
        driverArrayList.add ( new Driver ( "Charith Sudara" , "9573536833V" , "B6474845" , "Baththaramulla" , "0771536662" ) );
        driverArrayList.add ( new Driver ( "Prashan Dineth " , "7835348345V" , "B2683536" , "Wadduwa" , "0715353434" ) );
        driverArrayList.add ( new Driver ( "Chethiya Dilan" , "7835348345V" , "B6474845" , "Panadura" , "0772436737" ) );
        driverArrayList.add ( new Driver ( "Dushantha Perera" , "9255556343V" , "B2683536" , "Matara" , "0777245343" ) );
        driverArrayList.add ( new Driver ( "Sumith Udayanga" , "7835348345V" , "B5343783" , "Galle" , "0703635442" ) );
        driverArrayList.add ( new Driver ( "Dinesh Udara " , "7835348345V" , "B6474845" , "Hettimulla" , "0713456878" ) );
        driverArrayList.add ( new Driver ( "Udana Chathuranga " , "9026344373V" , "B6474845" , "Kottawa" , "0772442444" ) );
        driverArrayList.add ( new Driver ( "Mohommad Riaz " , "7835348345V" , "B6474845" , "Kaluthara" , "0777544222" ) );
        driverArrayList.add ( new Driver ( "Sandun Kumara" , "9124537733V" , "B6474845" , "Panadura" , "0777544222" ) );
        driverArrayList.add ( new Driver ( "Priyanga Perera " , "9135343537V" , "B2263333" , "Matara" , "0723344562" ) );

        return driverArrayList;
    }
}
