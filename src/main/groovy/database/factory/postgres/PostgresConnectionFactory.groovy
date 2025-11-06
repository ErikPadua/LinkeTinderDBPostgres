package database.factory.postgres

import database.factory.ConnectionFactory
import database.factory.IConnectionDB

class PostgresConnectionFactory extends ConnectionFactory {

    @Override
    IConnectionDB createConnection() {
        return new ConnectionPostgres()
    }
}
