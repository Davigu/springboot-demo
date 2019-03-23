<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>
    注册
</h1>
<!--
user_id
user_name
password
email
phone
gender
-->
<div>
    用户名:<input type="text" id="userName"/><span id="ID1"></span><br>
    密码:<input type="password" id="password"/><br>
    邮箱:<input type="text" id="email"><br>
    电话:<input type="text" id="phone"><br>
    性别:男<input type="radio" name="gender" value="1">女<input type="radio" name="gender" value="2"><br>
    <input type="button" value="save" id="btnSave">
</div>
<script>
    $(function(){
        $("#btnSave").on("click",function(){
            if($("#btnSave").hasClass("saving")){
                return;
            }

            $("#btnSave").addClass("saving");
            $("#btnSave").val("saving");
            var username=$("#userName").val();
            var password=$("#password").val();
            var email=$("#email").val();
            var phone=$("#phone").val();
            var gender=$('input:radio[name="gender"]:checked').val();

            $.ajax({
                type:"POST",
                url:"/doInsert",
                dataType:"json",
                data:{
                    "userName":username,
                    "password":password,
                    "email":email,
                    "phone":phone,
                    "gender":gender,
                },
                success:function (result) {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");
                    if(result.code==0){
                        window.location.href="/user/"+result.userId;
                    }
                },
                error:function () {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");
                }
            })

        })

        $("#userName").blur(function(){
            var username=$("#userName").val();
            $.ajax({
                type:"POST",
                url:"/find",
                dataType:"json",
                data:{
                    "userName":username,
                },
                success:function (result) {
                    $("#ID1").html("用户名已存在")
                },
                error:function () {
                    $("#ID1").html("用户名可用")
                }


            })
        })

        $("#userName").focus(function () {
            $("#ID1").html("")
        })
    })
</script>

</body>
</html>