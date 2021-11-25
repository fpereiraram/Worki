/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.conection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class tipos {
    static ResultSet rs;
    
    public static ArrayList <String> tipodocumento(){
        //Se llama la coneccion de la base de datos
        conection base = new conection();
        ArrayList <String> lista=new ArrayList();
        try{
            Statement stmt = base.con.createStatement();
            //Se realiza la sentencia que se va a ejecutar en la base de datos
            String sql="Select * from `TIPODOCUMENTO`";
            rs = stmt.executeQuery(sql);
        }catch (Exception e){
            //Imprime el error que se presento en la sentencia anterior 
            System.out.println("Error en la sintaxis de la consulta"+e);
        }
        try{
            while(rs.next()){
                lista.add(rs.getString("NOMBRE"));
            }
        }catch (Exception e){
                //Imprime el error que se presento en la columna seleccionada                 System.out.println("Error en la sintaxis de la columna seleccionada"+e);
        }
        return lista;
    }
    public static ArrayList <String> tiporoll(){
        conection base = new conection();
        ArrayList <String> lista=new ArrayList();
        try{
            Statement stmt = base.con.createStatement();
            String sql="Select * from `TIPOSPERSONA`";
            rs = stmt.executeQuery(sql);
        }catch (Exception e){
            
        }
        try{
            while(rs.next()){
                lista.add(rs.getString("DESCRIPCION"));
            }
        }catch (Exception e){
            
        }
        return lista;
    }
    public static ArrayList <String> tipovehiculo(){
        conection base = new conection();
        ArrayList <String> lista=new ArrayList();
        try{
            Statement stmt = base.con.createStatement();
            String sql="Select * from `TIPOVEHICULO`";
            rs = stmt.executeQuery(sql);
        }catch (Exception e){
            
        }
        try{
            while(rs.next()){
                lista.add(rs.getString("CLASE"));
            }
        }catch (Exception e){
            
        }
        return lista;
    }
}
