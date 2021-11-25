/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class conection {
    Connection con;
    String m;

    public conection(String m) {
        this.m = m;
    }
    
    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="cinema";
    private static final String pass="1234";
    private static final String url="jdbc:mysql://localhost:3310/cinema";
    
    public void conectar(){
    con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                m="Conexion establecida";
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
                m="Error de conexion" + e;
        }
        System.out.println(m);

    }
    public void desconectar(){
        try{
            con.close();
        }catch(SQLException con){
            System.out.println("Error en la desconexion");
        }
    }
    public conection() {
        conectar();
    }
    
    public static void main(String[] args){
        new conection();
    }
}
