package util

import model.Candidato

import java.time.LocalDate

class CandidatoQueryUtil  {

    String cadastrar(Candidato candidato) {
        return """
            INSERT INTO candidate 
            (name, surname, date_of_birth, email, cpf, country, cep, description, password, createat, updateat) 
            VALUES (
            '${candidato.name}',
            '${candidato.surname}',
            '${candidato.date_of_birth}',
            '${candidato.email}',
            '${candidato.cpf}',
            '${candidato.country}',
            '${candidato.cep}',
            '${candidato.description}',
            '${candidato.password}',
            '${java.sql.Date.valueOf(LocalDate.now())}',
            '${java.sql.Date.valueOf(LocalDate.now())}'
            )
            """
    }

    String listar() {
        return """
            SELECT c.id,c.date_of_birth,c.email,c.description,c.country, STRING_AGG(cp.skill, ', ') 
            FROM candidate c 
            LEFT JOIN candidate_competence cc ON c.id = cc.id_candidate 
            LEFT JOIN competence cp ON cc.id_competence = cp.id 
            GROUP BY c.id ORDER BY c.id
            """
    }

    String atualizar(Candidato candidato, Integer id) {
        return """
            UPDATE candidate SET  
            name = '${candidato.name}', 
            surname = '${candidato.surname}', 
            date_of_birth = '${candidato.date_of_birth}', 
            email = '${candidato.email}',
            cpf = '${candidato.cpf}', 
            country = '${candidato.country}', 
            cep = '${candidato.cep}', 
            description = '${candidato.description}', 
            password = '${candidato.password}', 
            updateat = '${java.sql.Date.valueOf(LocalDate.now())}'
            WHERE id = '${id}'
            """
    }

    String deletar(Integer id) {
        return """
            DELETE FROM candidate 
            WHERE id = '${id}'
            """
    }
}
