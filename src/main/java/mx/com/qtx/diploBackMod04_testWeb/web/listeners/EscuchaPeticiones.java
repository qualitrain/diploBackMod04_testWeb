package mx.com.qtx.diploBackMod04_testWeb.web.listeners;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class EscuchaPeticiones implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("EscuchaPeticiones.requestInitialized"+ "-".repeat(30));
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String verboHttp = req.getMethod();
        String url = req.getRequestURL() + "?" + req.getQueryString();
        System.out.println(verboHttp + " " + url);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("EscuchaPeticiones.requestDestroyed" + "-".repeat(30));
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String verboHttp = req.getMethod();
        String url = req.getRequestURL() + "?" + req.getQueryString();
        System.out.println(verboHttp + " " + url);
    }
}
