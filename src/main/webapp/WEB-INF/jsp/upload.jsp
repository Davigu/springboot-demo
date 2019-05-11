<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>图片上传</title>

    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/jquery.fileupload.css">

</head>
<body>

<script src="/js/jquery-3.3.1.min.js"></script>

<script src="/js/jqueryfileupload/jquery.uploadfile.min.js"></script>

<div id="fileuploader">Upload</div>

<script>
    $(document).ready(function()
    {
        $("#fileuploader").uploadFile({
            url:"doUpload",
            fileName:"upfile"

        });
    });
</script>
</body>
</html>