package mx.com.qtx.diploBackMod04_testWeb.web.g01_filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(value = "*.jsp",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE})
public class FiltroEstadisticoJsps implements Filter {

    private Map<String,Integer> mapUrlsVsnPeticiones;

    public FiltroEstadisticoJsps() {
        this.mapUrlsVsnPeticiones = new ConcurrentHashMap<>();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FiltroMonitoreoGral.init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FiltroEstadisticoJsps.doFilter");
        HttpServletRequest req = (HttpServletRequest) request;

        String uriI = req.getRequestURI();
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        System.out.println("uriI = " + uriI);

        Enumeration<String> atributos = req.getAttributeNames();
        System.out.println("\nAtributos en la peticion:");
        while(atributos.hasMoreElements()){
            String k = atributos.nextElement();
            System.out.printf("%30s:%s%n", k, req.getAttribute(k));
        }

        int nPeticionesJspI = this.mapUrlsVsnPeticiones.getOrDefault(uriI,0);
        nPeticionesJspI++;
        this.mapUrlsVsnPeticiones.put(uriI,nPeticionesJspI);

        chain.doFilter(request,response);
        
        System.out.println("DESPUES de contabilizar petición\n");
    }

    @Override
    public void destroy() {
        System.out.println("-".repeat(10) + " Tabla de peticiones por JSP " + "-".repeat(10));
        this.mapUrlsVsnPeticiones.forEach((k,v)->System.out.printf("%-40s : %d%n",k,v));
    }
}
