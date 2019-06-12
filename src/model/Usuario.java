package model;

import java.sql.Date;

/**
*
* @author Sandro Souza
*/
public class Usuario {

    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private Date dataCad;
    private String email;
    private char staus;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_cad() {
        return dataCad;
    }

    public void setData_cad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getStaus() {
        return staus;
    }

    public void setStaus(char staus) {
        this.staus = staus;
    }
    
    
    
}
