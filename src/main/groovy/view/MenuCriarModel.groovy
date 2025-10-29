package view

import model.Candidato
import model.Competencia
import model.Empresa
import model.Vaga

class MenuCriarModel {
    static Scanner input = new Scanner(System.in)

    static Candidato criarCandidato() {
        ArrayList<String> nomeDados = ["Nome", "Sobrenome", "Data de Nascimento (yyyy-mm-dd)", "Email", "CPF", "Pais", "CEP", "Descrição", "Senha"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\n\tInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        try {
            Candidato candidato = new Candidato(
                    name: dados[0],
                    surname: dados[1],
                    date_of_birth: java.sql.Date.valueOf(dados[2]),
                    email: dados[3],
                    cpf: dados[4],
                    country: dados[5],
                    cep: dados[6],
                    description: dados[7],
                    password: dados[8]
            )

            return candidato
        } catch (Exception e) {
            println "Erro ao criar Candidato"
        }
    }

    static Competencia criarCompetencia() {
        try {
            print "\n\tInsira o nome da competencia: "
            String habilidade = input.nextLine()
            Competencia competencia = new Competencia(skill: habilidade)
            return competencia
        } catch (Exception e) {
            println "Erro ao criar Competencia"
        }
    }

    static Empresa criarEmpresa() {
        try {
            ArrayList<String> nomeDados = ["Nome", "CNPJ", "Email", "Descrição", "Pais", "CEP", "Senha"]
            ArrayList<String> dados = new ArrayList<>()

            nomeDados.each { String nome ->
                printf("\n\tInsira o seu/sua %s: ", nome)
                dados.add(input.nextLine())
            }

            Empresa empresa = new Empresa(
                    name: dados[0],
                    cnpj: dados[1],
                    email: dados[2],
                    description: dados[3],
                    country: dados[4],
                    cep: dados[5],
                    password: dados[6]
            )

            return empresa
        } catch (Exception e) {
            println "Erro ao criar Empresa"
        }
    }

    static Vaga criarVaga() {
        try {
            print "\n\tInsira o ID da empresa: "
            Integer idEmpresa = Integer.parseInt(input.nextLine())

            ArrayList<String> nomeDados = ["Nome", "Descrição", "Estado", "Cidade"]
            ArrayList<String> dados = new ArrayList<>()

            nomeDados.each { String nome ->
                printf("\n\tInsira o/a %s: ", nome)
                dados.add(input.nextLine())
            }

            Vaga vaga = new Vaga(
                    name: dados[0],
                    description: dados[1],
                    state: dados[2],
                    city: dados[3],
                    id_company: idEmpresa
            )
            return vaga
        }
        catch (Exception e) {
            println "Erro ao criar Vaga"
        }
    }
}
