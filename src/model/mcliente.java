/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.mutil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author IRINEO
 */
public class mcliente {
    
    private String dni;
    private String nombre;
    private String apellido;

    public mcliente(){
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
    }
    public mcliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public static ObservableList<mcliente> mostarcliente(){
        ObservableList<mcliente> list;
        list=FXCollections.observableArrayList();
        conextion cnn=new conextion();
        Connection c=cnn.conectar();
        try{
            CallableStatement cst=c.prepareCall("call mostrarclientes()");
            ResultSet resul=cst.executeQuery();
            while(resul.next()){
                list.add(new mcliente(resul.getString(1), resul.getString(2), resul.getString(3)));
            }
            cnn.desconectar();
        }catch (SQLException ex){
            mutil.mensaje(ex.getMessage(), "ERROR");
            cnn.desconectar();
        }
        return list;
    }
    
    public boolean guardarcliente(String operacion){
        boolean respuesta=false;
        conextion cnn=new conextion();
        Connection c=cnn.conectar();
        try {
            CallableStatement cst;
            if(operacion.equals("guardar")){
                cst=c.prepareCall("call guardarcliente(?,?,?)");
            }else{
                cst=c.prepareCall("call actualizarcliente(?,?,?)");
            }
            cst.setString(1,getDni());
            cst.setString(2, getNombre());
            cst.setString(3, getApellido());
            cst.executeQuery();
            mutil.mensaje("OPERACIÓN REALIZADA CORRECTAMENTE", "EXITO");
            cnn.desconectar();
        }
        catch(SQLException ex){
            mutil.mensaje(ex.getMessage(), "ERROR");
            cnn.desconectar();
        }
    return respuesta;    
    }
    
}
