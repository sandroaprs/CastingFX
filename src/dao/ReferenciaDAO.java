package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Referencia;
import model.Usuario;

/**
*
* @author Sandro Souza
*/
public class ReferenciaDAO {
    

    
    
    
    public static ArrayList<Referencia> getReferencia(int referencia,Statement st) throws SQLException{                      
        
        ResultSet rs = st.executeQuery("SELECT descricao,id_referencia,tipo_rf FROM db_referencia WHERE tipo_rf  = '" + referencia + "';");
        
        
        ArrayList<Referencia> rf = new ArrayList();
        
        
        
        while(rs.next()){
            Referencia r = new Referencia();
            
            r.setDescricao(rs.getString("descricao"));
            r.setTipoRf(rs.getString("tipo_rf"));
            r.setIdReferencia(rs.getInt("id_referencia"));
            
            
            rf.add(r);
            
        } 
        
        
        
        return rf;
        
    }
    
    
}
