package DAO

import model.Vaga
import util.VagaQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    VagaQueryUtil repository = new VagaQueryUtil()

    boolean cadastrarVaga(Connection conn, Vaga vaga) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(vaga))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao cadastrar a vaga"
            return false
        }
    }

    ResultSet listarVagas(Connection conn) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.listar())
            return query.executeQuery()
        } catch (Exception e) {
            println "Erro ao listar vagas"
        }

    }

    boolean atualizarVaga(Connection conn, Vaga vaga, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(vaga, id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao atualizar a vaga"
            return false
        }
    }

    boolean deletarVaga(Connection conn,Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao deletar a vaga"
            return false
        }
    }
}
