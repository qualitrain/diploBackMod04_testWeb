package mx.com.qtx.diploBackMod04_testWeb.web.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones;

@WebListener
public class EscuchaContextoApp implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("EscuchaContextoApp.contextInitialized");
        ServletContext ctxApp = sce.getServletContext();
        ctxApp.setAttribute("gestorBD","NO disponible aún");
        ExploradorPeticiones.mostrarServletsRegistrados(ctxApp);
    }
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("EscuchaContextoApp.contextDestroyed");
        System.out.println("La última voluntad de esta App es que usted sea feliz");
    }
}
