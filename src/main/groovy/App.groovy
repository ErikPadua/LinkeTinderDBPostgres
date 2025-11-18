import controller.CandidatoController
import controller.EmpresaController
import controller.VagaController
import service.EmpresaService
import service.CandidatoService
import controller.CompetenciaController
import service.CompetenciaService
import database.DataSeeder
import database.factory.postgres.PostgresConnectionFactory
import org.apache.catalina.Context
import org.apache.catalina.startup.Tomcat
import service.VagaService

import java.sql.Connection

Tomcat tomcat = new Tomcat()
tomcat.setPort(8080)
tomcat.getConnector()

Context ctx = tomcat.addContext("/api", null)

Connection conn = new PostgresConnectionFactory().createConnection().getConnection();
DataSeeder.preencherDatabase(conn)

Tomcat.addServlet(ctx, "candidatos", new CandidatoController(new CandidatoService(conn)))
ctx.addServletMappingDecoded("/candidatos/*", "candidatos")

Tomcat.addServlet(ctx, "competencias", new CompetenciaController(new CompetenciaService(conn)))
ctx.addServletMappingDecoded("/competencias/*", "competencias")

Tomcat.addServlet(ctx, "empresas", new EmpresaController(new EmpresaService(conn)))
ctx.addServletMappingDecoded("/empresas/*", "empresas")

Tomcat.addServlet(ctx, "vagas", new VagaController(new VagaService(conn)))
ctx.addServletMappingDecoded("/vagas/*", "vagas")

tomcat.start()
tomcat.getServer().await()