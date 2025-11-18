package controller

import com.google.gson.Gson
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import model.Empresa
import service.EmpresaService
import util.ErrorClass

class EmpresaController extends HttpServlet {
    EmpresaService service

    EmpresaController(EmpresaService service) {
        this.service = service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")
        try {
            String json = new Gson().toJson(service.listarEmpresas())
            resp.writer.println(json)
        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao listar empresa"))
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

            String cnpj = body.get("cnpj")
            if (!cnpj) throw new Exception()

            String email = body.get("email")
            if (!email) throw new Exception()

            String description = body.get("description")
            if (!description) throw new Exception()

            String country = body.get("country")
            if (!country) throw new Exception()

            String cep = body.get("cep")
            if (!cep) throw new Exception()

            String password = body.get("password")
            if (!password) throw new Exception()

            Empresa empresa = new Empresa(name: name, cnpj: cnpj, email: email, description: description, country: country, cep: cep, password: password)

            if (!service.cadastrarEmpresa(empresa)) throw new Exception()

            resp.setStatus(201)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao cadastrar empresa"))
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

            String cnpj = body.get("cnpj")
            if (!cnpj) throw new Exception()

            String email = body.get("email")
            if (!email) throw new Exception()

            String description = body.get("description")
            if (!description) throw new Exception()

            String country = body.get("country")
            if (!country) throw new Exception()

            String cep = body.get("cep")
            if (!cep) throw new Exception()

            String password = body.get("password")
            if (!password) throw new Exception()

            Empresa empresa = new Empresa(name: name, cnpj: cnpj, email: email, description: description, country: country, cep: cep, password: password)

            if (!service.atualizarEmpresa(empresa,id)) throw new Exception()

            resp.setStatus(200)
            resp.getWriter().write("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao atualizar empresa"))
            resp.writer.println(json)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json")

        try {
            String path = req.getPathInfo()
            Integer id = path?.substring(1)?.toInteger()
            if (!service.deletarEmpresa(id)) throw new Exception()

            resp.setStatus(200)
            resp.writer.println("{}")

        } catch (Exception e) {
            resp.setStatus(400)
            String json = new Gson().toJson(new ErrorClass(status: 400, statusMessage: "Bad Request", message: "Falha ao deletar empresa"))
            resp.writer.println(json)
        }

    }

}
