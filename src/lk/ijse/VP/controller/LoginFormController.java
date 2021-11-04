package lk.ijse.VP.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginFormController {
    public AnchorPane root1;
    public Button btnLogin;
    public Button btnCancel;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    public void openLogInOnAction(ActionEvent actionEvent) throws IOException {
       // setUi("ManagementDashBoardForm");

        if ( Pattern.compile( "^[a-z]{4}$").matcher( txtUserName.getText()).matches()) {
            if (Pattern.compile("^[0-9]{4}$").matcher(txtPassword.getText()).matches()) {
                String name = txtUserName.getText().trim();
                String password = txtPassword.getText().trim();
                if (name.length()>0 && password.length()>0){

                    if (name.equalsIgnoreCase("user")
                            && password.equalsIgnoreCase("1234")){
                        Stage stage = (Stage) btnCancel.getScene().getWindow();
                        stage.close();

                        Scene scene = new Scene ( FXMLLoader.load( getClass().getResource( "../view/ManagementDashBoardForm.fxml")));
                        Stage primaryStage = new Stage();
                        primaryStage.setScene(scene);
                        primaryStage.show ();

                    }else{
                        new Alert( Alert.AlertType.WARNING, "Try Again !!!!",
                                ButtonType.OK, ButtonType.NO).show();
                    }
                }else{
                    new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                            ButtonType.OK,ButtonType.NO).show();
                }
            }else{
                txtPassword.setFocusColor( Paint.valueOf( "red"));
                txtPassword.requestFocus();
            }
        }else{
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();

        }
    }
    void setUi(String location) throws IOException {
        Scene scene =
                new Scene(FXMLLoader.load(getClass()
                        .getResource("../view/"+location+".fxml")));
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
