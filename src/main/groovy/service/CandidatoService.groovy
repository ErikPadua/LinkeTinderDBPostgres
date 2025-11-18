package service

import DTO.CandidatoDTO
import model.Candidato
import DAO.CandidatoDAO

import java.sql.Connection
import java.sql.ResultSet
import java.time.LocalDate
import java.time.Period

class CandidatoService {
    Connection conn

    CandidatoService(Connection connection) {
        this.conn = connection
    }

    CandidatoDAO service = new CandidatoDAO()

    boolean cadastrarCandidato(Candidato candidato) {
        return service.cadastrarCandidato(conn, candidato)
    }

    List<CandidatoDTO> listarcandidatos() {
        ResultSet result = service.listarCandidatos(conn)
        List<CandidatoDTO> candidatos = new LinkedList<>()

        while (result.next()) {
            LocalDate dataNascimento = result.getDate("date_of_birth").toLocalDate()
            int idade = Period.between(dataNascimento, LocalDate.now()).getYears()

            CandidatoDTO candidato = new CandidatoDTO(id: result.getInt("id"), idade: idade, email: result.getString("email"), descricao: result.getString("description"), pais: result.getString("country"),competencias: result.getString("string_agg"))

           candidatos.add(candidato)
        }

        return candidatos
    }

    boolean atualizarCandidato(Candidato candidato, Integer id) {
        return service.atualizarCandidato(conn, candidato, id)
    }

    boolean deletarCandidato(Integer id){
        return service.deletarCandidato(conn, id)
    }
}