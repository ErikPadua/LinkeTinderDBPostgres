package controller

import model.Vaga
import DAO.VagaDAO
import view.MenuCriarModel

import java.sql.Connection
import java.sql.ResultSet

class VagaController {
    Connection conn

    VagaController(Connection connection) {
        this.conn = connection
    }

    VagaDAO service = new VagaDAO()
    Scanner input = new Scanner(System.in)

    void cadastrarVaga() {
        Vaga vaga = MenuCriarModel.criarVaga()
        service.cadastrarVaga(conn, vaga)
    }

    void listarVagas() {
        ResultSet result = service.listarVagas(conn)
        while (result.next()) {
            printf("\n\tVaga ID: %d\n\tEmpresa: %s\n\tVaga: %s\n\tDescrição: %s\n\tLocal: %s,%s\n\tCompetencias Desejadas: %s\n - \n", result.getInt("id"), result.getString("company"), result.getString("name"), result.getString("description"), result.getString("city"), result.getString("state"), result.getString("string_agg"))
        }
    }

    void atualizarVaga() {
        print "\n\tInsira o ID da vaga: "
        Integer id = Integer.parseInt(input.nextLine())

        Vaga vaga = MenuCriarModel.criarVaga()

        service.atualizarVaga(conn, vaga, id)
    }

    void deletarVaga() {
        print "\n\tInsira o id da vaga: "
        Integer id = Integer.parseInt(input.nextLine())

        service.deletarVaga(conn, id)
    }
}
