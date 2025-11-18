package service

import DTO.CompetenciaDTO
import model.Competencia
import DAO.CompetenciaDAO

import java.sql.Connection
import java.sql.ResultSet

class CompetenciaService {
    Connection conn

    CompetenciaService(Connection connection) {
        this.conn = connection
    }

    CompetenciaDAO service = new CompetenciaDAO()

    boolean cadastrarCompetencia(Competencia competencia) {
        return service.cadastrarCompetencia(conn, competencia)
    }

    List<CompetenciaDTO> listarCompetencia() {
        ResultSet result = service.listarCompetencias(conn)
        List<CompetenciaDTO> competencias = new ArrayList<>()

        while (result.next()) {
            CompetenciaDTO competencia = new CompetenciaDTO(id: result.getInt("id"), skill: result.getString("skill"))
            competencias.add(competencia)
        }

        return competencias
    }

    boolean atualizarCompetencia(Competencia competencia, Integer id) {
         return service.atualizarCompetencia(conn, competencia, id)
    }

    boolean deletarCompetencia(Integer id) {
         return service.deletarCompetencia(conn, id)
    }
}
