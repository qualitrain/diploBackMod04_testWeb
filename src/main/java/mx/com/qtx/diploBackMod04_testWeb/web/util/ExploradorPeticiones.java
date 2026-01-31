package mx.com.qtx.diploBackMod04_testWeb.web.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ExploradorPeticiones {
    public static void mostrarCabecerasHttpConValores(HttpServletRequest req) {
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
}
