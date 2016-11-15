<%@ page import="web2p6.Departamento; web2p6.Usuario" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns="http://www.w3.org/1999/html">
<head>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <title>Form</title>
</head>
<body>

<div class="container" id="contenedorCrearUsuario">
    <div class = "col col-md-6 col-md-offset-3">
        <br>
        <br>
        <div class = "panel panel-default">
            <div class = "panel-heading">
                <h1>Agregar permiso a departamentos:</h1>
            </div>
            <div class = "panel-body">
                <g:if test="${flash.message}">
                    <br>
                    <div class="alert alert-success">
                        <b>${flash.message}</b>
                    </div>
                    <br>
                    <br>
                </g:if>
                <g:else>
                    <br>
                    <g:if test="${flash.error}">
                        <siv class="alert alert-danger">
                            <b>${flash.error}</b>
                        </siv>
                    </g:if>
                    <br>
                    <br>
                </g:else>
                <g:form controller="usuario" action="formAgregarPermiso">
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Departamento:</label>
                            <g:select class="form-control" name="departamento" from="${Departamento.list()}" optionValue="nombre" optionKey="id" />
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Usuario a Registrar:</label>
                            <g:select class="form-control" name="usuario" from="${Usuario.list()}" value="nombre" optionValue="nombre" optionKey="id" />
                        </div>
                    </div>
                    <br>
                    <g:actionSubmit value="Dar Permiso" action="formAgregarPermiso" class="btn btn-success btn-block btn-lg"/>
                </g:form>
            </div>
        </div>
    </div>
</div>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>