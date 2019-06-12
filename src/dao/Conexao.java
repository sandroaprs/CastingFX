package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
*
* @author Sandro Souza
*/
public class Conexao {
    
    private Connection con;
    private java.sql.Statement st;

    public Connection getCon() {
        return con;
    }

    public Statement getSt() {
        return st;
    }
    
    
    
    public Statement conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://189.113.168.54:3306/factorso_casting", "factorso_casting", "casting69");
            st = con.createStatement();
            return st;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conexão com o banco de dados.");
            ex.printStackTrace();
            return null;
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conexão com o banco de dados.");
            ex1.printStackTrace();
            return null;
        }

    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}
