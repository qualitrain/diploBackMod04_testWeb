package mx.com.qtx.diploBackMod04_testWeb.web.d01_httpsession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/contarDeNuevo")
public class ContadorPeticionesHttpSesionServlet extends HttpServlet {
    private final static int MAX_INACTIVIDAD_SEG = 30;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        int nPeticiones = 0;
        HttpSession sesion = req.getSession(true);
        String mensaje ="";
        if(sesion.isNew()){
            mensaje = "Es una nueva Sesión con id = " +  sesion.getId();
            sesion.setMaxInactiveInterval(MAX_INACTIVIDAD_SEG);
            mensaje += " tiene una cuota de inactividad de " +
                        MAX_INACTIVIDAD_SEG + " segundos";
            nPeticiones = 1;
            sesion.setAttribute("nPeticiones",nPeticiones);
        }
        else{
            mensaje = "Es una sesión que ya conocía, su id = " + sesion.getId();
            if(sesion.getAttribute("nPeticiones")!=null){
                nPeticiones = (int)sesion.getAttribute("nPeticiones");
            }
            else{
                nPeticiones = 0;
            }
            nPeticiones++;
            sesion.setAttribute("nPeticiones",nPeticiones);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Petición actual: " + nPeticiones + "</h3>");
        out.println("<p>" + mensaje +
                "</p");
    }

}

