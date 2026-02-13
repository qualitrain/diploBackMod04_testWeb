package mx.com.qtx.diploBackMod04_testWeb.web.c01_ruteoYctxs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/destino1")
public class Destino01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = (String) req.getAttribute("operacion");
        operacion = operacion == null ? "No existe el atributo operacion" : operacion;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Destino 1</h1>");
        out.println("<a href='./navega'>Regresar</a><br>");

        out.println("<p><strong>operacion:</strong>");
        out.println(operacion + "</p>");
    }
}

