<%--
  Created by IntelliJ IDEA.
  User: QianQian
  Date: 2019/9/26
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 请求参数的绑定 --%>
<%--request.setCharacterEncoding--%>
<%--<a href="param/testParam?username=qianqian&password=123">请求参数的绑定</a>
    把数据封装到 Account 类中
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金融：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交">
    </form>
    --%>

<%-- 把数据封装到 Account 类中 List 和 Map 中
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="text" name="password" /><br/>
    金融：<input type="text" name="money" /><br/>

    用户姓名：<input type="text" name="list[0].uname" /><br/>
    用户年龄：<input type="text" name="list[0].age" /><br/>

    用户姓名：<input type="text" name="map['one'].uname" /><br/>
    用户年龄：<input type="text" name="map['one'].age" /><br/>
    <input type="submit" value="提交">
</form>
--%>
<%--自定义类型转化器
<form action="param/saveUser" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交">
</form>
--%>
<a href="param/testServlet">Servlet原生的api</a>
</body>
</html>
