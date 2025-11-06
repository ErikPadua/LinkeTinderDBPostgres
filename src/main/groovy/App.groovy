import database.DataSeeder
import database.factory.postgres.PostgresConnectionFactory
import view.Menu
import java.sql.Connection

Connection conn = new PostgresConnectionFactory().createConnection().getConnection();
DataSeeder.preencherDatabase(conn)

Menu.startMenu(conn)

conn.close()