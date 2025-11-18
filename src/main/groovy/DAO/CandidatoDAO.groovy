package DAO

import model.Candidato
import util.CandidatoQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoDAO {

    CandidatoQueryUtil repository = new CandidatoQueryUtil()

    boolean cadastrarCandidato(Connection conn, Candidato candidato) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastrar(candidato))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao cadastrar o candidato"
            return false
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

    boolean atualizarCandidato(Connection conn, Candidato candidato, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(candidato, id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao atualizar o candidato"
            return false
        }
    }

    boolean deletarCandidato(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao deletar o candidato"
            return false
        }
    }
}

