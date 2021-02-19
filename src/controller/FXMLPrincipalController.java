/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author IRINEO
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private JFXHamburger btnmenu;
    @FXML
    private JFXDrawer menu;
    @FXML
    private AnchorPane ventana;
    @FXML
    private JFXButton Menu;

    /**
     * Initializes the controller class.
     */
         FXMLMenuController dc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(btnmenu);
            transition.setRate(-2);
            btnmenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -5);
            transition.play();
            if (menu.isShown()) {
                menu.close();
            } else {
                menu.open();              
            }
             });
              try {
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/view/fxml/FXMLMenu.fxml"));
                VBox sidePane = Loader.load();               
                dc=Loader.getController();
                menu.setSidePane(sidePane);
                menu.setSidePane(sidePane);
               Accordion ac=(Accordion) sidePane.getChildren().get(1);
                for(int x=0; x<=2;x++){
                TitledPane tp=ac.getPanes().get(x);
                  for ( Node panel:  ((AnchorPane) tp.getContent()).getChildren()){
                        if (panel.getAccessibleText() != null) {
                    
                    panel.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                       
                        switch (panel.getAccessibleText()) {
                              case "cliente":
                              
                            {
                                 try {
                                        cargar("/view/fxml/FXMLCliente.fxml");
                                        //cargar("/view/fxml/FXMLPasaje.fxml");
                                        break;
                                    } catch (IOException ex) {
                                        mutil.mensaje(ex.getMessage(), "ERROR");
                                    }
                            }
                              case "pasaje":
                              {
                                 try {
                                        cargar("/view/fxml/FXMLPasaje.fxml");
                                        break;
                                    } catch (IOException ex) {
                                        mutil.mensaje(ex.getMessage(), "ERROR");
                                    }
                            }
                              case "salir":
                    
                        }
                    });
                }
                  }
                }

               }           
         catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }        
     private void cargar(String url) throws IOException{
         AnchorPane f = FXMLLoader.load(getClass().getResource(url));//
         setNode(f);
    }
     private void setNode(Node node) {
        ventana.getChildren().clear();
        ventana.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(ventana);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    

    @FXML
    private void accionmenu(ActionEvent event) {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/view/fxml/FXMLPrincipal.fxml"));
    }
    
}
