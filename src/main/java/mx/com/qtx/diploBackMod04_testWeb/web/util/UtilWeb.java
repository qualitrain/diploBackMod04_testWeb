package mx.com.qtx.diploBackMod04_testWeb.web.util;

import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class UtilWeb {
    public static Properties getProperties(ServletContext ctx, String nomArcProps) throws IOException {
        Properties props = new Properties();
        props.load(ctx.getResourceAsStream("/WEB-INF/classes/" + nomArcProps));
        return props;
    }

    public static void mostrarAtributosCtx(ServletContext ctxApp) {
        Enumeration<String> nomAttribs = ctxApp.getAttributeNames();
        while(nomAttribs.hasMoreElements()){
            System.out.println("nomAttribs.nextElement() = " + nomAttribs.nextElement());
        }
    }
}
