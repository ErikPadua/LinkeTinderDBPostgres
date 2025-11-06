package database

import java.nio.file.Files
import java.nio.file.Paths
import java.sql.Connection
import java.sql.PreparedStatement

class DataSeeder {
    static void preencherDatabase(Connection conn) {
        String sql = Files.readString(Paths.get("database/Linketinder.sql"))
        try {
            PreparedStatement database = conn.prepareStatement(sql)
            database.executeQuery()
        } catch (Exception e) {
            println "Falha ao Preencher Database"
        }
    }
}
