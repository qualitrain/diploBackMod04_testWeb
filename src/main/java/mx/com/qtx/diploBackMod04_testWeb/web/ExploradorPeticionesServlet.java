package mx.com.qtx.diploBackMod04_testWeb.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static mx.com.qtx.diploBackMod04_testWeb.web.util.ExploradorPeticiones.*;

@WebServlet("/explorarHttp")
public class ExploradorPeticionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        mostrarCabecerasHttpConValores(req);
    }


}

