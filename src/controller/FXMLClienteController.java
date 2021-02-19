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
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.mcliente;

/**
 * FXML Controller class
 *
 * @author IRINEO
 */
public class FXMLClienteController implements Initializable {

    @FXML
    private TableView<mcliente> tblcliente;

    @FXML
    private TableColumn<mcliente, String> clmdni;

    @FXML
    private TableColumn<mcliente, String> clmnombre;

    @FXML
    private TableColumn<mcliente, String> clmapellido;

    @FXML
    private JFXTextField textdni;

    @FXML
    private JFXTextField textnombre;

    @FXML
    private JFXTextField textapellido;

    @FXML
    private JFXButton btnguardar;

    @FXML
    private JFXButton btnnuevo;

    @FXML
    private JFXTextField textbuscar;
    
    private ObservableList<mcliente> ob;
    FilteredList<mcliente> filteredData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clmdni.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("dni"));
        clmnombre.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));
        clmapellido.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("apellido"));
        cargardatos();
        
    }  
    public void cargardatos() {
        ob=mcliente.mostarcliente();
        tblcliente.setItems(ob);
    }

    @FXML
    private void guardar(ActionEvent event) {
        if(textdni.getText().length()>0 && textnombre.getText().length()>0 &&
                textapellido.getText().length()>0){
            mcliente mp=new mcliente();
            mp.setDni(textdni.getText());
            mp.setNombre(textnombre.getText());
            mp.setApellido(textapellido.getText());
            mp.guardarcliente("guardar");
            cargardatos();
        }else{
            mutil.mensaje("FALTAN DATOS", "ERROR");
        }
    }

    @FXML
    private void nuevo(ActionEvent event) {
    }
    
}
