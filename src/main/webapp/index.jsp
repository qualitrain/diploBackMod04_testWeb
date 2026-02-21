<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>
    <head>
      <style>
      </style>
    </head>
<body>
<h2>Hola Ardillas!</h2>
<p>Se ha generado un servlet en:</p>
<p>
la clase que contesta esta petición es:<%=page.getClass().getName()%><br>
<code><%=page.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() %></code><br>
<code><%=request.getMethod() %></code><br>
<code><%=request.getRequestURL() %></code><br>

<br>
Datos de la sesion:<br>
Clase:<%=session.getClass().getName()%><br>
Id:<%=session.getId()%><br>
</p>
<h3>Operacion:<%=request.getAttribute("operacion")%></h3>
<h4>Operacion (con un placeholder en JSP EL): ${operacion} </h4>
<hr>
<h4>Mes 1 tiene ${meses["enero"]} dias</h4>
<h4>Tu día de suerte es ${lista[2]} </h4>
<a href="./navega">Ir al menú</a>
<hr>
<p> Probando jstl...
<ul>
<c:forEach items="${lista}" var="diaI">
    <li>${diaI}</li>
</c:forEach>
</ul>
</p>
</body>
</html>
