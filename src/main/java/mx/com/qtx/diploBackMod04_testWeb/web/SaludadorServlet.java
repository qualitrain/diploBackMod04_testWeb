package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Currency;
import java.util.Locale;

@WebServlet("/saludar")
public class SaludadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        String fulano = "";

        String nombre = req.getParameter("nombre");
        if(nombre != null)
            fulano = nombre;

        String idiomaLocalidadPrimaria = req.getLocale()
                                            .getLanguage();

        System.out.println("idiomaLocalidadPrimaria = " + idiomaLocalidadPrimaria);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        switch(idiomaLocalidadPrimaria.toUpperCase()){
            case "EN" -> saludarEnIngles(out, fulano);
            case "ES" -> saludarEnEspanol(out, fulano);
            case "FR" -> saludarEnFrances(out, fulano);
        }

        explorarLocalidad(Locale.FRANCE);
        explorarLocalidad(Locale.US);
        explorarLocalidad(Locale.of("es","MX"));
    }

    private static void explorarLocalidad(Locale localidad) {
        System.out.println("\n----- Datos localidad geográfica internacional -----");
        System.out.println("localidad.getLanguage() = " + localidad.getLanguage());
        System.out.println("localidad.getCountry() = " + localidad.getCountry());
        System.out.println("localidad.getDisplayCountry() = " + localidad.getDisplayCountry());
        System.out.println("localidad.getDisplayLanguage() = " + localidad.getDisplayLanguage());
        System.out.println("localidad.getDisplayName() = " + localidad.getDisplayName());

        // Obtener la moneda para el locale
        Currency currency = Currency.getInstance(localidad);

        // Obtener información de la moneda
        String codigoMoneda = currency.getCurrencyCode();
        String simbolo = currency.getSymbol(localidad);
        String nombreMoneda = currency.getDisplayName(localidad);

        System.out.println("Locale: " + localidad.toString());
        System.out.println("  Código: " + codigoMoneda);
        System.out.println("  Símbolo: " + simbolo);
        System.out.println("  Nombre: " + nombreMoneda);
        System.out.println();
    }

    private static void saludarEnEspanol(PrintWriter out, String fulano) {
        out.println("<h1>Hola " + fulano +
                " !</h1>");
    }
    private static void saludarEnIngles(PrintWriter out, String fulano) {
        out.println("<h1>Hello " + fulano +
                " !</h1>");
     }
    private static void saludarEnFrances(PrintWriter out, String fulano) {
        out.println("<h1>Bonjour " + fulano +
                " !</h1>");
     }
}

