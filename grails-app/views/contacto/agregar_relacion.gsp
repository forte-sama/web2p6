<%@ page import="web2p6.Departamento; web2p6.Contacto" %>
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
        <div class = "panel panel-default">
            <div class = "panel-heading">
                <h1>Agregar contacto a departamento:</h1>
            </div>
            <div class = "panel-body">
                <br>
                <g:if test="${flash.message}">
                    <div class="alert alert-success">
                        <b>${flash.message}</b>
                    </div>
                    <br>
                </g:if>
                <g:if test="${flash.error}">
                    <div class="alert alert-danger">
                        <b>${flash.error}</b>
                    </div>
                    <br>
                </g:if>
                <g:form controller="contacto" action="formAgregarRelacion">
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Departamento:</label>
                            <g:select class="form-control" name="departamento" from="${Departamento.list()}" optionValue="nombre" optionKey="id" />
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Contacto:</label>
                            <g:select class="form-control" name="contacto" from="${Contacto.list()}" value="nombre" optionValue="nombre" optionKey="id" />
                        </div>
                    </div>
                    <br>
                    <g:actionSubmit value="Agregar a Dept" action="formAgregarRelacion" class="btn btn-success btn-block btn-lg"/>
                </g:form>
                <br>
            </div>
        </div>
    </div>

</div>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>