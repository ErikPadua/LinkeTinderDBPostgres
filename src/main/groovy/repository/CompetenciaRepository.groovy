package repository

import model.Competencia

import java.time.LocalDate

class CompetenciaRepository {

    String cadastra(Competencia competencia) {
        return """
            INSERT INTO competence 
            (skill, createat, updateat) 
            VALUES (
            '${competencia.skill}',
            '${java.sql.Date.valueOf(LocalDate.now())}',
            '${java.sql.Date.valueOf(LocalDate.now())}')
            """
    }
    String listar() {
        return """
            SELECT id, skill 
            FROM competence 
            ORDER BY id
            """
    }
    String atualizar(Competencia competencia, Integer id) {
        return """
            UPDATE competence SET 
            skill = '${competencia.skill}',
            updateat = '${java.sql.Date.valueOf(LocalDate.now())}' 
            WHERE id = '${id}'
            """
    }
    String deletar(Integer id) {
        return """
            DELETE FROM competence 
            WHERE id = '${id}'
            """
    }
}
