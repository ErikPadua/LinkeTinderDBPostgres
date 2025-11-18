package service

import DTO.VagaDTO
import model.Vaga
import DAO.VagaDAO
import view.MenuCriarModel

import java.sql.Connection
import java.sql.ResultSet

class VagaService {
    Connection conn

    VagaService(Connection connection) {
        this.conn = connection
    }

    VagaDAO service = new VagaDAO()
    Scanner input = new Scanner(System.in)

    boolean cadastrarVaga(Vaga vaga) {
       return service.cadastrarVaga(conn, vaga)
    }

    List<VagaDTO> listarVagas() {
        ResultSet result = service.listarVagas(conn)
        List<VagaDTO> vagas = new ArrayList<>()

        while (result.next()) {
            VagaDTO vaga = new VagaDTO(id: result.getInt("id"),company: result.getString("company"),name: result.getString("name"),description: result.getString("description"),city: result.getString("city"),state: result.getString("state"),competencias: result.getString("string_agg"))
            vagas.add(vaga)
        }

        return vagas
    }

    boolean atualizarVaga(Vaga vaga, Integer id) {
        return service.atualizarVaga(conn, vaga, id)
    }

    boolean deletarVaga(Integer id) {
       return service.deletarVaga(conn, id)
    }
}
