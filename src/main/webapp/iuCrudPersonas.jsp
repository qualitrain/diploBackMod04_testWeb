<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD Personas - Servidor</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<div class="container">
    <!-- SECCIÓN 1: Formulario CRUD Principal -->
    <div class="section">
        <h2>📝 Formulario de Persona</h2>

        <!-- Formulario para CREATE/UPDATE/DELETE -->
        <form method="POST" action="./personas" id="personaForm">
            <!-- Campo oculto para determinar la acción -->
            <input type="hidden" name="accion" id="accion" value="create">

            <div class="form-group">
                <label for="idPersona">ID Persona:</label>
                <input type="number" id="idPersona" name="idPersona" min="1"
                       placeholder="Ingrese el id de la persona"
                       value="${persona.idPersona}">
            </div>

            <div class="form-group">
                <label for="nombre">Nombre *</label>
                <input type="text" id="nombre" name="nombre"

                       placeholder="Ingrese el nombre (máx. 40 caracteres)"
                       value="${persona.nombre}">
            </div>

            <div class="form-group">
                <label for="direccion">Dirección</label>
                <input type="text" id="direccion" name="direccion"
                       maxlength="45"
                       placeholder="Ingrese la dirección (máx. 45 caracteres)"
                       value="${persona.direccion}">
            </div>

            <div class="form-group">
                <label for="fechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" id="fechaNacimiento" name="fechaNacimiento"
                value="${persona.fechaNacimiento}">
            </div>

            <div class="form-actions">

                <button type="submit" class="btn-update"
                        onclick="document.getElementById('accion').value='update'">
                    Actualizar Persona
                </button>

                <button type="submit" class="btn-delete"
                        onclick="document.getElementById('accion').value='delete'">
                    Eliminar Persona
                </button>

                <button type="button" class="btn-clear" onclick="clearForm()">
                    Limpiar Formulario
                </button>

                <button type="submit" class="btn-back"
                                       onclick="document.getElementById('accion').value='back'">
                    Regresar
                </button>
            </div>
        </form>
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