package conexaoBanco;

/**
 *
 * @author Nikollas
 */
public class ModelCidade {

    private int idCidade;
    private String nome;
    private int codigoIBGE;
    private int fkEstado;

    public ModelCidade() {
    }

    public ModelCidade(int idCidade, String nome, int codigoIBGE, int fkEstado) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.fkEstado = fkEstado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter e Setter">
    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(int codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public int getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(int fkEstado) {
        this.fkEstado = fkEstado;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "ModelCidade{" + "idCidade=" + idCidade + ", nome=" + nome + ", codigoIBGE="
                + codigoIBGE + ", fkEstado=" + fkEstado + '}';
    }

}
