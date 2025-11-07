package DAO

import model.Competencia
import util.CompetenciaQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {

    CompetenciaQueryUtil repository = new CompetenciaQueryUtil()

    void cadastrarCompetencia(Connection conn, Competencia competencia) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(competencia))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao cadastrar a competência"
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

    void atualizarCompetencia(Connection conn, Competencia competencia, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(competencia, id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao atualizar a competência"
        }
    }

    void deletarCompetencia(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao deletar a competência"
        }
    }
}
