package database.factory

import java.sql.Connection

interface IConnectionDB {
    Connection getConnection();
}