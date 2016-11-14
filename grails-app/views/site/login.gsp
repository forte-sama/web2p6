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
                <h1>Log In Form:</h1>
            </div>
            <div class = "panel-body">
                <g:form controller="site" action="processLogin" method="post">
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Username:</label>
                            <g:textField class="form-control" name="email" />
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class = "col col-md-6 col-md-offset-3">
                            <label>Password:</label>
                            <g:passwordField class="form-control" name="password" />
                        </div>
                    </div>
                    <br>
                    <g:actionSubmit value="Log In" action="processLogin" class="btn btn-success btn-block btn-lg"/>
                </g:form>
                <br>
            </div>
        </div>
    </div>

</div>
<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>