package service

import model.Empresa
import repository.EmpresaRepository

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaService {

    EmpresaRepository repository = new EmpresaRepository()

    void cadastrarEmpresa(Connection conn, Empresa empresa) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.cadastra(empresa))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao cadastrar o empresa"
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

    void atualizarEmpresa(Connection conn,Empresa empresa, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.atualizar(empresa,id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao atualiza a empresa"
        }
    }

    void deletarEmpresa(Connection conn, Integer id) {
        try {
            PreparedStatement query = conn.prepareStatement(repository.deletar(id))
            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao deletar a empresa"
        }
    }
}
