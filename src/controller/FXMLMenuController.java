/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.sispasajes;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IRINEO
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Circle avatar;
    @FXML
    private Label lblusuario;
    @FXML
    private JFXButton btncliente;
    @FXML
    private JFXButton btnsalida;
    @FXML
    private JFXButton btnpasaje;
    @FXML
    private JFXButton btnperfil;
    @FXML
    private JFXButton btnlogout;
    
       @FXML
    void salir(ActionEvent event) {
        try{
            Stage window=(Stage) btnlogout.getScene().getWindow();
            sispasajes sistema=new sispasajes();
            sistema.start(new Stage());
            window.close();
        }catch (Exception ex){
            mutil.mensaje(ex.getMessage(), "ERROR");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImagen();
        
    }   
    public void mostrarImagen(){
        avatar.setStroke(Color.AQUAMARINE);
        avatar.setFill(new ImagePattern(msesion.user.getFoto()));
        
        avatar.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSLATEBLUE));
        lblusuario.setText(msesion.user.getNombre());
        
        
    }
    
}
