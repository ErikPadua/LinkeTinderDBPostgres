package controller

import com.google.gson.Gson
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import model.Competencia
import service.CompetenciaService
import util.ErrorClass

class CompetenciaController extends HttpServlet {
    CompetenciaService service


    CompetenciaController(CompetenciaService service) {
        this.service = service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        String json = new Gson().toJson(service.listarCompetencia())
        resp.writer.println(json)
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
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

            String skill = body.get("skill")

            if (!skill) throw new Exception()

            Competencia competencia = new Competencia(skill: skill)

            if (!service.atualizarCompetencia(competencia, id)) throw new Exception()

            resp.setStatus(200)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao atualizar competencia"))
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

            String skill = body.get("skill")

            if (!skill) throw new Exception()

            Competencia competencia = new Competencia(skill: skill)

            if (!service.cadastrarCompetencia(competencia)) throw new Exception()

            resp.setStatus(201)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao cadastrar competencia"))
            resp.writer.println(json)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")

        try {
            String path = req.getPathInfo()
            Integer id = path?.substring(1)?.toInteger()
            if (!service.deletarCompetencia(id)) throw new Exception()

            resp.setStatus(200)
            resp.writer.println("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao deletar competencia"))
            resp.writer.println(json)
        }

    }
}
