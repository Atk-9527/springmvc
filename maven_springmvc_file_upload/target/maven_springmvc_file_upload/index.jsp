<%--
  Created by IntelliJ IDEA.
  User: QianQian
  Date: 2019/9/28
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>传统文件上传</h2>
    <form action="file/fileUpload" method="post" enctype="multipart/form-data">
        选择文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>

    <h2>Spring mvc 文件上传</h2>
    <form action="file/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>

    <h2>Spring mvc 跨服务器文件上传</h2>
    <form action="file/fileUpload3" method="post" enctype="multipart/form-data">
        选择文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
