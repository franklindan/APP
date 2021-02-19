
package model;

import controller.mutil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;


/**
 *
 * @author IRINEO
 */
public class musuario {
    
    private String dni;
    private String nombre;
    private String apellido;
    private String tipousuario;
    private String estado;
    private String direccion;
    private String clave;
    private Image foto;

    public Image getFoto() {
        return foto;
    }
    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = incriptar(clave);
    }


    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipousuario() {
        return tipousuario;
    }
    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
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
     public boolean validarusuario() throws SQLException, IOException{
         conextion cn=new conextion();
         Connection c=cn.conectar();
        boolean respuesta=false;
        try {
            CallableStatement cst = c.prepareCall("{call validarusuario(?,?)}");
            cst.setString(1, getDni());  
            cst.setString(2, getClave());    
            ResultSet res=cst.executeQuery();     
            int rows;
            res.last();
            rows = res.getRow();
            res.beforeFirst();
            if (rows!=0){
                respuesta=true;
                 while (res.next()){
                    this.setNombre(res.getString(2).trim());
                    this.setApellido(res.getString(3));    
                    this.setTipousuario(res.getString(6));
                    Blob blob = res.getBlob(5);
                    byte byteImage[];
                    byteImage = blob.getBytes(1, (int) blob.length());                       
                    Image img = new Image(new ByteArrayInputStream(byteImage));                        
                    this.setFoto(img);                                    
                }
            c.close();
            }
        } catch (SQLException ex) {
            mutil.mensaje(ex.getMessage(),"ERROR");
            c.close();
        }
        finally{
            c.close();
        }
        return respuesta;
    }   
     
     
     public String incriptar(String pasaaword){
         String resultado;
         char array[]=pasaaword.toCharArray();
         for(int i=0; i<array.length; i++){
             array[i]=(char) (array[i]+(char)5);
         }
         resultado=String.valueOf(array);
         return resultado;
     }
    
}
