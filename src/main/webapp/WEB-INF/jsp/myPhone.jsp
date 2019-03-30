<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/30
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap eCommerce Page Template</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
    <div class="container">
        <img src="images/组 2134.png">
        <a class="navbar-brand" style="color: black" href="#">星相册</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" style="color: black" href="#"><span class="glyphicon glyphicon-plus"></span> 创建 </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" style="color: black" href="#"><span class="glyphicon glyphicon-cloud-upload"></span> 上传</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0 form-control-static float-right">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-primary my-2 my-sm-0" type="button"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="dropdown">
            <img  class="img-circle" alt="140x140" src="images/32X32.gif">
            <a class=" dropdown-toggle  btn" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                用户名
            </a>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
    </div>

</nav>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<hr>
<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center">

            <a class="btn" href="#"><h2>我的照片</h2></a>
            <div class="list-group posi" >
                <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-picture"></span> 我的照片</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a>
                <a href="#" class="list-group-item"><span class="glyphicon glyphicon-trash"></span> 回收站</a>
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
<footer class="panel-footer text-center">梦雷出品，必属精品</footer>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/popper.min.js"></script>


</body>
</html>
