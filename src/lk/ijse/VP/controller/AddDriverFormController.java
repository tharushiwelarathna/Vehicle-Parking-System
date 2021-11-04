package lk.ijse.VP.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.VP.dao.custom.impl.DriverDAOImpl;
import lk.ijse.VP.model.Driver;

import java.util.regex.Pattern;


public class AddDriverFormController {


    public Button btnAddDriver;

    public AnchorPane root;
    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtDriverLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;

    public void addDriverOnAction(ActionEvent actionEvent) {
        if ( Pattern.compile ( "^[A-z]{1,}[ ][A-z]{1,}$" ).matcher ( txtDriverName.getText ( ) ).matches ( ) ) {
            if ( Pattern.compile ( "^[0-9]{11,12}$" ).matcher ( txtNIC.getText ( ) ).matches ( ) ) {
                if ( Pattern.compile ( "^[0-9]{11,12}$" ).matcher ( txtDriverLicenseNo.getText ( ) ).matches ( ) ) {
                    if ( Pattern.compile("^[A-z]{1,}[ ][A-z]{1,}$").matcher(txtAddress.getText()).matches() ) {
                        if ( Pattern.compile("^[0-9]{9,10}$").matcher(txtContact.getText()).matches() ) {
                            Driver drivers=new Driver (
                                    txtDriverName.getText ( ) ,
                                    txtNIC.getText ( ) ,
                                    txtDriverLicenseNo.getText ( ) ,
                                    txtAddress.getText ( ) ,
                                    txtContact.getText ( )
                            );
                            try {
                                if ( DriverDAOImpl.getInstance ( ).save ( drivers ) ) {
                                    Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Driver is Saved" );
                                    alert.show ( );
                                }
                            } catch ( Exception e ) {
                                e.printStackTrace ( );
                            }
                        }else {
                            txtContact.setFocusColor ( Paint.valueOf ( "red" ) );
                            txtContact.requestFocus ( );
                        }
                    }else {
                        txtAddress.setFocusColor ( Paint.valueOf ( "red" ) );
                        txtAddress.requestFocus ( );
                    }
                }
                else {
                    txtDriverLicenseNo.setFocusColor ( Paint.valueOf ( "red" ) );
                    txtDriverLicenseNo.requestFocus ( );
                }
            }else {
                txtNIC.setFocusColor ( Paint.valueOf ( "red" ) );
                txtNIC.requestFocus ( );
            }
        }else {
            txtDriverName.setFocusColor ( Paint.valueOf ( "red" ) );
            txtDriverName.requestFocus ( );
        }

    }


}
