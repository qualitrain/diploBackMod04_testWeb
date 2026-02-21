package mx.com.qtx.diploBackMod04_testWeb.web.f01_app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.qtx.diploBackMod04_testWeb.entidades.Persona;
import mx.com.qtx.diploBackMod04_testWeb.servicios.IGestorBD;
import mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones;

import java.io.IOException;
import java.util.List;

@WebServlet("/personas")
public class PersonasControllerServlet extends HttpServlet {
    private RequestDispatcher rdVistaCrudPersona;
    private RequestDispatcher rdVistaConsultaPersona;
    private RequestDispatcher rdVistaDespliegaPersonas;
    private IGestorBD gestorBD;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctxApp = this.getServletContext();
        this.rdVistaCrudPersona = ctxApp.getRequestDispatcher("/iuCrudPersonas.jsp");
        this.rdVistaConsultaPersona = ctxApp.getRequestDispatcher("/iuConsultaPersona.jsp");
        this.rdVistaDespliegaPersonas = ctxApp.getRequestDispatcher("/iuListaPersonas.jsp");

        this.gestorBD = (IGestorBD) ctxApp.getAttribute("gestorBD");
//        UtilWeb.mostrarAtributosCtx(ctxApp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExploradorPeticiones.mostraParametrosPeticion(req);
        this.rdVistaConsultaPersona.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        ExploradorPeticiones.mostraParametrosPeticion(req);

        String accion = req.getParameter("accion");
        if(accion.equalsIgnoreCase("getTodas")){
            List<Persona> personas = this.consultarPersonas();
            req.setAttribute("personas",personas);
            this.rdVistaDespliegaPersonas.forward(req,response);
            return;
        }
        if(accion.equalsIgnoreCase("back")){
            this.rdVistaConsultaPersona.forward(req,response);
            return;
        }
        if(accion.equalsIgnoreCase("get")) {
            int idPersona = this.getIdPersona(req);
            if (idPersona == -1) {
                //ToDo Dirigir a vista de error
                System.out.println("Parametro del id de la persona es equivocado: ");
                return;
            }
            Persona persona = this.consultarPersona(idPersona);
            if (persona == null) {
                //ToDo Dirigir a vista de error
                System.out.println("No hay persona con id= " + idPersona);
                return;
            }
            //Dirigir a vista de CRUD
//        System.out.println("persona = " + persona);
            req.setAttribute("persona", persona);
            this.rdVistaCrudPersona.forward(req, response);
        }
    }

    private List<Persona> consultarPersonas() {
        try{
            return this.gestorBD.getPersonasTodas();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private Persona consultarPersona(int idPersona) {
        try {
            Persona persona = this.gestorBD.leerPersonaXID(idPersona);
            return persona;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private int getIdPersona(HttpServletRequest req) {
        int idPersona = 0;
        try {
            idPersona = Integer.parseInt(req.getParameter("id"));
            return idPersona;
        }
        catch(Exception ex){
            return -1;
        }
    }
}

