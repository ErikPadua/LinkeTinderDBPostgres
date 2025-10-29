package controller

import model.Competencia
import service.CompetenciaService
import view.MenuCriarModel

import java.sql.Connection
import java.sql.ResultSet

class CompetenciaController {
    Connection conn

    CompetenciaController(Connection connection) {
        this.conn = connection
    }

    CompetenciaService service = new CompetenciaService()
    Scanner input = new Scanner(System.in)

    void cadastrarCompetencia() {
        Competencia competencia = MenuCriarModel.criarCompetencia()
        service.cadastrarCompetencia(conn, competencia)
    }

    void listarCompetencia() {
        ResultSet result = service.listarCompetencias(conn)
        while (result.next()) {
            printf("\n\tCompetência ID: %d\n\tCompetência: %s\n - \n", result.getInt("id"), result.getString("skill"))
        }
    }

    void atualizarCompetencia() {
        print "\n\tInsira o id da competencia: "
        Integer id = Integer.parseInt(input.nextLine())
        Competencia competencia = MenuCriarModel.criarCompetencia()
        service.atualizarCompetencia(conn, competencia, id)
    }

    void deletarCompetencia() {
        print "\n\tInsira o id da competencia: "
        Integer id = Integer.parseInt(input.nextLine())
        service.deletarCompetencia(conn, id)
    }
}
