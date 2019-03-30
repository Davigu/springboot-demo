<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>
</h1>
<div>
    <input type="text" id="album_name"/><br>
    <input type="text" id="theme"/><br>
    <input type="text" id="album_auth"/><br>
    <input type="text" id="album_description"/><br>
    <input type="button" value="update" id="btnUpdate">
</div>
<script>
    $(function () {
        $("#btnUpdate").on("click",function(){
            var albumName=$("#album_name");
            var theme=$("#theme");
            var albumAuth=$("#album_auth");
            var albumDescription=$("#album_description");
            $.ajax({
                Type:"POST",
                url:"/editAlbum",
                dataType:"json",
                data:{
                    albumName:albumName,
                    theme:theme,
                    albumAuth:albumAuth,
                    albumDescription:albumDescription,
                },
                success:function(){
                    alert("修改成功");
                },
                error:function () {
                    alert("修改失败");
                }
            })
        })
    })
</script>
</body>
</html>
