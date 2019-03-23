<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="/js/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>注册</div>
<div>用户名：<input type="text" id="userName"></div>
<div>密码：<input type="password" id="passWord"></div>
<div>性别：<input type="text" id="gender"></div>
<div>邮箱：<input type="text" id="email"></div>
<div>电话号码：<input type="text" id="phone"></div>
<div> <input type="button"  id="btnsave" value="Save"></div>

<script>
    $(function () {
        $("#btnsave").on("click", function () {
            if ($("#btnsave").hasClass("Saving")) {
                return;
            }
            $("#btnsave").addClass("Saving");
            $("#btnsave").val("Saving");
            var userName=$("#userName").val();
            if (userName.trim()=="") {
                alert("User name is empty!");
                return;
            }
            var passWord=$("#passWord").val();
            if (passWord.trim()=="") {
                alert("password is empty!");
                return;
            }
            var gender=$("#gender").val();
            var email=$("#email").val();
            var phone=$("#phone").val();
            $.ajax({
                type:"POST",
                url:"/find/doInsert",
                dataType:"json",
                data:{
                    "userName":userName,
                    "password":passWord,
                    "gender":gender,
                    "email":email,
                    "phone":phone
                },
                success:function (result) {
                    $("#btnsave").removeClass("Saving");
                    $("#btnsave").val("Save");

                    if (result.code == 0) {
                        window.location.href = "/find/"+result.userName;
                    } else {
                        alert(result.msg);
                    }
                },
                error:function () {
                    $("#btnsave").removeClass("Saving");
                    $("#btnsave").val("Save");
                }
            })
        })
    })
</script>


</body>
</html>
