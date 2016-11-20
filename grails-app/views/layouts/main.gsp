<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>App</title>
    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
    %{--<ul class="nav nav-pills navbar-inverse">--}%
    %{--</ul>--}%
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contacto <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/contacto">Home</a></li>
                        <li><a href="/contacto/create">Crear Contacto</a></li>
                        <li><a href="/contacto/agregar_relacion">Agregar un contacto a un departamento</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuario <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/usuario">Home</a></li>
                        <li><a href="/usuario/create">Crear Usuario</a></li>
                        <li><a href="/usuario/agregar_permiso">Agregar permiso a algun Usuario</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categoria <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/categoria">Home</a></li>
                        <li><a href="/categoria/create">Crear Categoria</a></li>
                        <li><a href="/categoria/grafico">Contactos por Categoria</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Departamento <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/departamento">Home</a></li>
                        <li><a href="/departamento/create">Crear Departamento</a></li>
                        <li><a href="/departamento/lista_contactos">Lista de Contactos</a></li>
                        <li><a href="/departamento/grafico">Contactos por Departamento</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/site/login">Login</a></li>
                <li><a href="/site/logout">Logout</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

    <g:layoutBody/>
    <asset:javascript src="application.js"/>
</body>
</html>
