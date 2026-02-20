package mx.com.qtx.diploBackMod04_testWeb.web.c01_ruteoYctxs;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/navega")
public class RuteadorServlet extends HttpServlet {
    private RequestDispatcher despachador;
    private RequestDispatcher despachadorJsp;

    @Override
    public void init() throws ServletException {
        super.init();
        this.despachador = this.getServletContext().getRequestDispatcher("/destino1");
        this.despachadorJsp = this.getServletContext().getRequestDispatcher("/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        String paramDestino = req.getParameter("destino");
        paramDestino = paramDestino == null ? "" : paramDestino;

        switch(paramDestino) {
            case "forward" -> {
                req.setAttribute("operacion","forward = delegacion del procesamiento a otro servlet ");
                this.despachador.forward(req,response);
            }
            case "include" -> {
                req.setAttribute("operacion","include = integración del procesamiento de otro servlet");
                this.despachador.include(req,response);
            }
            case "redirect" -> {
                HttpSession sesion = req.getSession(true);
                sesion.setAttribute("operacion","redirect = aviso al navegador de que re-envíe la petición a otro componente");
//                this.getServletContext().setAttribute("operacion","redirect = aviso al navegador de que re-envíe la petición a otro componente");
//                req.setAttribute("operacion","redirect = aviso al navegador de que re-envíe la petición a otro componente");
                response.sendRedirect("./destino1");
            }
            case "jsp" -> {
                req.setAttribute("operacion","forward = delegacion del procesamiento a un Jsp ");
                this.despachadorJsp.forward(req,response);
            }
            case "jspInclude" -> {
                req.setAttribute("operacion","include = integración del procesamiento de otro servlet ");
                this.despachadorJsp.include(req,response);
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Pagina origen</h1>");
        out.println("<a href='./navega?destino=forward'>Ir a destino1 (forward)</a><br>");
        out.println("<a href='./navega?destino=include'>Ir a destino1 (include)</a><br>");
        out.println("<a href='./navega?destino=redirect'>Ir a destino1 (redirect)</a><br>");
        out.println("<a href='./navega?destino=jsp'>Ir al jsp (forward)</a><br>");
        out.println("<a href='./navega?destino=jspInclude'>Ir al jsp (include)</a><br>");
    }
}

