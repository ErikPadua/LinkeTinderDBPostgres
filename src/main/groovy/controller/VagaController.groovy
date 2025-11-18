package controller

import com.google.gson.Gson
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import model.Candidato
import model.Vaga
import service.VagaService
import util.ErrorClass

import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class VagaController extends HttpServlet {
    VagaService service

    VagaController(VagaService service){
        this.service = service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        try {
            String json = new Gson().toJson(service.listarVagas())
            resp.writer.println(json)
        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao listar vagas"))
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

            String description = body.get("description")
            if (!description) throw new Exception()

            String state = body.get("state")
            if (!state) throw new Exception()

            String city = body.get("city")
            if (!city) throw new Exception()

            String id_company = body.get("id_company")
            if (!id_company) throw new Exception()

            Vaga vaga = new Vaga(name: name, description: description, state: state, city: city, id_company: id_company.toInteger())

            if (!service.cadastrarVaga(vaga)) throw new Exception()

            resp.setStatus(201)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao cadastrar vaga"))
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

            String description = body.get("description")
            if (!description) throw new Exception()

            String state = body.get("state")
            if (!state) throw new Exception()

            String city = body.get("city")
            if (!city) throw new Exception()

            String id_company = body.get("id_company")
            if (!id_company) throw new Exception()

            Vaga vaga = new Vaga(name: name, description: description, state: state, city: city, id_company: id_company.toInteger())

            if (!service.atualizarVaga(vaga,id)) throw new Exception()

            resp.setStatus(200)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao atualizar vaga"))
            resp.writer.println(json)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")

        try {
            String path = req.getPathInfo()
            Integer id = path?.substring(1)?.toInteger()
            if (!service.deletarVaga(id)) throw new Exception()

            resp.setStatus(200)
            resp.writer.println("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao deletar vaga"))
            resp.writer.println(json)
        }

    }
}
