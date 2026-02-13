package mx.com.qtx.diploBackMod04_testWeb.web.a01_demosHttp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/patinio")
public class PatinioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Servlet Subordinado</h1>");
        out.println("<p>Y funcionando correctamente</p>");
        long nPeticion = (long) req.getAttribute("numPeticion");
        out.println("<p>He recibido estos datos:" + nPeticion + "</p>");
        req.setAttribute("cuadrado", nPeticion * nPeticion);
    }
}

