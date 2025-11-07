package util

import model.Vaga

import java.time.LocalDate

class VagaQueryUtil {
    String cadastra(Vaga vaga) {
        return """
            INSERT INTO vacancy 
            (name, description, state, city, id_company, createat, updateat) 
            VALUES 
            ('${vaga.name}',
            '${vaga.description}',
            '${vaga.state}',
            '${vaga.city}',
            '${vaga.id_company}',
            '${java.sql.Date.valueOf(LocalDate.now())}',
            '${java.sql.Date.valueOf(LocalDate.now())}')
            """
    }
    String listar() {
        return """
            SELECT co.name AS company, v.id,v.name,v.description,v.state,v.city, STRING_AGG(c.skill, ', ') 
            FROM vacancy v 
            LEFT JOIN vacancy_competence vc ON v.id = vc.id_vacancy  
            LEFT JOIN competence c ON vc.id_competence = c.id 
            LEFT JOIN company co ON co.id = v.id_company 
            GROUP BY v.id, co.name 
            ORDER BY v.id
            """
    }
    String atualizar(Vaga vaga, Integer id) {
        return """
            UPDATE vacancy SET 
            name = '${vaga.name}', 
            description = '${vaga.description}', 
            state = '${vaga.state}', 
            city = '${vaga.city}', 
            id_company = '${vaga.id_company}', 
            updateat = '${java.sql.Date.valueOf(LocalDate.now())}'
            WHERE id = '${id}'
            """
    }
    String deletar(Integer id) {
        return """
            DELETE FROM vacancy 
            WHERE id = '${id}'
            """
    }
}
