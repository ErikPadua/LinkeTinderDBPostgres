package database.factory.postgres

import database.factory.IConnectionDB

import java.sql.Connection
import java.sql.DriverManager

class ConnectionPostgres  implements IConnectionDB{
    private static final String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/test"
    private static final String USER = "postgres"
    private static final String PASSWORD = "postgres"

    private static Connection instanceConnectionPostgres

    @Override
    Connection getConnection() {
        try {
            if(instanceConnectionPostgres == null) {
                return DriverManager.getConnection(URL_SERVIDOR, USER, PASSWORD)
            }
            return  instanceConnectionPostgres
        } catch (Exception e) {
            println ("Erro ao conectar ao PostgreSQL")
        }
    }
}
