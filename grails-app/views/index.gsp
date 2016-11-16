<!doctype html>
<html>
<head>
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
            </div>

            <div class="row">
                <%
                    def myDailyActivitiesColumns = [['string', 'Task'], ['number', 'Hours per Day']]
                    def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
                %>

                <gvisualization:pieCoreChart elementId="piechart" title="My Daily Activities" width="${450}" height="${300}"
                                             columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />
                <div id="piechart"></div>
                %{--<input type="button" value="Render Pie Chart"--}%
                       %{--onclick="${remoteFunction(controller:'departamento',action:'grafico',update:'chart')}">--}%
                %{--<br>--}%
                %{--<div id="chart"></div>--}%

                %{--<div id="piechart"></div>--}%
                %{--<gvisualization:pieCoreChart dynamicLoading="${true}" elementId="piechart" title="My Daily Activities"--}%
                                             %{--width="${450}" height="${300}" columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}"/>--}%
            </div>
        </div>
    </div>
</body>
</html>
