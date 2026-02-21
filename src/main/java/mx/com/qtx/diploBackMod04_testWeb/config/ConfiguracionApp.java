package mx.com.qtx.diploBackMod04_testWeb.config;

import mx.com.qtx.diploBackMod04_testWeb.persistencia.GestorBD_MySQL;
import mx.com.qtx.diploBackMod04_testWeb.servicios.GestorPersonas;
import mx.com.qtx.diploBackMod04_testWeb.servicios.IGestorBD;
import mx.com.qtx.diploBackMod04_testWeb.web.f01_app.IGestorPersonas;

public class ConfiguracionApp {
    public static IGestorBD getGestorBD(String cadCnx, String usuario, String pwd){
        return new GestorBD_MySQL(cadCnx,usuario,pwd);
    }
    public static IGestorPersonas getGestorPersonas(IGestorBD gestorBD){
        return new GestorPersonas(gestorBD);
    }
}
