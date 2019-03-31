<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/30
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>星相册-我的分享</title>
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>


<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center"> <a class="btn" href="#">
            <h2>我的照片</h2>
        </a>
            <div class="list-group posi" > <a href="#" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> 全部照片</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a> <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-trash"></span> 回收站</a> </div>
            <div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">

                </div>
            </div>
        </div>
        <div class="col-md-9" style="border-left:medium #DCD4D4 solid;">
            <div id="editphone" class="col-xs-6 col-md-3">
                <div id="editmenu" class="dropdown" style="position:absolute;top: 5px;right: 20px;">
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" ></button>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="editphoto">
                        <li><a href="#">删除</a></li>
                    </ul>
                </div>
                <a  href="#" class="thumbnail">
                    <img class="img-rounded" src="images/100X125.gif" style="width: 100%;height: 130px" alt="">
                    <p class="float-right" style="position:relative;bottom: 20px;right: 5px;color:aliceblue">30</p>
                    <p class="btn">我的收藏</p>
                </a>
                <div style="position: absolute;top: 175px">
                    <span class="glyphicon glyphicon-link" style="color:#9C9C9C"></span>
                    <font size="-4" color="#9C9C9C">已分享链接</font>
                </div>

            </div>
        </div>
    </div>
</div>






<footer class="panel-footer text-center fixed-bottom blockquote-footer">梦雷出品，必属精品</footer>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/popper.min.js"></script>
<script>
    $(function(){

        $("#editmenu").css("display","none");
        $("#editphone").hover(function(){
            $("#editmenu").css("display","block");
        },function(){
            $("#editmenu").css("display","none");
        });
    });

    $("#navbar").load("navbar.html");
</script>
</body>
</html>
