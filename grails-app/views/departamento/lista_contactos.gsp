<%@ page import="web2p6.Departamento; web2p6.Contacto; web2p6.PertenenciaDepartamento" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main" />
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <title>Form</title>
</head>
<body>

<div class="container" id="contenedorCrearUsuario">
    <div class = "col col-md-6 col-md-offset-3">
        <br>
        <br>
        <g:if test="${departamento}">
            <div class = "panel panel-default">
                <div class = "panel-heading">
                    <h1>Listado de contactos de <b>${departamento.nombre}</b>:</h1>
                </div>
                <div class = "panel-body">
                    <table class="table table-hover">
                        <thead>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Movil</th>
                        </thead>
                        <tbody>
                            <g:each in="${relaciones}" var="relacion">
                                <tr>
                                    <td>${relacion.contacto.nombre}</td>
                                    <td>${relacion.contacto.apellido}</td>
                                    <td>${relacion.contacto.email}</td>
                                    <td>${relacion.contacto.telefonoMovil}</td>
                                </tr>
                            </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </g:if>
        <g:else>
            <span class="alert alert-danger">
                No hay un departamento con ese identificador
            </span>
        </g:else>
    </div>

</div>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>