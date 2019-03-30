<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>图片上传</title>

    <script type="text/javascript">
        function setImagePreview() {
            var docObj = document.getElementById("doc");
            var imgObjPreview = document.getElementById("preview");
            if (docObj.files && docObj.files[0]) {
                //火狐下，直接设img属性
                imgObjPreview.style.display = 'block';
                imgObjPreview.style.width = '500px';
                imgObjPreview.style.height = '300px';
                //imgObjPreview.src = docObj.files[0].getAsDataURL();
                //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
                imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
            } else {
                //IE下，使用滤镜
                docObj.select();
                var imgSrc = document.selection.createRange().text;
                var localImagId = document.getElementById("localImag");
                //必须设置初始大小
                localImagId.style.width = "350px";
                localImagId.style.height = "270px";
                //图片异常的捕捉，防止用户修改后缀来伪造图片
                try {
                    localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    localImagId.filters
                        .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                } catch (e) {
                    alert("您上传的图片格式不正确，请重新选择!");
                    return false;
                }
                imgObjPreview.style.display = 'none';
                document.selection.empty();
            }
            return true;
        }
</script>
        </head>
<body>
    <form action="/doUpload"method="post" name="fileupload" enctype="multipart/form-data">
        <input name="upfile" type="file" id="doc" onchange="javascript:setImagePreview();";/>
        <br>
    <input type="submit" value="上传" />
    <br>

    <div id="localImag">
        <img id="preview"  style="display:none" />
    </div>
    </form>
</body>
</html>