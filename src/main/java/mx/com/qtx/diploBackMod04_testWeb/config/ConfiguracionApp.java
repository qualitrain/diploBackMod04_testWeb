package mx.com.qtx.diploBackMod04_testWeb.config;

import mx.com.qtx.diploBackMod04_testWeb.persistencia.GestorBD_MySQL;
import mx.com.qtx.diploBackMod04_testWeb.web.IGestorBD;

public class ConfiguracionApp {
    public static IGestorBD getGestorBD(String cadCnx, String usuario, String pwd){
        return new GestorBD_MySQL(cadCnx,usuario,pwd);
    }
}
