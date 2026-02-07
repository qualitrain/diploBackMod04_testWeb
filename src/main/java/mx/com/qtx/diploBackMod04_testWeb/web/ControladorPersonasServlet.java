package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/personas")
public class ControladorPersonasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Tomcat 10.1 - Jakarta EE 10</h1>");
        out.println("<p>Respuesta a GET " + req.getContextPath() + req.getRequestURI() +
                "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExploradorPeticiones.mostrarCabecerasHttpConValores(req);
        ExploradorPeticiones.mostraParametrosPeticion(req);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Tomcat 10.1 - Jakarta EE 10</h1>");
        out.println("<p>Respuesta a POST " + req.getRequestURI() +
                "</p>");
        out.println("<a href='./formularioPersonas.html'>Regresar " +
                "</a>");
    }
}

