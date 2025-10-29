package controller

import model.Candidato
import service.CandidatoService
import view.MenuCriarModel

import java.sql.Connection
import java.sql.ResultSet
import java.time.LocalDate
import java.time.Period

class CandidatoController {
    Connection conn

    CandidatoController(Connection connection) {
        this.conn = connection
    }

    CandidatoService service = new CandidatoService()
    Scanner input = new Scanner(System.in)

    void cadastrarCandidato() {
        Candidato candidato = MenuCriarModel.criarCandidato()
        service.cadastrarCandidato(conn, candidato)
    }

    void listarcandidatos() {
        ResultSet result = service.listarCandidatos(conn)

        while (result.next()) {
            LocalDate dataNascimento = result.getDate("date_of_birth").toLocalDate()
            int idade = Period.between(dataNascimento, LocalDate.now()).getYears()

            printf("\n\tCandidato ID: %d\n\tIdade: %d\n\tEmail: %s\n\tDescrição: %s\n\tPais: %s\n\tCompetencias: %s\n - \n", result.getInt("id"), idade, result.getString("email"), result.getString("description"), result.getString("country"), result.getString("string_agg"))
        }
    }

    void atualizarCandidato() {
        print "\n\tInsira o id do candidato: "
        Integer id = Integer.parseInt(input.nextLine())

        Candidato candidato = MenuCriarModel.criarCandidato()

        service.atualizarCandidato(conn, candidato, id)
    }

    void deletarCandidato(){
        print "\n\tInsira o id do candidato: "
        Integer id = Integer.parseInt(input.nextLine())

        service.deletarCandidato(conn, id)
    }
}