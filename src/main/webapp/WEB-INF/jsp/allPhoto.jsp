<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/30
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="navbar.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>星相册-我的照片</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/photoviewer.css" rel="stylesheet">
</head>
<body>
<div id="navbar"></div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<div class="container" id="container">
    <div class="row">
        <div class=" col-md-3 text-center">

            <a class="btn" href="#"><h2>我的照片</h2></a>
            <div class="list-group posi" >
                <a href="/allPhoto" class="list-group-item active"><span class="glyphicon glyphicon-picture"></span> 全部照片</a>
                <a href="/myAlbum" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a>
                <a href="/myShare" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a>
                <a href="/myRecycleBin" class="list-group-item"><span class="glyphicon glyphicon-trash"></span> 回收站</a>
            </div>
            <div class="progress" style="margin-top: 250px">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                </div>
            </div>
        </div>
        <div class="container col-md-9" style="border-left:medium #DCD4D4 solid;">
            <div class="row float-right">
                <button class="btn btn-warning" href="#myupload" data-toggle="modal">上传</button>
            </div>

            <div id="month_view" class="row" style="clear: both">
                <c:forEach items="${photos}" var="date" varStatus="status">
                    <div id="${date.key}" class="panel col-md-12">
                        <div class="panel-heading">
                            <h4 class="panel-title">${date.key}</h4>
                        </div>
                        <div class="panel-body">
                            <c:forEach items="${date.value}" var="photo" varStatus="status">
                                <div class="col-xs-6 col-md-3 editPhoto" style="padding: 5px;">

                                    <div class="dropdown editMenu" style="position:absolute;top: 10.5px;right: 10.5px;display: none">
                                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"></button>
                                        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="editphoto" photoid="${photo.photoId}">
                                            <li><a class="renamePhoto" href="#">重命名</a></li>
                                            <li><a class="delIntoRec" href="javascript:;">删除照片</a></li>
                                            <li role="separator" class="divider"></li>
                                            <li><a class="delPhoto" href="javascript:;">彻底删除</a></li>
                                        </ul>
                                    </div>
                                    <a data-gallery="manual" href="${photo.photoAddress}" class="thumbnail">
                                        <img alt="${photo.photoName}" src="${photo.photoAddress}" style="height: 125px; width: 100%; display: block;" >
                                    </a>
                                </div>

                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="row">
                <img id="loading" class="center-block" src="images/loading.gif" style="display: none">
            </div>
        </div>
    </div>

</div>
<hr>

<script src="js/bootstrap.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/popper.min.js"></script>
<script src="js/photoviewer.js"></script>
<script>
    $(function () {

        $("#container").on("mouseenter",".editPhoto",function () {
            $(this).find(".editMenu").css("display", "block");
        });

        $("#container").on("mouseleave",".editPhoto", function () {
            $(this).find(".editMenu").css("display", "none");
        });
    });
    //实现大图

        $("#container").on("click","[data-gallery=manual]",function (e) {
            e.preventDefault();
            var items = [],
                // get index of element clicked
                options = {
                    index: $(this).index(".thumbnail")
                };
            // looping to create images array
            $('[data-gallery=manual]').each(function () {
                let src = $(this).attr('href');
                items.push({
                    src: src
                });
            });
            console.log(options);
            new PhotoViewer(items, options);
        });


    //删除按钮
    $("#container").on("click", ".delPhoto", function () {
        var id=$(".delPhoto").parent().parent().attr("photoid");
        var a=confirm("是否彻底删除这张照片？");
        var t=$(this).parent().parent().parent().parent();
        var size=$(this).parent().parent().parent().parent().parent().children("div").length;
        var panel=$(this).parent().parent().parent().parent().parent().parent();
        if(a==true){
            $.ajax({
                type:"POST",
                url:"deletePhoto",
                data:{"id":id},
                dataType:"json",
                success:function (data) {
                    console.log(data);
                    if(data==true){
                        console.log("删除成功");
                        t.remove();
                        console.log(size);
                        if(size-1==0){
                            panel.remove();
                        }
                    }else{
                        console.log("删除失败");
                    }
                }
            })
        }
    });
    $(".delIntoRec").click(function () {
        var photoid=$(this).parent().parent().attr("photoid");
        var photoAdd=$(this).attr("photoAdd");
        var t=$(this).parent().parent().parent().parent();
        var size=$(this).parent().parent().parent().parent().parent().children("div").length;
        var panel=$(this).parent().parent().parent().parent().parent().parent();
        $.ajax({
            type:"POST",
            url:"delIntoRec",
            data:{
                "photoid":photoid,
            },
            dataType: "json",
            success:function(data){
                if(data==true){
                    console.log("移入回收站成功");
                    t.remove();
                    //console.log(size);
                    if(size-1==0){
                        panel.remove();
                    }
                }else{
                    console.log("移入回收站失败");
                }
            }
        })
    });
    var curPage=2;
    $(window).scroll(function () {
        var startRow="startRow="+(curPage-1)*20;
        console.info($(document).scrollTop());
        console.info($(document).height());
        console.info(document.body.clientHeight);
        if(Math.ceil($(document).scrollTop())>=$(document).height()-document.body.clientHeight){
            $("#loading").css("display","block");
            $.ajax({
                type:"POST",
                url:"paging",
                data:startRow,
                success:function (result) {
                    if(result==null) return;
                    var count=0;
                    for (var key in result) {
                        if($("#"+key).length==0){
                            $("#month_view").append('<div id="'+key+'" class="panel col-md-12">\n' +
                                '<div class="panel-heading">\n' +
                                '<h4 class="panel-title">'+key+'</h4>\n' +
                                '</div>\n' +
                                '<div class="panel-body">\n' +
                                '\n' +
                                '</div>\n' +
                                '</div>')
                        }
                        var html='';
                        for(var index in result[key]){
                            html=html+'<div class="col-xs-6 col-md-3 editPhoto" style="padding: 5px;">'+
                                '<div class="dropdown editMenu" style="position:absolute;top: 10.5px;right: 10.5px;display:none">\n' +
                                '<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"></button>\n' +
                                '<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="editphoto" photoid="'+result[key][index].photoId+'">\n' +
                                '<li><a class="renamePhoto" href="#">重命名</a></li>\n' +
                                '<li><a class="delIntoRec" href="javascript:;">删除照片</a></li>\n' +
                                '<li role="separator" class="divider"></li>\n' +
                                '<li><a class="delPhoto" href="javascript:;">彻底删除</a></li>\n' +
                                '</ul>\n' +
                                '</div>\n' +
                                '<a data-gallery="manual" href="'+result[key][index].photoAddress+'" class="thumbnail">\n' +
                                ' <img alt="'+result[key][index].photoName+'" src="'+result[key][index].photoAddress+'" style="height: 125px; width: 100%; display: block;" >\n' +
                                '</a>'+
                                '</div>'
                        }
                        $("#"+key+" .panel-body").append(html);
                        count++;
                    }
                    if (count>0) curPage++;
                    console.log(curPage);
                    $("#loading").css("display","none");

                }
            })
        }
    })
</script>
</body>
</html>