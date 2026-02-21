<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar Personas - Servidor</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<div class="container">
    <!-- SECCIÓN Búsqueda de Persona -->
    <div class="section">
        <h2>🔍 Buscar Persona por ID</h2>

        <!-- Formulario para búsqueda (GET) -->
        <form method="GET" action="./personas" id="searchForm">
            <input type="hidden" name="accion" id="accion" value="get">
            <div class="form-group">
                <label for="searchId">ID de Persona:</label>
                <input type="number" id="searchId" name="id"
                       min="1" placeholder="Ingrese el ID a buscar" required>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn-search">
                    Buscar Persona
                </button>

                <button type="submit" class="btn-clear"
                       onclick="document.getElementById('accion').value='getTodas';document.getElementById('searchId').required=false">
                    Ver Todas las Personas
                </button>
            </div>
        </form>
    </div>

</div>

<!-- Mínimo JavaScript necesario -->
<script>
    // Función para limpiar el formulario
    function clearForm() {
        document.getElementById('personaForm').reset();
        document.getElementById('idPersona').value = '';
        document.getElementById('action').value = 'create';
    }
</script>
</body>
</html>