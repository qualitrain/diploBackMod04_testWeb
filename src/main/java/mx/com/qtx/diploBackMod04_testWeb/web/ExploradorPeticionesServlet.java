package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones.*;

@WebServlet("/explorarHttp")
public class ExploradorPeticionesServlet extends HttpServlet {
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

    }

    private static Properties getProperties(ServletContext ctx, String nomArcProps) throws IOException {
        Properties props = new Properties();
        props.load(ctx.getResourceAsStream("/WEB-INF/classes/" + nomArcProps));
        return props;
    }


}

