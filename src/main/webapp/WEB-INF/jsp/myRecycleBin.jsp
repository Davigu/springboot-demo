<%--
  Created by IntelliJ IDEA.
  User: 加州旅馆
  Date: 2019/3/31
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="navbar.jsp"%>
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
<div class="container">
    <div class="row">
        <div class=" col-md-3 text-center"> <a class="btn" href="home">
            <h2>我的照片</h2>
        </a>
            <div class="list-group posi" > <a href="allPhoto" class="list-group-item"><span class="glyphicon glyphicon-picture"></span> 全部照片</a> <a href="allAlbum" class="list-group-item"><span class="glyphicon glyphicon-book"></span> 我的相册</a> <a href="#" class="list-group-item"><span class="glyphicon glyphicon-new-window"></span> 我的分享</a> <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-trash"></span> 回收站</a></div>
            <div class="progress" style="margin-top: 250px">
                <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">

                </div>
            </div>
        </div>
        <div class="col-md-9 container">
            <div class="row float-right">
                <button id="recSelected" class="btn btn-warning ">恢复所选</button>
                &nbsp;&nbsp;
                <button id="delSelected" class="btn btn-danger ">删除所选</button>
            </div>

            <div class="row" style="clear: both">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr class="table-dark">
                        <th class="col-md-1 text-center"><input type="checkbox" id="selectAll" onclick="selectAll();"></th>
                        <th class="col-md-5">文&nbsp;&nbsp;件&nbsp;&nbsp;名</th>
                        <th class="col-md-1"></th>
                        <th class="col-md-1 text-center">大&nbsp;&nbsp;小</th>
                        <th class="col-md-2 text-center">删&nbsp;除&nbsp;时&nbsp;间</th>
                        <th class="col-md-2 text-center">有&nbsp;效&nbsp;时&nbsp;间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${map}" var="file">
                        <tr>
                            <td class="col-md-1 text-center"><input type="checkbox" name="selected" value='{ "fileId":"${file.key.fileId}" , "recentId":"${file.key.recentId}" }'></td>
                            <td class="col-md-4">
                                <c:if test="${file.key.object==1}">
                                    <span style="color: #696969" class="glyphicon glyphicon-picture"></span>
                                </c:if>
                                <c:if test="${file.key.object==0}">
                                    <span style="color: #696969" class="glyphicon glyphicon-folder-open"></span>
                                </c:if>
                                &nbsp;${file.key.fileName}
                            </td>
                            <td fileid="${file.key.fileId}" photoid="${file.key.recentId}" class="col-md-2">
                                <a href="javascript:;" class="btn btn-sm recoverPhoto"><span class="glyphicon glyphicon-repeat "></span></a>&nbsp;
                                <a  href="javascript:;" class="btn btn-sm delPhoto">
                                <span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                            <td class="col-md-1 text-center">${file.key.size}</td>
                            <td class="col-md-2 text-center" ><fmt:formatDate value="${file.key.initialTime}" pattern="MM-dd HH:mm:ss"></fmt:formatDate></td>
                            <td class="col-md-2 text-center">${file.value}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script>
    $(".recoverPhoto").click(function () {
        var fileid=$(this).parent().attr("fileid");
        var photoid=$(this).parent().attr("photoid")
        var t=$(this).parent().parent();
        $.ajax({
            type:"POST",
            url:"recoverPhoto",
            data:{
                "fileId":fileid,
                "recentId":photoid,
            },
            dataType:"json",
            success:function (data) {
                if(data==true){
                    console.log("恢复成功");
                    t.remove();
                }else{
                    console.log("恢复失败");
                }
            }
        })
    });
    $(".delPhoto").click(function(){
        var fileid=$(this).parent().attr("fileid");
        var photoid=$(this).parent().attr("photoid")
        var t=$(this).parent().parent();
        var data="fileId="+fileid+"&photoId="+photoid;
        $.ajax({
            type:"POST",
            url:"delPhotoComplete",
            data:data,
            dataType:"json",
            success:function (data) {
                if(data==true){
                    console.log("删除成功");
                    t.remove();
                }else{
                    console.log("删除失败");
                }
            }
        })
    });
    function selectAll() {
        if($("#selectAll").is(":checked")){
            $("[name='selected']").prop("checked",true);
        }else{
            $("[name='selected']").prop("checked",false);
        }
    };
    $("#delSelected").click(function () {
        var ids=[];
        $("input[name='selected']:checked").each(function () {
            ids.push($(this).val());
        });
        var t=confirm("确认删除？");
        if(t==true){
            $.ajax({
                type:"POST",
                url:"delSelected",
                data:"ids="+ids,
                dataType:"json",
                success:function (data) {
                    if(data==true){
                        console.log("删除成功");
                        $("input[name='selected']:checked").each(function () {
                            $(this).parent().parent().remove();
                            $("#selectAll").prop("checked",false);
                        });
                    }
                },error:function (data) {
                    console.log(data);
                }
            })
        }

    });
    $("#recSelected").click(function () {
        var ids=[];
        $("input[name='selected']:checked").each(function () {
            ids.push($(this).val());
        });
        $.ajax({
            type:"POST",
            url:"recSelected",
            data:"ids="+ids,
            dataType:"json",
            success:function (data) {
                if(data==true){
                    console.log("恢复成功");
                    $("input[name='selected']:checked").each(function () {
                        $(this).parent().parent().remove();
                        $("#selectAll").prop("checked",false);
                    });
                }
            },error:function (data) {
                console.log(data);
            }
        })
    })
</script>
</body>
</html>
