package DAO

import model.Empresa
import util.EmpresaQueryUtil

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAO {

    EmpresaQueryUtil repository = new EmpresaQueryUtil()

    boolean cadastrarEmpresa(Connection conn, Empresa empresa) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(empresa))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao cadastrar o empresa"
            return false
        }

    }

    ResultSet listarEmpresas(Connection conn) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.listar())
            return query.executeQuery()
        } catch (Exception e) {
            println "Erro ao listar empresas"
        }

    }

    boolean atualizarEmpresa(Connection conn,Empresa empresa, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(empresa,id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao atualiza a empresa"
            return false
        }
    }

    boolean deletarEmpresa(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
            return true
        } catch (Exception e) {
            println "Erro ao deletar a empresa"
            return false
        }
    }
}
