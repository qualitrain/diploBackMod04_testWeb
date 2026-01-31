package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/otro")
public class OtroServlet extends HttpServlet {
    private long nPeticion = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Otro Servlet</h1>");
        out.println("<p>y también funcionando correctamente</p>");
        out.println("<h4>" + ++this.nPeticion +
                "</h4>");
    }
}

