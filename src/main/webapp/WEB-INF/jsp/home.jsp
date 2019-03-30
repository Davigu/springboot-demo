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
            <input type="button" id="register" value="注册" onclick="Show1();" style="float:right; background:#FF0;width:5%;height:5%;margin:5px;"/>
            <input type="button" id="login" value="登录" onclick="Show();" ck style="float:right;width:5%;height:5%;margin:5px;" />
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
            <img  src="/image/first.jpg" class="picture"/><p align="left" style="margin-left:20%;">
            <img  src="/image/1.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/image/second.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img  src="/image/2.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/image/third.jpeg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/image/3.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-left:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/image/forth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/image/4.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-right:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/image/fifth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img src="/image/5.jpg" class="head" /> </p>
        </div>
        <div style="float:right;width:40%;margin-left:10%;margin-top:15px; margin-bottom:15px;">
            <img src="/image/sixth.jpg" class="picture"/>
            <p align="left" style="margin-left:20%;">
                <img  src="/image/6.jpg" class="head" /> </p>

        </div>

    </div>


    <!-- 这里是登录界面 -->
    <div id="shade" class="c1 hide"></div>
    <div id="modal" class="c2 hide">
        <p style="font-size: 20px; color: #000;margin-left:150px;">帐号密码登录</p>
        <p>用户：<input  type="text" /></p>
        <p>密码：<input type="password" /></p>
        <p>
            <input type="button" value="确定" class="btn">
            <input type="button" style="margin-left: 20%" value="取消" class="btn" onclick="Hide();">
        </p>
    </div>
    <!-- 这里是注册界面 -->
    <div id="shade1" class="c1 hide"></div>
    <div id="modal1" class="c2 hide" style="height: 400px;">
        <p style="font-size: 20px; color: #000;margin-left:150px;">用户注册</p>
        <p style="margin-left: 20%">用户：<input  type="text" /></p>
        <p style="margin-left: 20%">密码：<input type="password" /></p>
        <p style="margin-left: 20%">邮箱：<input type="password" /></p>
        <p style="margin-left: 20%">号码：<input type="password" /></p>
        <p style="margin-left: 20%">性别：<input type="password" /></p>
        <p>
            <input type="button" style="margin-left: 20%" value="确定" class="btn">
            <input type="button" style="margin-left: 20%" value="取消" class="btn" onclick="Hide1();">
        </p>
    </div>
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
