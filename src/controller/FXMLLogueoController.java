/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.musuario;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author IRINEO
 */
public class FXMLLogueoController implements Initializable {
    @FXML
    private JFXPasswordField txtclave;
    @FXML
    private JFXTextField txtdni;
    @FXML
    private JFXButton btningresar;
    @FXML
    private ImageView imgcargar;
    
    private boolean estado=false;
    @FXML
    private void ingresar(ActionEvent event) {
        if(txtdni.getText().length()==8 && txtclave.getText().length()>0){
            musuario usuario=new musuario();
            usuario.setDni(txtdni.getText());
            usuario.setClave(txtclave.getText());
            System.out.println(usuario.getClave());
            Service<String> service=new Service<String>(){
              @Override
              protected Task<String> createTask(){
                  return new Task<String>(){
                      @Override
                      protected String call() throws Exception{
                          estado=usuario.validarusuario();
                          return null;
                      }
                      @Override protected void succeeded(){
                          if(estado!=true){
                              imgcargar.setVisible(false);
                              mutil.mensaje("Los datos de inicio se sesion "+ "\n porporcionados son incorrectos","EXITO");
                              
                          }else{
                              msesion.user=usuario;
                              completeLogin();
                          }
                      }
                  };
              }
            };
            service.start();
        }else{
            mutil.mensaje("Faltan de datos", "ERROR");
        }
        
    }
    private void completeLogin() {
        
    try {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/view/fxml/FXMLPrincipal.fxml"));
        Loader.load();
        Parent root = Loader.getRoot();
    Stage stage = new Stage();
    JFXDecorator decorator = new JFXDecorator(stage, root, true, true, true);
    Scene scene = new Scene(decorator);
    stage.setScene(scene);
    stage.show();

    btningresar.getScene().getWindow().hide();
    } catch (IOException ex) {
    mutil.mensaje(ex.getMessage(), "ERROR");

        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgcargar.setVisible(false);
        ValidationSupport vs=new ValidationSupport();
        vs.registerValidator(txtdni,false,Validator.createRegexValidator("EL DNI del ususrio incorrecto","\\d{8}", Severity.ERROR));
        vs.registerValidator(txtclave, false,Validator.createEmptyValidator("La contraseña no puede ser vacia", Severity.ERROR));
    }
    
}
