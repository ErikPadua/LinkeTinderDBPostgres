package repository

import model.Empresa

import java.time.LocalDate

class EmpresaRepository {
    String cadastra(Empresa empresa) {
        return """
            INSERT INTO company 
            (name, cnpj, email, description, country, cep, password, createat, updateat) 
            VALUES (
            '${empresa.name}',
            '${empresa.cnpj}',
            '${empresa.email}',
            '${empresa.description}',
            '${empresa.country}',
            '${empresa.cep}',
            '${empresa.password}',
            '${java.sql.Date.valueOf(LocalDate.now())}',
            '${java.sql.Date.valueOf(LocalDate.now())}')
            """
    }
    String listar() {
        return """
            SELECT id, name, cnpj, email, description, country, cep 
            FROM company 
            ORDER BY id
            """
    }
    String atualizar(Empresa empresa, Integer id) {
        return """
            UPDATE company SET 
            name = '${empresa.name}', 
            cnpj = '${empresa.cnpj}', 
            email = '${empresa.email}', 
            description = '${empresa.description}', 
            country = '${empresa.country}', 
            cep = '${empresa.cep}', 
            password = '${empresa.password}', 
            updateat = '${java.sql.Date.valueOf(LocalDate.now())}' 
            WHERE id = '${id}'
            """
    }
    String deletar(Integer id) {
        return """
            DELETE FROM company 
            WHERE id = '${id}'
            """
    }
}
