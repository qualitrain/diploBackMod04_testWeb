package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones.*;

@WebServlet("/explorarHttp")
public class ExploradorPeticionesServlet extends HttpServlet {

    private long nPeticiones = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        mostrarCabecerasHttpConValores(req);
        mostrarDatosAgente(req);
        mostrarDatosServidor(req);

        System.out.println("\n--- Explorando el contexto de la Aplicación ---");
        ServletContext ctx = req.getServletContext();
        System.out.println("ctx.getClass().getName() = " + ctx.getClass().getName());
        System.out.println("\nRecursos de la aplicacion:");
        mostrarTodoslosRecursos(ctx);
        mostrarServletsRegistrados(ctx);

        String nomArcProps = "miApp.properties";
        final Properties props = getProperties(ctx, nomArcProps);

        System.out.println("\n" + "-".repeat(15) + "Propiedades " + "-".repeat(15));
        props.stringPropertyNames()
                .forEach(propI->System.out.printf("%15s : %s%n",propI, props.getProperty(propI)));
        System.out.println("-".repeat(42));

        mostraParametrosPeticion(req);

        resp.setContentType("text/html");
        PrintWriter cuerpoRespuesta = resp.getWriter();
        cuerpoRespuesta.append("<h2>Peticion " + ++this.nPeticiones +
                " recibida por Servidor</h2>");

    }

    public static void mostraParametrosPeticion(HttpServletRequest req) {
        Enumeration<String> nombresParametros = req.getParameterNames();
        System.out.println("\n---- Parámetros en la Petición -----");
        System.out.println("req.getQueryString() = " + req.getQueryString());
        while(nombresParametros.hasMoreElements()){
            String nombreI = nombresParametros.nextElement();
            System.out.printf("%20s : %s%n", nombreI, req.getParameter(nombreI));
        }
    }

    private static Properties getProperties(ServletContext ctx, String nomArcProps) throws IOException {
        Properties props = new Properties();
        props.load(ctx.getResourceAsStream("/WEB-INF/classes/" + nomArcProps));
        return props;
    }


}

