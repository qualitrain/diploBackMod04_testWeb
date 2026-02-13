package mx.com.qtx.diploBackMod04_testWeb.web.b01_demoCookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/conversar")
public class ConversacionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] galletas = req.getCookies();
        if(galletas == null){
            galletas = new Cookie[0];
        }

        String idGenerado = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<String> lstGalletasConId = List.of(galletas).stream()
                .filter(g -> g.getName().equals("idConversacion"))
                .map(g -> g.getValue())
                .toList();


        if(lstGalletasConId.size() == 0) {
            idGenerado = "" + (long) (Math.random() * 100000);
            System.out.println("No había galleta de idConversacion y se ha creado");
            response.addCookie(new Cookie("idConversacion", idGenerado));
            out.println("<h1>Se ha regresado una galleta que vale " + idGenerado +
                    "</h1>");
        }
        else{
            String galletaValor = lstGalletasConId.get(0);
            System.out.println("galletaValor = " + galletaValor);
            out.println("<h2>Se ha leído una galleta que vale " + galletaValor +
                    "</h2>");
        }

        out.println("<p>Servlet funcionando correctamente</p>");
    }
}

