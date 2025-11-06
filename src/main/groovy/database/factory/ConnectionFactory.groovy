package database.factory

abstract class ConnectionFactory {
    abstract IConnectionDB createConnection()
}
