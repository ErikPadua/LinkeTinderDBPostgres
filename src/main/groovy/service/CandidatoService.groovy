package service

import model.Candidato
import repository.CandidatoRepository

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoService {

    CandidatoRepository repository = new CandidatoRepository()

    void cadastrarCandidato(Connection conn, Candidato candidato) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastrar(candidato))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao cadastrar o candidato"
        }
    }

    ResultSet listarCandidatos(Connection conn) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.listar())
            return query.executeQuery()
        } catch (Exception e) {
            println "Erro ao listar candidatos"
        }
    }

    void atualizarCandidato(Connection conn, Candidato candidato, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(candidato, id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao atualizar o candidato"
        }
    }

    void deletarCandidato(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao deletar o candidato"
        }
    }
}

