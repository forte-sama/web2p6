<!doctype html>
<html>
<head>
    <gvisualization:apiImport/>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div class="container">
        <div class="col col-md-12">
            <br>
            <br>
            <div class="jumbotron">
                <h1>Practica 13: Grails</h1>
                <div class="alert alert-info">
                    <p>Cesar Garcia: 2011-0324</p>
                    <p>Frankie Garabito: 2012-0830</p>
                </div>
                <g:if test="${flash.redirectNoUserMessage}">
                    <div class="alert alert-danger">
                        <b>${"Redireccionado al index porque no tiene acceso al recurso solicitado"}</b>
                    </div>
                </g:if>
            </div>
        </div>
    </div>


</body>
</html>
