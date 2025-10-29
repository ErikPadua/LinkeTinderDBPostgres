import database.ConnectionPostgres
import view.Menu

import java.sql.Connection

Connection conn = ConnectionPostgres.conectar()
ConnectionPostgres.criarDatabase(conn)

Menu.startMenu(conn)

ConnectionPostgres.desconectar(conn)