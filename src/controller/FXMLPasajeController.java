/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author IRINEO
 */
public class FXMLPasajeController implements Initializable {

    @FXML
    private JFXTextField textnumeropasaje;
    @FXML
    private DatePicker textfechapasaje;
    @FXML
    private JFXTextField textdnicliente;
    @FXML
    private JFXTextField textdniusuario;
    @FXML
    private JFXButton btnguardar;
    @FXML
    private JFXButton btnnuevo;
    @FXML
    private TableView<?> tblpasaje;
    @FXML
    private TableColumn<?, ?> clnumeropsaje;
    @FXML
    private TableColumn<?, ?> clnumeroasiento;
    @FXML
    private TableColumn<?, ?> cldniusuario;
    @FXML
    private TableColumn<?, ?> cldnicliente;
    @FXML
    private TableColumn<?, ?> claniopasaje;
    @FXML
    private TableColumn<?, ?> clcodigopasaje;
    @FXML
    private TableColumn<?, ?> clfechapasaje;
    @FXML
    private JFXTextField textañiopasaje;
    @FXML
    private JFXTextField textcodigosalida;
    @FXML
    private JFXTextField textnumeroasiento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardar(ActionEvent event) {
    }

    @FXML
    private void nuevo(ActionEvent event) {
    }
    
}
