package mx.com.qtx.diploBackMod04_testWeb.web.demosHttp;

import jakarta.servlet.RequestDispatcher;
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
        RequestDispatcher despachadorPeticiones = req.getRequestDispatcher("/patinio");
        req.setAttribute("numPeticion", this.nPeticion);
  //        despachadorPeticiones.forward(req,response);
 //         despachadorPeticiones.include(req,response);

        String rutaCtx = req.getContextPath();
        response.sendRedirect(rutaCtx + "/patinio");
        System.out.println("<p>He regresado al servlet invocador");
        out.println("Ya concluyo invocación del Servlet Subordinado y tenemos un atributo nuevo:"
                + req.getAttribute("cuadrado") + "</p>");

    }
}

