<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/31
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>星相册-我的回收站</title>
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="navbar"></div>
<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center"> <a class="btn" href="#">
            <h2>我的照片</h2>
        </a>
            <div class="list-group posi" > <a href="#" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> 全部照片</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a> <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-trash"></span> 回收站</a></div>
            <div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">

                </div>
            </div>
        </div>
        <div class="col-md-9 container">
            <div class="row float-right">
                <button class="btn btn-warning ">清空回收站</button>
            </div>
            <div class="row" style="clear: both">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr class="table-dark">
                        <th class="col-md-1 text-center"><input type="checkbox"></th>
                        <th class="col-md-5">文&nbsp;&nbsp;件&nbsp;&nbsp;名</th>
                        <th class="col-md-1"></th>
                        <th class="col-md-1 text-center">大&nbsp;&nbsp;小</th>
                        <th class="col-md-2 text-center">删&nbsp;除&nbsp;时&nbsp;间</th>
                        <th class="col-md-2 text-center">有&nbsp;效&nbsp;时&nbsp;间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="col-md-1 text-center"><input type="checkbox"></td>
                        <td class="col-md-4"><span style="color: #696969" class="glyphicon glyphicon-picture"></span>&nbsp;hhhhhhhhhh</td>
                        <td class="col-md-2"><a href="#" class="btn btn-sm"><span class="glyphicon glyphicon-repeat"></span></a>&nbsp;<a href="#" class="btn btn-sm">
                            <span class="glyphicon glyphicon-trash"></span></a></td>
                        <td class="col-md-1 text-center">755kb</td>
                        <td class="col-md-2 text-center">11点00分</td>
                        <td class="col-md-2 text-center">10天</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script>
    $("#navbar").load("navbar.jsp");
</script>
</body>
</html>
