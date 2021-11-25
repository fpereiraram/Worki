/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfas;

/**
 *
 * @author User
 */
public interface ipersona {
    public String eliminarpersona(String documento);
    public boolean actualizarpersona(String documento, datos.persona p);
    public datos.persona buscarpersona(String documento);
    public boolean login(String usuario, String password);
}
