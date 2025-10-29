package database

import java.nio.file.Files
import java.nio.file.Paths
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class ConnectionPostgres {

    static Connection conectar() {
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", "postgres")
        props.setProperty("ssh", "false")
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/test"

        try {
            return DriverManager.getConnection(URL_SERVIDOR, props)
        } catch (Exception e) {
            e.printStackTrace()
            return null;
        }
    }

    static void desconectar(Connection conn) {
        if (conn != null) conn.close()
    }

    static void criarDatabase(Connection conn) {
        String sql = Files.readString(Paths.get("database/Linketinder.sql"))

        try {
            PreparedStatement database = conn.prepareStatement(sql)
            ResultSet result = database.executeQuery()
            println result

        } catch (Exception e) {}
    }
}
