/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author User
 */
public class persona {
    private String nombre;
    private String apellido;
    private String tipodocumento;
    private String documento;
    private String direccion;
    private int telefono;
    private String roll;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getRoll() {
        return roll;
    }

    public void setTipopersona(String roll) {
        this.roll = roll;
    }
    
    public persona(String nombre, String apellido, String tipodocumento, String documento, String direccion, int telefono,String roll) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodocumento = tipodocumento;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.roll = roll;
    }      
}
