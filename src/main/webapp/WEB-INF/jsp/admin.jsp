<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap-4.0.0.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <meta charset="utf-8">
    <title> 管理员</title>
    <script src="/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<div class="navbar navbar-expand-lg navbar-dark bg-warning">
    <div class="container"><img src="images/starBrandBlack.png"><a class="navbar-brand" style="color: black" href="#">星相册</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="navbar-nav mr-auto">
              后台管理
            </div>
            <form class="form-inline my-2 my-lg-0 form-control-static float-right">
                <input class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-primary my-2 my-sm-0" type="button"><span class="glyphicon glyphicon-search"></span></button>
            </form>
        </div>
    </div>
</div>
        用户信息管理 <input type="button" id="ReFresh" value="刷新" class="btn" style="margin-right: 10%">
<div>
    <div>
        <table border="2">
            <tr>
                <td> ID</td>
                <td> 用户名</td>
                <td> 邮箱</td>
                <td> 性别</td>
                <td> 手机号码</td>
            </tr>
            <c:forEach items="${list}" var="c">
            <tr>
                <td> ${c.userId}</td>
                <td> ${c.userName}</td>
                <td> ${c.email}</td>
                <td> ${c.gender}</td>
                <td> ${c.phone}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script type="text/javascript">

    $("#ReFresh").click(function () {
        sessionStorage.getItem(name);
        $.ajax({
            type:"POST",  //提交方法是POST
            url:"/showAll", //请求的路径
            data:{
                    "name":name,
            },
            dataType:"json",
            error:function () {
                alert("刷新错误");
            },
            success:function () {
                alert("刷新成功");

            }
        })

    })
</script>
</body>
</html>