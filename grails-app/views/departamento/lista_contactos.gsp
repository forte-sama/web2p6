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
        <g:if test="${relaciones && relaciones.size() > 0}">
            <g:each in="${relaciones}" var="relacion">
                <div class = "panel panel-default">
                    <div class = "panel-heading">
                        <h1>Contactos de <b>${relacion.key}</b>:</h1>
                    </div>
                    <div class = "panel-body">
                        <g:if test="${relacion.value.size() > 0}">
                        <table class="table table-hover">
                            <thead>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Movil</th>
                            </thead>
                            <tbody>
                                <g:each in="${relacion.value}" var="pd">
                                    <tr>
                                        <td>${pd.contacto.nombre} ${pd.contacto.apellido}</td>
                                        <td>${pd.contacto.email}</td>
                                        <td>${pd.contacto.telefonoMovil}</td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                        </g:if>
                        <g:else>
                        <div class="alert alert-info">
                            <p>Este departamento no tiene contactos todavia...</p>
                            <a href="/contacto/agregar_relacion" class="btn btn-success">Agregar uno</a>
                        </div>
                        </g:else>
                    </div>
                </div>
                <br>
            </g:each>
        </g:if>
        <g:else>
            <div class="alert alert-info">
                <p>Este usuario no tiene permiso a ningun departamento, o en los departamentos que puede no tienen contactos</p>
            </div>
        </g:else>
    </div>

</div>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>