package controller

import model.Empresa
import service.EmpresaService
import view.MenuCriarModel

import java.sql.Connection
import java.sql.ResultSet

class EmpresaController {
    Connection conn

    EmpresaController(Connection connection) {
        this.conn = connection
    }

    EmpresaService service = new EmpresaService()
    Scanner input = new Scanner(System.in)

    void cadastrarEmpresa() {
        Empresa empresa = MenuCriarModel.criarEmpresa()
        service.cadastrarEmpresa(conn, empresa)
    }

    void listarEmpresas() {
        ResultSet result = service.listarEmpresas(conn)
        while (result.next()) {
            printf("\n\tEmpresa ID: %d\n\tEmpresa: %s\n\tCNPJ: %s\n\tEmail: %s\n\tDescrição: %s\n\tPais: %s\n\tCEP: %s\n - \n", result.getInt("id"), result.getString("name"), result.getString("cnpj"), result.getString("email"), result.getString("description"), result.getString("country"), result.getString("cep"))
        }
    }

    void atualizarEmpresa() {
        print "\n\tInsira o id da empresa: "
        Integer id = Integer.parseInt(input.nextLine())

        Empresa empresa = MenuCriarModel.criarEmpresa()
        service.atualizarEmpresa(conn, empresa, id)
    }

    void deletarEmpresa() {
        print "\n\tInsira o id da empresa: "
        Integer id = Integer.parseInt(input.nextLine())

        service.deletarEmpresa(conn,id)
    }
}
