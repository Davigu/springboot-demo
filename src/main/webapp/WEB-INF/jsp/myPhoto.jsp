<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/30
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>星相册-我的照片</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div id="navbar"></div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center">

            <a class="btn" href="#"><h2>我的照片</h2></a>
            <div class="list-group posi" >
                <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-picture"></span> 全部照片</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-trash"></span> 回收站</a>
            </div>
            <div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                </div>
            </div>
        </div>
        <div class="container col-md-9" style="border-left:medium #DCD4D4 solid;">

            <div class="row float-right">
                <button class="btn btn-warning" >上传</button>
            </div>

            <div class="row" style="clear: both">


                <div class="panel col-md-12">
                    <div class="panel-heading">
                        <h4 class="panel-title">2019-3-17-19点59分</h4>
                        <h4 class="panel-title">上传到相册</h4>
                    </div>
                    <div class="panel-body">
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" >
                            </a>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" >
                            </a>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" >
                            </a>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" >
                            </a>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" >
                            </a>
                        </div>
                    </div>
                </div>
                <div class="panel col-md-12">
                    <div class="panel-heading">
                        <h4 class="panel-title">2019-3-17-20点10分</h4>
                        <h4 class="panel-title">上传到相册</h4>
                    </div>
                    <div class="panel-body">
                        <div class="col-xs-6 col-md-3"> <a href="#" class="thumbnail"> <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" > </a> </div>
                        <div class="col-xs-6 col-md-3"> <a href="#" class="thumbnail"> <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" > </a> </div>
                        <div class="col-xs-6 col-md-3"> <a href="#" class="thumbnail"> <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" > </a> </div>
                        <div class="col-xs-6 col-md-3"> <a href="#" class="thumbnail"> <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" > </a> </div>
                        <div class="col-xs-6 col-md-3"> <a href="#" class="thumbnail"> <img alt="100%x180" src="images/100X125.gif" style="height: 125px; width: 100%; display: block;" > </a> </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<hr>
<footer class="panel-footer text-center fixed-bottom blockquote-footer">梦雷出品，必属精品</footer>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/popper.min.js"></script>
<script>
    $("#navbar").load("navbar.html");
</script>

</body>
</html>
