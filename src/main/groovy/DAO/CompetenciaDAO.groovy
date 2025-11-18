package DAO

import model.Competencia
import util.CompetenciaQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {

    CompetenciaQueryUtil repository = new CompetenciaQueryUtil()

    boolean cadastrarCompetencia(Connection conn, Competencia competencia) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(competencia))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao cadastrar a competência"
            return false
        }
    }

    ResultSet listarCompetencias(Connection conn) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.listar())
            return query.executeQuery()
        } catch (Exception e) {
            println "Erro ao listar competências"
        }
    }

    boolean atualizarCompetencia(Connection conn, Competencia competencia, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(competencia, id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao atualizar a competência"
            return false
        }
    }

    boolean deletarCompetencia(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()

            return true
        } catch (Exception e) {
            println "Erro ao deletar a competência"
            return false
        }
    }
}
