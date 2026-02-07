package mx.com.qtx.diploBackMod04_testWeb.web;

import mx.com.qtx.diploBackMod04_testWeb.entidades.Persona;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IGestorBD {
    Connection getConexionBD() throws SQLException;
    List<Persona> getPersonasTodas() throws SQLException;
    int insertarPersona(Persona persona) throws SQLException;
    Persona leerPersonaXID(int id) throws SQLException;
}
