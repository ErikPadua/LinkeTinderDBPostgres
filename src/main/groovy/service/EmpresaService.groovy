package service

import DTO.EmpresaDTO
import model.Empresa
import DAO.EmpresaDAO

import java.sql.Connection
import java.sql.ResultSet

class EmpresaService {
    Connection conn

    EmpresaService(Connection connection) {
        this.conn = connection
    }

    EmpresaDAO service = new EmpresaDAO()

    boolean cadastrarEmpresa(Empresa empresa) {
       return service.cadastrarEmpresa(conn, empresa)
    }

    List<EmpresaDTO> listarEmpresas() {
        ResultSet result = service.listarEmpresas(conn)
        List<EmpresaDTO> empresas = new ArrayList<>()

        while (result.next()) {
            EmpresaDTO empresa = new EmpresaDTO(id: result.getInt("id"), name: result.getString("name"), cnpj: result.getString("cnpj"), email: result.getString("email"), description: result.getString("description"), country: result.getString("country"), cep: result.getString("cep"))
            empresas.add(empresa)
        }

        return empresas
    }

    boolean atualizarEmpresa(Empresa empresa, Integer id) {
        return service.atualizarEmpresa(conn, empresa, id)
    }

    boolean deletarEmpresa(Integer id) {
      return  service.deletarEmpresa(conn,id)
    }
}
