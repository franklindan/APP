/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 *
 * @author IRINEO
 */
public class mutil {
    public static void mensaje(String Mensaje, String tipo){
        Image img;
      if(tipo.equals("ERROR")){
          img= new Image("/view/img/alert.png", 50,50,false, false);
      }else{
          img= new Image("/view/img/sucessfull.png", 50,50,false, false);
      }
       
        Notifications notificatonBuilder=Notifications.create().title(tipo).
                text(Mensaje).graphic(new ImageView(img)).hideAfter(Duration.seconds(4)).
                position(Pos.CENTER).onAction(new EventHandler<ActionEvent>(){
                   
        @Override
        public void handle(ActionEvent event){
            
           
        }
    });
     
        notificatonBuilder.darkStyle();
        notificatonBuilder.show();
    }
}
