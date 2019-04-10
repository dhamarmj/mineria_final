<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Mineria</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../dashboard.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Minería de Datos </a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
        </li>
    </ul>
</nav>
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="/">
                            <#--<span data-feather="home"></span>-->
                            Inicio <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">Inicio</h1>
            </div>
            <canvas class="my-4" id="chart" width="900" height="380"></canvas>
            <br>
            <br>
            <#--<canvas class="my-4" id="humedad" width="900" height="380"></canvas>-->
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<#--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"-->
        <#--integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"-->
        <#--crossorigin="anonymous"></script>-->
<#--<script src="../js/bootstrap.min.js"></script>-->
<script src="../js/jquery.js"></script>
<script src="../echarts.min.js"></script>
<script src="../js/mainController.js"></script>
<#--<script>-->
<#--feather.replace()-->


</body>
</html>
