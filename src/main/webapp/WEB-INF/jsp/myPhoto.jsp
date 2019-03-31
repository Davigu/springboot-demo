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

    <script src="js/jquery/jquery-3.3.1.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("#btn1").click(function(){
                $("p").prepend(
                    '<div class="col-xs-6 col-md-3">'
                    +'<a href="#" class="thumbnail">'
                    +'  <img  src="images/100X125.gif" style="height: 125px; width: 100%; display: block;"alt="100%x180" >'
                    +'  </a>'
                    +' </div>'
                    );
            });

        });
    function setImagePreview() {
    var docObj = document.getElementById("doc");
    var imgObjPreview = document.getElementById("preview");
    if (docObj.files && docObj.files[0]) {
    //火狐下，直接设img属性
    imgObjPreview.style.display = 'block';
    imgObjPreview.style.width = '500px';
    imgObjPreview.style.height = '300px';
    //imgObjPreview.src = docObj.files[0].getAsDataURL();
    //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
    imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    } else {
    //IE下，使用滤镜
    docObj.select();
    var imgSrc = document.selection.createRange().text;
    var localImagId = document.getElementById("localImag");
    //必须设置初始大小
    localImagId.style.width = "100px";
    localImagId.style.height = "100px";


    //图片异常的捕捉，防止用户修改后缀来伪造图片
    try {
    localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
    localImagId.filters
    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
    } catch (e) {
    alert("您上传的图片格式不正确，请重新选择!");
    return false;
    }
    imgObjPreview.style.display = 'none';
    document.selection.empty();
    }
    return true;
    }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
    <div class="container"> <img src="images/1.jpg">
        <a class="navbar-brand" style="color: black" href="#">星相册</a>
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
                    <!--上传照片-->

                </div>
            </div>
            <div class="panel-footer">
                <form action="/doUpload"method="post" name="fileupload" enctype="multipart/form-data">
                    <input name="upfile" type="file" id="doc" onchange="javascript:setImagePreview();";/>

                    <div id="localImag">
                        <img id="preview"  style="display:none" />
                    </div>
                    <input type="submit" value="上传" />
                </form>
            </div>
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
                <button class="btn btn-warning" id="btn1" data-dismiss="modal" type="button">确定</button>
                <button class="btn btn-default " data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
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
                        <p></p>
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


</body>
</html>
