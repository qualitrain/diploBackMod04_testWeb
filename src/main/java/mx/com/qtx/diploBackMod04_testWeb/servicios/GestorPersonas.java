package mx.com.qtx.diploBackMod04_testWeb.servicios;

import mx.com.qtx.diploBackMod04_testWeb.entidades.Persona;
import mx.com.qtx.diploBackMod04_testWeb.web.f01_app.IGestorPersonas;

public class GestorPersonas implements IGestorPersonas {

    private IGestorBD gestorBD;

    public GestorPersonas(IGestorBD gestorBD) {
        this.gestorBD = gestorBD;
    }

    @Override
    public Persona getPersona(int id) {
        return null;
    }
}
