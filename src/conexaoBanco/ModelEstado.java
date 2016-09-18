package conexaoBanco;

/**
 *
 * @author Nikollas
 */
public class ModelEstado {

    private int idEstado;
    private String nome;
    private String uf;

    public ModelEstado() {
    }

    public ModelEstado(int idEstado, String nome, String uf) {
        this.idEstado = idEstado;
        this.nome = nome;
        this.uf = uf;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter e Setter">
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "ModelEstado{" + "idEstado=" + idEstado + ", nome=" + nome + ", uf=" + uf + '}';
    }

}
