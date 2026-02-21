package mx.com.qtx.diploBackMod04_testWeb.web.e01_listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import mx.com.qtx.diploBackMod04_testWeb.config.ConfiguracionApp;
import mx.com.qtx.diploBackMod04_testWeb.servicios.IGestorBD;
import mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones;
import mx.com.qtx.diploBackMod04_testWeb.web.util.UtilWeb;

import java.io.IOException;
import java.util.Properties;

@WebListener
public class EscuchaContextoApp implements ServletContextListener {
    public EscuchaContextoApp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el Driver de MySQL");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("EscuchaContextoApp.contextInitialized");
        ServletContext ctxApp = sce.getServletContext();

        inicializarYpublicarGestoBD(ctxApp);

        ExploradorPeticiones.mostrarServletsRegistrados(ctxApp);
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("EscuchaContextoApp.contextDestroyed");
        System.out.println("La última voluntad de esta App es que usted sea feliz");
    }

    private static void inicializarYpublicarGestoBD(ServletContext ctxApp) {
        Properties props = null;
        try {

            props = UtilWeb.getProperties(ctxApp, "miApp.properties");
            IGestorBD  gestorBD = ConfiguracionApp.getGestorBD(props.getProperty("urlBd"),
                    props.getProperty("userBd"),
                    props.getProperty("pswdBd"));
            if(gestorBD != null){
                System.out.println("Inicializacion exitosa de App " + ctxApp.getContextPath() );
                ctxApp.setAttribute("gestorBD", gestorBD);
            }
            else{
                throw new RuntimeException("Falló la inicializacion del getor de BD");
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Falló la carga de miApp.properties [" + e.getMessage() + "]",e);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Falló la inicialización de la App " + ctxApp.getContextPath() +
                    " [" + ex.getClass().getName() + ":" + ex.getMessage() + "]",ex);
        }
    }
}
