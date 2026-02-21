<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista Personas - Servidor</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<div class="container">
    <!-- SECCIÓN 3: Lista de Personas -->
    <div class="section">
        <h2>👥 Lista de Personas Registradas</h2>

        <!-- Tabla para mostrar resultados -->
        <table id="personasTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Dirección</th>
                <th>Fecha Nacimiento</th>
                <th class="actions-cell">Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${personas}" var="personaI">
            <!--
            Esta tabla se llenaría desde el servidor.
            Ejemplo de fila que generaría el servidor:
            -->

            <tr>
                <td>${personaI.idPersona}</td>
                <td>${personaI.nombre}</td>
                <td>${personaI.direccion}</td>
                <td>${personaI.fechaNacimiento}</td>
                <td class="actions-cell">
                    <form method="GET" action="/api/personas" style="display: inline;">
                        <input type="hidden" name="id" value="1">
                        <button type="submit" class="btn-select">Seleccionar</button>
                    </form>
                </td>
            </tr>

            </c:forEach>

            </tbody>
        </table>

        <!-- Formulario para cargar todas las personas -->
        <div style="margin-top: 20px;">
            <form method="GET" action="./personas">
            <!-- Campo oculto para determinar la acción -->
            <input type="hidden" name="accion" id="accion" value="back">
                <button type="submit" class="btn-back" >
                    Regresar
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>