<!doctype html>
<html>
<head>
    <gvisualization:apiImport/>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div class="container">
        <div class="col col-md-8 col-md-offset-2">
            <br>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>Contactos por Categoria</h1>
                </div>
                <div class="panel-body">
                    <gvisualization:pieCoreChart elementId="piechart"
                                                 columns="${col}"
                                                 data="${data}" />
                    <div id="piechart"></div>
                </div>
            </div>
        </div>
    </div>
    <script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>
