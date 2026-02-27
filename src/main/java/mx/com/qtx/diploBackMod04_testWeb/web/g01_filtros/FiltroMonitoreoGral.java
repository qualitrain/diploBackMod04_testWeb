package mx.com.qtx.diploBackMod04_testWeb.web.g01_filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones;
import mx.com.qtx.diploBackMod04_testWeb.web.util.UtilWeb;

import java.io.IOException;

//@WebFilter("/*")
public class FiltroMonitoreoGral implements Filter {

    public FiltroMonitoreoGral() {
        System.out.println("FiltroMonitoreoGral.FiltroMonitoreoGral");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FiltroMonitoreoGral.init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FiltroMonitoreoGral.doFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("\nANTES de procesar petición");
        System.out.println("req.getMethod() = " + req.getMethod());
        System.out.println("req.getRequestURL()  = " + req.getRequestURL() + "?" + req.getQueryString());
        System.out.println("Thread.currentThread().threadId() = " + Thread.currentThread().threadId());
        if(req.getAttributeNames().hasMoreElements()){
            System.out.println("La peticion tiene atributos");
        }
        else{
            System.out.println("La peticion NO tiene atributos");
        }

        HttpServletRequestWrapper wrapperReq = new HttpServletRequestWrapper(req);
        chain.doFilter(wrapperReq,response);
        
        System.out.println("DESPUES de procesar petición\n");
        if(req.getAttributeNames().hasMoreElements()){
            System.out.println("La peticion tiene atributos");
        }
        else{
            System.out.println("La peticion NO tiene atributos");
        }

    }

    @Override
    public void destroy() {
        System.out.println("FiltroMonitoreoGral.destroy");
        Filter.super.destroy();
    }
}
