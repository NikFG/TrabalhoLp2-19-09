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
public class DaoEstado {

    private final Connection conn;
    private final Statement stmt;
    private ResultSet result;
    private final PreparedStatement pstm, view;

    public DaoEstado(Connection conn) throws SQLException {
        this.conn = conn;
        stmt = (Statement) conn.createStatement();
        pstm = conn.prepareStatement("SELECT * FROM estados");
        view = conn.prepareStatement("SELECT * FROM estados order by nome");
    }

    public int inserir(ModelEstado estado) throws SQLException {
        String SQL = "insert into estados values(?,?,?)";
        int r;
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, estado.getIdEstado());
            ps.setString(2, estado.getNome());
            ps.setString(3, estado.getUf());
            r = ps.executeUpdate();
        }
        return r;
    }

    public int excluir(int value) throws SQLException {
        String SQL = "DELETE FROM estados where idEstado =" + value;
        return stmt.executeUpdate(SQL);
    }

    public void editar(ModelEstado estado) throws SQLException {
        String SQL = "udpdate estados set"
                + "nome=?"
                + ", uf=?"
                + "where idEstado=?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, estado.getIdEstado());
            ps.setString(2, estado.getNome());
            ps.setString(3, estado.getUf());
            ps.executeUpdate();
        }
    }

    public ResultSet view() throws SQLException {
        result = pstm.executeQuery();
        return this.result;
    }

    public ModelEstado bdToObject(ResultSet rs) throws SQLException {
        return new ModelEstado(rs.getInt("idEstado"), rs.getString("nome"), rs.getString("uf"));
    }

    public ModelEstado pesquisaID(int id) throws SQLException {
        ModelEstado estado;
        PreparedStatement pStm = conn.prepareStatement("select * from estados where idEstado = ?");
        pStm.setInt(1, id);
        ResultSet rs;
        rs = pStm.executeQuery();
        rs.next();
        estado = bdToObject(rs);
        return estado;
    }
}
