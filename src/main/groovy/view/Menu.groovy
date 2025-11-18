package view

import service.CandidatoService
import service.CompetenciaService
import service.EmpresaService
import service.VagaService

import java.sql.Connection

class Menu {

    static void startMenu(Connection conn) {

        Integer escolha
        Scanner input = new Scanner(System.in)

        while (1) {
            menuInicial()
            escolha = Integer.parseInt(input.nextLine())

            if (escolha == 1) {
                while (1) {
                    menuEmpresa()
                    escolha = Integer.parseInt(input.nextLine())
                    EmpresaService controller = new EmpresaService(conn)

                    if (escolha == 1) controller.cadastrarEmpresa()
                    if (escolha == 2) controller.listarEmpresas()
                    if (escolha == 3) controller.atualizarEmpresa()
                    if (escolha == 4) controller.deletarEmpresa()
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 2) {
                while (1) {
                    menuCandidato()
                    escolha = Integer.parseInt(input.nextLine())
                    CandidatoService controller = new CandidatoService(conn)

                    if (escolha == 1) controller.cadastrarCandidato()
                    if (escolha == 2) controller.listarcandidatos()
                    if (escolha == 3) controller.atualizarCandidato()
                    if (escolha == 4) controller.deletarCandidato()
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 3) {
                while (1) {
                    menuVaga()
                    escolha = Integer.parseInt(input.nextLine())
                    VagaService controller = new VagaService(conn)

                    if (escolha == 1) controller.cadastrarVaga()
                    if (escolha == 2) controller.listarVagas()
                    if (escolha == 3) controller.atualizarVaga()
                    if (escolha == 4) controller.deletarVaga()
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 4) {
                while (1) {
                    menuCompetencia()
                    escolha = Integer.parseInt(input.nextLine())
                    CompetenciaService controller = new CompetenciaService(conn)

                    if (escolha == 1) controller.cadastrarCompetencia()
                    if (escolha == 2) controller.listarCompetencia()
                    if (escolha == 3) controller.atualizarCompetencia()
                    if (escolha == 4) controller.deletarCompetencia()
                    if (escolha == 5) break
                }
                escolha = 0
            }


            if (escolha == 5) break
        }
    }

    static void menuInicial() {
        println "\n\n\t\tLinkeTinder\n"
        println "\t1 - [Menu Empresa]"
        println "\t2 - [Menu Candidato]"
        println "\t3 - [Menu Vaga]"
        println "\t4 - [Menu Competência]"
        println "\n\t5 - [Sair]"
        print "\n\tSelecionar: "
    }

    static void menuEmpresa() {
        println "\n\n\t\tLinkeTinder Empresa\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuCandidato() {
        println "\n\n\t\tLinkeTinder Candidato\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuVaga() {
        println "\n\n\t\tLinkeTinder Vaga\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuCompetencia() {
        println "\n\n\t\tLinkeTinder Competência\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

}

