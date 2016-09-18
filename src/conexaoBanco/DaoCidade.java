package conexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nikollas
 */
public class DaoCidade {
    private final Connection conn;
    private final Statement stmt;
    private ResultSet result;
    private final PreparedStatement pstm, view;

    public DaoCidade(Connection conn) throws SQLException {
        this.conn = conn;
        stmt = (Statement) conn.createStatement();
        pstm = conn.prepareStatement("SELECT * FROM cidades");
        view = conn.prepareStatement("SELECT * FROM cidades order by nome");
    }

    public int inserir(ModelCidade cidade) throws SQLException {
        String SQL = "insert into cidades values(?,?,?)";
        int r;
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, cidade.getIdCidade());
            ps.setString(2, cidade.getNome());
            ps.setInt(3, cidade.getCodigoIBGE());
            ps.setInt(4, cidade.getFkEstado());
            r = ps.executeUpdate();
        }
        return r;
    }

    public int excluir(int value) throws SQLException {
        String SQL = "DELETE FROM cidades where idCidade =" + value;
        return stmt.executeUpdate(SQL);
    }

    public void editar(ModelCidade cidade) throws SQLException {
        String SQL = "udpdate cidades set"
                + "nome=?"
                + ", codigoIBGE=?"
                +",fkEstado=?"
                + "where idEstado=?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
           ps.setInt(1, cidade.getIdCidade());
            ps.setString(2, cidade.getNome());
            ps.setInt(3, cidade.getCodigoIBGE());
            ps.setInt(4, cidade.getFkEstado());
            ps.executeUpdate();
        }
    }

    public ResultSet view() throws SQLException {
        result = pstm.executeQuery();
        return this.result;
    }

    public ModelCidade bdToObject(ResultSet rs) throws SQLException {
        return new ModelCidade(rs.getInt("idCidade"),rs.getString("nome"),rs.getInt("codigoIBGE"),rs.getInt("fkEstado"));
    }

    public ModelCidade pesquisaID(int id) throws SQLException {
        ModelCidade cidade;
        PreparedStatement pStm = conn.prepareStatement("select * from cidades where idCidades = ?");
        pStm.setInt(1, id);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        cidade = bdToObject(rs);
        return cidade;
    }

}
