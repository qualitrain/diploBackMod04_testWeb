package mx.com.qtx.diploBackMod04_testWeb.web.f01_app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.diploBackMod04_testWeb.config.ConfiguracionApp;
import mx.com.qtx.diploBackMod04_testWeb.entidades.Persona;
import mx.com.qtx.diploBackMod04_testWeb.servicios.IGestorBD;
import mx.com.qtx.diploBackMod04_testWeb.web.util.UtilWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

//@WebServlet("/personas")
public class ControladorPersonasServlet extends HttpServlet {

    private IGestorBD gestorBD;

    public ControladorPersonasServlet(){
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el Driver de MySQL");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        cargarGestoBD();
    }

    private void cargarGestoBD() {
        Properties props = null;
        try {

            props = UtilWeb.getProperties(this.getServletContext(), "miApp.properties");
            this.gestorBD = ConfiguracionApp.getGestorBD(props.getProperty("urlBd"),
                                                         props.getProperty("userBd"),
                                                         props.getProperty("pswdBd"));
            if(this.gestorBD != null){
                System.out.println("Inicializacion exitosa de " + this.getServletName());
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Falló la carga de miApp.properties [" + e.getMessage() + "]",e);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Falló la inicialización del servlet " + this.getServletName() +
                    " [" + ex.getClass().getName() + ":" + ex.getMessage() + "]",ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Persona persona = null;

        try {
            int numPersona = Integer.parseInt(req.getParameter("id"));
            persona = this.gestorBD.leerPersonaXID(numPersona);
        }
        catch (SQLException e) {
            throw new RuntimeException("Falla lectura de Persona ["+ e.getMessage() + "]",e);
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + persona + "</h1>");
        out.println("<a href='./formularioPersonas.html'>Regresar </a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ExploradorPeticiones.mostrarCabecerasHttpConValores(req);
//        ExploradorPeticiones.mostraParametrosPeticion(req);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Tomcat 10.1 - Jakarta EE 10</h1>");
        out.println("<p>Respuesta a POST " + req.getRequestURI() + "</p>");

    }
}

