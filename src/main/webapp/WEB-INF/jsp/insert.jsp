<%--
  Created by IntelliJ IDEA.
  User: ROCKEY
  Date: 2019/3/16
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert User</title>

    <script src="/js/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>昵称：    <input type="text" id="userName"></div>
<div>密码：    <input type="password" id="password"></div>
<div>邮箱：    <input type="text" id="email"></div>
<div>电话号码：<input type="text" id="phone"></div>
<div>性别：    <input type="text" id="gender"></div>
<div>权限等级：<input type="text" id="auth"></div>
<div>个性签名：<input type="text" id="sign"></div>
<div><input type="button" value="Save" id="btnSave"></div>
<script>
    //创建功能
    $(function () {
        //点击触发事件
        $("#btnSave").on("click", function () {
            //给予状态 Saving
            if ($("#btnSave").hasClass("Saving")) {
                return;
            }
                //给予状态 Saving
            $("#btnSave").addClass("Saving");
            $("#btnSave").val("Saving");

            var userName=$("#userName").val();
            if (userName.trim()==" ") {
                alert("UserName is empty!");
                return;
            }

            var password=$("#password").val();
            if (password.trim()==" ") {
                alert("password is empty!");
                return;
            }
            var email=$("#email").val();
            if (email.trim()==" ") {
                alert("email is empty!");
                return;
            }
            var phone=$("#phone").val();
            if (phone.trim()==" ") {
                alert("phone is empty!");
                return;
            }
            var gender=$("#gender").val();
            if (gender.trim()==" ") {
                alert("gender is empty!");
                return;
            }
            var auth=$("#auth").val();
            if (auth.trim()==" ") {
                alert("auth is empty!");
                return;
            }
            var sign=$("#sign").val();
            if (sign.trim()==" ") {
                alert("sign is empty!");
                return;
            }

            $.ajax({
                type:"POST",
                url:"/user/doInsert",
                dataType:"json",
                data:{
                    "userName":userName,
                    "password":password,
                    "email":email,
                    "phone":phone,
                    "gender":gender,
                    "auth":auth,
                    "sign":sign,
                },
                success:function (result) {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");

                    if (result.code == 0) {
                        window.location.href = "/user/"+result.userId;
                    } else {
                        alert(result.msg);
                    }
                },
                error:function () {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");
                }
            })


        })
    })
</script>
</body>
</html>
