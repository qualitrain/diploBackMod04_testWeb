package mx.com.qtx.diploBackMod04_testWeb.web.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.*;

public class ExploradorPeticiones {
    public static void mostrarCabecerasHttpConValores(HttpServletRequest req) {

        System.out.println("\nCabecerasHttp y Contenido");
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getContentLengthLong() = " + req.getContentLengthLong());
        System.out.println("req.getLocale() = " + req.getLocale());
        System.out.println("req.getLocales() = " + Collections.list(req.getLocales()));

        List<String> lstHeadersHttp = new ArrayList<>();
        Enumeration<String> enumCabecerasHttp = req.getHeaderNames();
        while(enumCabecerasHttp.hasMoreElements()){
            lstHeadersHttp.add(enumCabecerasHttp.nextElement());
        }
        lstHeadersHttp.stream()
                .sorted()
                .forEach(cabI->System.out.printf("-%20s : %s%n",cabI, req.getHeader(cabI)));
        System.out.println("n headers Http = " + lstHeadersHttp.size());
    }

    public static void mostrarDatosAgente(HttpServletRequest req) {
        // ============ INFORMACIÓN DE CLIENTE ============
        System.out.println("\nDatos Agente");
        System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr());
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("req.getRemotePort() = " + req.getRemotePort());
    }

    public static void mostrarDatosServidor(HttpServletRequest req) {
        System.out.println("\nDatos Servidor");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());
        System.out.println("req.getLocalName() = " + req.getLocalName());
        System.out.println("req.getLocalAddr() = " + req.getLocalAddr());
        System.out.println("req.getLocalPort() = " + req.getLocalPort());
        System.out.println("req.getScheme() = " + req.getScheme());
        System.out.println("req.getProtocol() = " + req.getProtocol());
        System.out.println("req.isSecure() = " + req.isSecure());
    }

    public static void mostrarTodoslosRecursos(ServletContext ctx) {
        mostrarRecursosRecursivamente(ctx,"/");
    }

    private static void mostrarRecursosRecursivamente(ServletContext ctx, String raiz) {
        Set<String> setRecursos = ctx.getResourcePaths(raiz);
        for(String recursoI:setRecursos){
            System.out.printf("     • %s%n", recursoI);
            if(recursoI.endsWith("/"))
                mostrarRecursosRecursivamente(ctx,recursoI);
        }

    }

    public static void mostrarServletsRegistrados(ServletContext ctx) {
        System.out.println("\n4. 🚀 SERVLETS REGISTRADOS");
        Map<String, ? extends ServletRegistration> servlets = ctx.getServletRegistrations();

        if (servlets == null || servlets.isEmpty()) {
            System.out.println("   No hay servlets registrados programáticamente");
            return;
        }

        servlets.forEach((nombreServlet, reg) -> {
            System.out.printf("   📌 %s%n", nombreServlet);
            System.out.printf("      Clase: %s%n", reg.getClassName());
            System.out.printf("      Mappings: %s%n", reg.getMappings());

        });
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

}
