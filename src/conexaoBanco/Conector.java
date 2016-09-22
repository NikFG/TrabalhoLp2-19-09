package conexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikollas
 */
public class Conector {

    private Connection conexao = null;
    private static final String DRIVER_PADRAO_MYSQL = "com.mysql.jdbc.Driver";
    private static final String URL_PADRAO_MYSQL = "jdbc:mysql://localhost:3306/"; //para ser concatenada com o nome do banco

    public Conector(String driver, String url, String nomeBanco, String usuario, String senha) {
        try {
            String urlFinal = url + nomeBanco;
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(urlFinal, usuario, senha);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    public Conector(String nomeBanco, String usuario, String senha) {
        this(DRIVER_PADRAO_MYSQL, URL_PADRAO_MYSQL, nomeBanco, usuario, senha);
    }

    public void fecharResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharConexao() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
                System.out.println("Fechooooou");
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConexao() {
        return conexao;
    }

}
