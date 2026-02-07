package mx.com.qtx.diploBackMod04_testWeb.web.demoCookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/contar")
public class ContadorPeticionesSesionServlet extends HttpServlet {
    
    Map<String,Long> mapPeticionesXSesion = new ConcurrentHashMap<>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        final Cookie[] arrGalletas = getCookiesPeticion(req);

        String id = "";

        final List<String> lstGalletasConId = getValoresDeGalletasConId(arrGalletas);


        if(lstGalletasConId.size() == 0) {
            id = generarNuevoIdConversacion();
            System.out.println("No había galleta de idConversacion y se ha creado");
            response.addCookie(new Cookie("idConversacion", id));
        }
        else{
            id = lstGalletasConId.get(0);
            System.out.println("galletaValor = " + id);
        }
        long nPeticiones = this.mapPeticionesXSesion.getOrDefault(id,0L) + 1;
        this.mapPeticionesXSesion.put(id,nPeticiones);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Petición actual: " + nPeticiones + "</h3>");
    }

    private static List<String> getValoresDeGalletasConId(Cookie[] arrGalletas) {
        List<String> lstGalletasConId = List.of(arrGalletas).stream()
                .filter(g -> g.getName().equals("idConversacion"))
                .map(g -> g.getValue())
                .toList();
        return lstGalletasConId;
    }

    private static String generarNuevoIdConversacion() {
        String idGenerado;
        idGenerado = "" + (long) (Math.random() * 100000);
        return idGenerado;
    }

    private static Cookie[] getCookiesPeticion(HttpServletRequest req) {
        Cookie[] galletas = req.getCookies();
        if(galletas == null){
            galletas = new Cookie[0];
        }
        return galletas;
    }
}

