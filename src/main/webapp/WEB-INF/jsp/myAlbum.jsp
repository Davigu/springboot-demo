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
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
    <div class="container"> <img src="images/star-brand-black.png"> <a class="navbar-brand" style="color: black" href="#">星相册</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"> <a class="nav-link" style="color: black" href="#mybuild" data-toggle="modal"><span class="glyphicon glyphicon-plus"></span> &nbsp;&nbsp;创建 </a></li>
                <li class="nav-item active"> <a class="nav-link" style="color: black" href="#myupload" data-toggle="modal"><span class="glyphicon glyphicon-cloud-upload"></span> &nbsp;&nbsp;上传</a></li>
            </ul>
            <form class="form-inline my-2 my-lg-0 form-control-static float-right">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-primary my-2 my-sm-0" type="button"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="dropdown"> <img  class="img-circle" alt="140x140" src="images/32X32.gif"> <a class=" dropdown-toggle  btn" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> 用户名 </a>
            <ul class="dropdown-menu" aria-labelledby="userMenu1">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade"  id="myupload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content"   style="height: 570px">
            <div class="modal-header">
                <h4 class="modal-title">上传照片</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form class="form-inline">
                        <label>上传到</label>
                        &nbsp;&nbsp;&nbsp;
                        <div class="form-group">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle btn-sm" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><img src="images/32X32.gif" style="height: 20px" alt="32*32" class="img-rounded">&nbsp;<font style="font-weight: bold">萌宠猫咪</font></button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                        </div>
                        &nbsp;&nbsp;&nbsp;
                        <label>照片尺寸：</label>
                        <label >普通&nbsp;
                            <input type="radio" class="radio" value="0" name="definition">
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label >高清&nbsp;
                            <input type="radio" class="radio" value="0" name="definition">
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label >原图&nbsp;
                            <input type="radio" class="radio" value="0" name="definition">
                        </label>
                    </form>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="thumbnail"> <img src="images/100X125.gif" style="height: 100px;width: 100%" alt="">
                            <p>aaaa</p>
                        </div>
                    </div>
                    <div> <a href="#"><img src="images/addPhoto.png" alt=""></a></div>
                </div>
            </div>
            <div class="panel-footer">
                <button type="button" class="btn btn-success" >开始上传</button>
                <button type="button" class="btn btn-default">继续添加</button>
                共
                <label>5</label>
                张照片（上传过程中请不要删除原始图片） </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<div class="modal fade" id="mybuild" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">创建相册</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div>
                        <label for="albumName">相册名称：</label>
                        <input class="form-control" type="text" id="albumName" placeholder="相册名称">
                        <label>0</label>
                        /30</div>
                    <div>
                        <label for="albumName">相册描述：</label>
                        <textarea name="textarea" rows="3" class="form-control"></textarea>
                        <label>0</label>
                        /2000</div>
                    <div class="form-inline">
                        <label>选择列表:</label>
                        <select name="select" class="form-control-lg form-control">
                            <option>所有人可见</option>
                            <option>仅自己可见</option>
                            <option>仅好友可见</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-warning" type="button">确定</button>
                <button class="btn btn-default " data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<hr>

<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center"> <a class="btn" href="#">
            <h2>我的照片</h2>
        </a>
            <div class="list-group posi" > <a href="#" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> 我的照片</a> <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-book"></span> 我的相册</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-trash"></span> 回收站</a> </div>
        </div>
        <div class="col-md-9" style="border-left: medium #DCD4D4 solid">

            <div id="editphone" class="col-xs-6 col-md-3">
                <div id="editmenu" class="dropdown" style="position:absolute;top: 5px;right: 20px;">
                    <button class="btn btn-default dropdown-toggle btn-sm" type="button" data-toggle="dropdown" ></button>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="editphoto">
                        <li><a href="#">重命名</a></li>
                        <li><a href="#">分享</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">删除</a></li>
                    </ul>
                </div>
                <a  href="#" class="thumbnail">
                    <img class="img-rounded" src="images/100X125.gif" style="width: 100%;height: 130px" alt="">
                    <p class="float-right" style="position:relative;bottom: 20px;right: 5px;color:aliceblue">点赞数</p>
                    <p class="btn">我的收藏</p>
                </a>

            </div>
            <div class="col-xs-6 col-md-3"><a href="#" class="thumbnail"><img src="images/add.png" alt=""></a>
            </div>
        </div>
    </div>
</div>
<hr>
<footer class="text-center fixed-bottom blockquote-footer">
    梦雷出品
</footer>

<script src="js/jquery-3.3.1.min.js"></script>
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
    })
</script>
</body>
</html>
