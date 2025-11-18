package controller

import com.google.gson.Gson
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import model.Candidato

import java.time.format.DateTimeFormatter
import java.time.*
import model.Competencia
import service.CandidatoService
import util.ErrorClass


class CandidatoController extends HttpServlet {
    CandidatoService service

    CandidatoController(CandidatoService service) {
        this.service = service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        try {
            String json = new Gson().toJson(service.listarcandidatos())
            resp.writer.println(json)
        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao listar candidatos"))
            resp.writer.println(json)
        }

    }

    @Override
    void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("UTF-8")

        try {
            BufferedReader reader = req.getReader()
            StringBuilder sb = new StringBuilder()
            String line

            while ((line = reader.readLine()) != null) {
                sb.append(line)
            }

            String jsonBody = sb.toString()

            Gson gson = new Gson()
            Map body = gson.fromJson(jsonBody, Map)

            String name = body.get("name")
            if (!name) throw new Exception()

            String surname = body.get("surname")
            if (!surname) throw new Exception()

            String date_of_birth = body.get("date_of_birth")
            if (!date_of_birth) throw new Exception()

            String email = body.get("email")
            if (!email) throw new Exception()

            String cpf = body.get("cpf")
            if (!cpf) throw new Exception()

            String country = body.get("country")
            if (!country) throw new Exception()

            String cep = body.get("cep")
            if (!cep) throw new Exception()

            String description = body.get("description")
            if (!description) throw new Exception()

            String password = body.get("password")
            if (!password) throw new Exception()

            LocalDate localDate = LocalDate.parse(date_of_birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())

            Candidato candidato = new Candidato(name: name, surname: surname, date_of_birth: date, email: email, cpf: cpf, country: country, cep: cep, description: description, password: password)

            if (!service.cadastrarCandidato(candidato)) throw new Exception()

            resp.setStatus(201)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao cadastrar candidato"))
            resp.writer.println(json)
        }
    }

    @Override
    void doPut(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("UTF-8")

        try {
            String path = req.getPathInfo()
            Integer id = path?.substring(1)?.toInteger()

            BufferedReader reader = req.getReader()
            StringBuilder sb = new StringBuilder()
            String line

            while ((line = reader.readLine()) != null) {
                sb.append(line)
            }

            String jsonBody = sb.toString()

            Gson gson = new Gson()
            Map body = gson.fromJson(jsonBody, Map)

            String name = body.get("name")
            if (!name) throw new Exception()

            String surname = body.get("surname")
            if (!surname) throw new Exception()

            String date_of_birth = body.get("date_of_birth")
            if (!date_of_birth) throw new Exception()

            String email = body.get("email")
            if (!email) throw new Exception()

            String cpf = body.get("cpf")
            if (!cpf) throw new Exception()

            String country = body.get("country")
            if (!country) throw new Exception()

            String cep = body.get("cep")
            if (!cep) throw new Exception()

            String description = body.get("description")
            if (!description) throw new Exception()

            String password = body.get("password")
            if (!password) throw new Exception()

            LocalDate localDate = LocalDate.parse(date_of_birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())

            Candidato candidato = new Candidato(name: name, surname: surname, date_of_birth: date, email: email, cpf: cpf, country: country, cep: cep, description: description, password: password)

            if (!service.atualizarCandidato(candidato,id)) throw new Exception()

            resp.setStatus(200)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao atualizar candidato"))
            resp.writer.println(json)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")

        try {
            String path = req.getPathInfo()
            Integer id = path?.substring(1)?.toInteger()
            if (!service.deletarCandidato(id)) throw new Exception()

            resp.setStatus(200)
            resp.writer.println("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao deletar candidato"))
            resp.writer.println(json)
        }

    }
}
