package mx.com.qtx.diploBackMod04_testWeb.web.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

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
}
