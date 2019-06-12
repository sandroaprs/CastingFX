package model;

/**
*
* @author Sandro Souza
*/
public class Referencia {

    private String tipoRf;
    private int idReferencia;
    private String descricao;
    public static final int REF_ETNIA = 1;
    public static final int REF_COR_CABELO = 2;
    public static final int REF_TIPO_FISICO = 3;
    public static final int REF_TIPO_CABELO = 4;
    public static final int REF_COR_OLHOS = 5;
    public static final int REF_DENTES = 6;
    public static final int REF_CIRCO = 7;
    public static final int REF_ESPORTES = 8;
    public static final int REF_DANCA = 9;
    public static final int REF_IDIOMA = 10;
    public static final int REF_HABILITACAO = 11;
    public static final int REF_INSTRUMENTO = 12;
    public static final int REF_PROFISSAO = 13;

    public String getTipoRf() {
        return tipoRf;
    }

    public void setTipoRf(String tipoRf) {
        this.tipoRf = tipoRf;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
