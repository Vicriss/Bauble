<%--
  Created by IntelliJ IDEA.
  User: vicriss
  Date: 2015/11/14
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<html>
<head>
    <title></title>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>File Upload2</h2>

<form action="/article/upload2" method="post" enctype="multipart/form-data">
  file path:<input type="file" name="xxx"/><br>
  <input type="submit" value="submit"/><br>
  </form>


</body>
</html>
