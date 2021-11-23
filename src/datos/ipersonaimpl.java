 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

//import com.mysql.cj.protocol.Resultset;
import datos.interfas.ipersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ipersonaimpl implements ipersona{

    public boolean insertarpersona(persona p) {
        conection base = new conection();
        try{
            String sql = "INSERT INTO `PERSONA`(`NOMBRE`, `APELLIDO`, `TIPODOCUMENTO`, `DOCUMENTO`, `DIRECCION`, `TELEFONO`, `ROLL`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = base.con.prepareStatement(sql);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellido());
            stmt.setString(3, p.getTipodocumento());
            stmt.setString(4, p.getDocumento());
            stmt.setString(5, p.getDireccion());
            stmt.setInt(6, p.getTelefono());
            stmt.setString(7, p.getRoll());
            stmt.executeUpdate();
            return true ;            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }        
        return false;
    }

    public String eliminarpersona(String documento) {
        conection base = new conection();
        try{
            String sql = "DELETE from `PERSONA` where `DOCUMENTO`='"+documento+"'";
            PreparedStatement stmt = base.con.prepareStatement(sql);
            stmt.executeUpdate();
            return "Eliminado" ;
        }catch (Exception e){
                        System.out.println(documento);
                        System.out.println(e.getMessage());
        }        
        return "No ha sido posible eliminar al usuario";
    }

    @Override
    public boolean actualizarpersona(String documento, persona p) {
        conection base = new conection();
        try{
        String sql = "UPDATE `PERSONA` SET `IDPERSONA`=?,`NOMBRE`=?,`APELLIDO`=?,`TIPODOCUMENTO`=?,`DOCUMENTO`=?,`DIRECCION`=?,`TELEFONO`=?,`ROLL`=? WHERE documento='"+documento+"'";
        PreparedStatement stmt = base.con.prepareStatement(sql);
        stmt.setString(1, p.getNombre());
        stmt.setString(2, p.getApellido());
        stmt.setString(3, p.getTipodocumento());
        stmt.setString(4, p.getDocumento());
        stmt.setString(5, p.getDireccion());
        stmt.setInt(6, p.getTelefono());
        stmt.setString(7, p.getRoll());
        stmt.setString(8, documento);
        
        stmt.executeUpdate();
                return true ;
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    @Override
    public persona buscarpersona(String documento) {
        conection base = new conection();
        try{
        Statement stmt = base.con.createStatement();
        String sql = "Select * from PERSONA where DOCUMENTO='"+documento+"'";
        ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return (new persona(rs.getString("NOMBRE"),rs.getString("APELLIDO"),rs.getString("TIPODOCUMENTO"),rs.getString("DOCUMENTO"),rs.getString("DIRECCION"),rs.getInt("TELEFONO"),rs.getString("ROLL"))) ;
            }
        }catch (Exception e){
        }
        
        return null;
    }

    @Override
    public boolean login(String documento, String roll) {
        conection base = new conection();
        try{
            Statement stmt = base.con.createStatement();
            String sql = "Select * from PERSONA join TIPOSPERSONA on PERSONA.TIPOPERSONA=ID where DOCUMENTO='"+documento+"' and  DESCRIPCION='"+roll+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            
        }
        
        return false;
    }

    

    
    

  
    
}
