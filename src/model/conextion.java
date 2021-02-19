/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author IRINEO
 */
public class conextion {
    public Connection conectar=null;
    public Connection conectar(){
        try{//
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdsispasajes?"
                    +"useLegacyDatetimeCode=false&"
                    +"serverTimezone=America/Lima&"
                    +"useSSL=false","root","123456");
            System.out.println("Coneccion exitosa");
        }catch(ClassNotFoundException|SQLException ex){
            System.err.println(ex.getMessage());
        }
        return conectar;
    }
    public void desconectar(){
        try{
            conectar.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
