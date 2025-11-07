package DAO

import model.Vaga
import util.VagaQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    VagaQueryUtil repository = new VagaQueryUtil()

    void cadastrarVaga(Connection conn, Vaga vaga) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(vaga))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao cadastrar a vaga"
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

    void atualizarVaga(Connection conn, Vaga vaga, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(vaga, id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao atualizar a vaga"
        }
    }

    void deletarVaga(Connection conn,Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao deletar a vaga"
        }
    }
}
