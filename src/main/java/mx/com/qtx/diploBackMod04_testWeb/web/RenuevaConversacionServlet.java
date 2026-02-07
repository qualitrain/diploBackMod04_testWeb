package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/olvidar")
public class RenuevaConversacionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        final List<String> lstGalletasConId = getListaValsGalletasDeId(req);

        String idGenerado = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        if(lstGalletasConId.size() == 0) {
            System.out.println("No había galleta de idConversacion");
        }
        else{
            String galletaValor = lstGalletasConId.get(0);
            eliminarGalletaId(response);
            System.out.println("galletaValor = " + galletaValor);
            out.println("<h2>Se ha leído y borrado una galleta que valía " + galletaValor +
                    "</h2>");
        }

        out.println("<p>Servlet funcionando correctamente</p>");
    }

    private static void eliminarGalletaId(HttpServletResponse response) {
        Cookie galletaXeliminar = new Cookie("idConversacion","");
        galletaXeliminar.setMaxAge(0);
        response.addCookie(galletaXeliminar);
    }

    private static List<String> getListaValsGalletasDeId(HttpServletRequest req) {
        final Cookie[] arrGalletas = getArrCookies(req);
        List<String> lstGalletasConId = List.of(arrGalletas).stream()
                .filter(g -> g.getName().equals("idConversacion"))
                .map(g -> g.getValue())
                .toList();
        return lstGalletasConId;
    }

    private static Cookie[] getArrCookies(HttpServletRequest req) {
        Cookie[] arrGalletas = req.getCookies();
        if(arrGalletas == null){
            arrGalletas = new Cookie[0];
        }
        return arrGalletas;
    }
}

