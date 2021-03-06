<%@page pageEncoding="UTF-8"%>

    <link href="/css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/uploadfile.css">

<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jqueryfileupload/jquery.form.min.js"></script>
<script src="/js/jqueryfileupload/jquery.uploadfile.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
    <div class="container"><img src="images/starBrandBlack.png"><a class="navbar-brand" style="color: black" href="#">星相册</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" style="color: black" href="#dlgNewAlbum" data-toggle="modal"><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;创建</a></li>
                <li class="nav-item active"><a class="nav-link" style="color: black" href="#myupload" data-toggle="modal"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;&nbsp;上传</a></li>
            </ul>
            <form class="form-inline my-2 my-lg-0 form-control-static float-right">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-primary my-2 my-sm-0" type="button"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
        <div class="dropdown"><a class="dropdown-toggle btn " id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><img class="img-circle" alt="140x140" src="/images/32X32.gif"></a>
            <label id="aaa"></label>
            <script>
                var str = sessionStorage.getItem("name");
                document.getElementById('aaa').innerHTML = str;
            </script>
            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenu1">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade"  id="myupload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-dialog modal-lg">
        <div class="modal-content"   style="height: 570px">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">上传照片</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form class="form-inline">
                        <label>上传到</label>
                        &nbsp;&nbsp;&nbsp;
                        <div class="form-group">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle btn-sm" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><img src="/images/32X32.gif" style="height: 20px" alt="32*32" class="img-rounded">&nbsp;<font style="font-weight: bold">萌宠猫咪</font></button>
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
                            <input type="radio" checked class="radio" value="0" name="definition">
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label >原图&nbsp;
                            <input type="radio" class="radio" value="0" name="definition">
                        </label>
                    </form>
                </div>
                <div class="row">
                    <div class="col-md-3 col-xs-4 text-center " style="padding: 5px">
                        <a href="#" style="position:absolute;right: 5px;top: 5px"><span class="glyphicon glyphicon-remove"></span></a>
                        <img src="/images/100X125.gif" style="height: 100px;width: 100%;margin-top: 13%" alt="">
                        <label>aaa</label>
                    </div>
                    <div class="col-md-3 col-xs-4 text-center"><a href="#" ><img src="/images/add.png" alt=""></a></div>
                    <div id="fileuploader">Upload</div>
                </div>
            </div>
            <div class="panel-footer">
                <button type="button" class="btn btn-success" >开始上传</button>
                <button type="button" class="btn btn-default">继续添加</button>
                共
                <label>5</label>
                张照片（上传过程中请不要删除原始图片）</div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<div class="modal fade" id="dlgNewAlbum" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">创建相册</h4>
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
                        <textarea name="textarea" id="albumDescribe" rows="3" class="form-control"></textarea>
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
                <button class="btn btn-warning" id="btnNewAlbum" type="button">确定</button>
                <button class="btn btn-default " data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<hr>
<footer class="panel-footer text-center fixed-bottom blockquote-footer">达伟出品，必属精品</footer>


<script>
    $(document).ready(function()
    {
        $("#fileuploader").uploadFile({
            url:"doUpload",
            fileName:"upfile"
        });
    });
</script>
