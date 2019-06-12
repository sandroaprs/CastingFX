package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Usuario;

/**
 *
 * @author Sandro Souza
 */
public class UsuarioDAO {
    
    
    public static Usuario ralizarLogin(String login,String senha,Statement st) throws SQLException{      
        
        ResultSet rs = st.executeQuery("SELECT * FROM db_usuario WHERE login = '" + login + "' AND senha = '" + senha + "';");
        
        Usuario u = null;
        
        if(rs.next()){
            u = new Usuario();
            
            u.setIdUsuario((rs.getInt("id_usuario")));
            u.setEmail(rs.getString("email"));
            u.setLogin(rs.getString("login"));
            u.setNome(rs.getString("nome"));
            u.setSenha(rs.getString("senha"));
            u.setDataCad(rs.getDate("data_cad"));
            u.setStaus(rs.getString("staus").charAt(0));
            
        } 
        
        
        
        return u;
        
    }
    
    
    
  
    
    
}
