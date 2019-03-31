<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- TemplateBeginEditable name="doctitle" -->
        <title>星相册</title>
        <!-- TemplateEndEditable -->
        <!-- TemplateBeginEditable name="head" -->
        <!-- TemplateEndEditable -->
        <link href="/css/style.css" rel="stylesheet" type="text/css" />
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="/js/jquery/jquery-3.3.1.min.js"></script>
        <script src="/js/bootstrap.js"></script>
    </head>

    <body>
    <div  class="background">
        <div class=" fontwhite"> <p style="margin-left:10%">
            <input class="btn btn-warning" type="button" id="register" value="注册" onclick="Show1();" style="float:right; width:5%;height:5%;margin:5px;"/>
            <input  class="btn btn-info" type="button" id="login" value="登录" onclick="Show();" ck style="float:right;width:5%;height:5%;margin:5px;" />
        </p>
            <p style="margin-left:10%; font-size: 30px;">星相册    	  </p>
        </div>
        <div align="center" class="fontwhite" style="width:52%; margin-left:25%">
            <p>
                这是一本有关青春的相册，一本记录成长的相册
            <hr/>
            <p style="font-size:12px">同时，这又是一本值得珍藏的相册，一本值得回味的	相册，一本编制的色彩斑斓的梦的相册
            </p>
            </p>
        </div>
    </div>
    <div align="center">
        <p class="fontblack" >
            当前最热门
        </p>
        <p style="color:#CCC;">
            HOT PICTURES
        </p>
    </div>
    <div align="center">
        <div style=" float:left;width:40%; margin-left:10%; margin-top:15px; margin-bottom:15px;">
            <img  src="/images/first.jpg" class="picture"/><p align="left" style="margin-left:20%;">
            <img  src="/images/1.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/images/second.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img  src="/images/2.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/images/third.jpeg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/images/3.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-left:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/images/forth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/images/4.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/images/fifth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/images/5.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-left:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/images/sixth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img  src="/images/6.jpg" class="head" /> </p>

        </div>

    </div>


    <!-- 这里是登录界面 -->
    <div id="shade" class="c1 hide"></div>
            <div id="modal" class="c2 hide">
        <p style="font-size: 20px; color: #000;margin-left:150px; margin-top: 50px">帐号密码登录</p>
        <p><input  type="text" id="uid" class="form-control" placeholder="用户名" style="width: 250px"/></p>
        <p><input type="password" id="pwd" class="form-control" placeholder="密码"style="width: 250px"/></p>
        <p>
            <input type="button" id="btn" value="确定" class="btn">
            <input type="button" style="margin-left: 20%" value="取消" class="btn" onclick="Hide();">
        </p>
    </div>
    <!-- 用于登录的js代码-->
    <script type="text/javascript">
        $("#btn").click(function () {
            var loginCode = $.trim($("#uid").val());
            var password = $.trim($("#pwd").val());

            //前台的非空验证
            if(loginCode == "" || loginCode == null){
                alert("对不起，登录账号不能为空。");
            }else if(password == "" || password == null){
                alert("对不起，登录密码不能为空。");
            }else{
                $.ajax({
                    type:"POST",  //提交方法是POST
                    url:"/doLogin", //请求的路径
                    data:{
                        "userName":loginCode,
                        "password":password,
                    },
                    dataType:"json",
                    error:function(){  //请求失败的回调方法
                        alert("登录错误！请重试。");
                    },
                    success:function(result){   //请求成功的回调方法
                        if(result != "" && result.code == "0"){
                            alert("登录成功")
                        }else if(result.code == "2"){
                            alert("登录账号不存在！请重试。");
                        }else if(result.code == "1"){
                            alert("登录密码错误！请重试。");
                        }
                    }
                });
            }
        })
    </script>
    <!-- 这里是注册界面 -->
    <div id="shade1" class="c1 hide"></div>
    <div id="modal1" class="c2 hide" style="height: 400px;">
        <p style="font-size: 20px; color: #000;margin-left:150px;margin-top: 20px">用户注册</p>
        <p style="margin-left: 20%"><input  type="text" id="userName" class="form-control" placeholder="用户"style="width: 250px" /></p>
        <p style="margin-left: 20%"><input type="password" id="passWord" class="form-control" placeholder="密码"style="width: 250px"/></p>
        <p style="margin-left: 20%"><input type="password" class="form-control" placeholder="确认密码"style="width: 250px"/></p>
        <p style="margin-left: 20%"><input type="text" id="email" class="form-control" placeholder="邮箱"style="width: 250px"/></p>
        <p style="margin-left: 20%"><input type="text" id="phone" class="form-control" placeholder="手机号码"style="width: 250px"/></p>
        <p style="margin-left: 20%">性别:男<input type="radio" name="gender" value="1">女<input type="radio" name="gender" value="2"></p>
        <p>
            <input type="button" style="margin-left: 20%" value="确定" class="btn" id="btnSave">
            <input type="button" style="margin-left: 20%" value="取消" class="btn" onclick="Hide1();">
        </p>
    </div>
    <!-- 用于确认注册的js代码 -->
    <script>
        $(function(){
            $("#btnSave").on("click",function(){
                if($("#btnSave").hasClass("saving")){
                    return;
                }

                $("#btnSave").addClass("saving");
                $("#btnSave").val("saving");
                var username=$("#userName").val();
                var password=$("#passWord").val();
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
                            alert("注册成功");
                            Hide1();
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

    <script>
        function Show(){
            document.getElementById('shade').classList.remove('hide');
            document.getElementById('modal').classList.remove('hide');
        }
        function Hide(){
            document.getElementById('shade').classList.add('hide');
            document.getElementById('modal').classList.add('hide');
        }
        function Show1(){
            document.getElementById('shade1').classList.remove('hide');
            document.getElementById('modal1').classList.remove('hide');
        }
        function Hide1(){
            document.getElementById('shade1').classList.add('hide');
            document.getElementById('modal1').classList.add('hide');
        }
    </script>


    </body>
</html>
