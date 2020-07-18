<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
       $(function () {
           $(".delete").click(function () {
               var href = $(this).attr("href");
                $("form").attr("action",href).submit()
               return false;
           })
       })
    </script>
</head>
<body>

    <form action="" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户列表 —— 显示所有用户</small>
                </h1>
                <div>
                </div>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddPage">新增</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/user">显示所有用户</a>
        </div>
        <div class="col-md-3 column">
        </div>
        <div class="col-md-4 column">
            <form action="${pageContext.request.contextPath}/user/queryUser" method="post" style="float: right" class="form-inline">
                <span style="color: red;font-weight: bold">${error}</span>
                <input placeholder="请输入要查询的书籍名称" type="text" class="form-control" name="queryUserName">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>
    <br>
    <br>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户名字</th>
                    <th>用户密码</th>
                    <th>用户邮件</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/toUpdateUser?id=${user.id} ">更改</a> |
                            <a class="delete" href="${pageContext.request.contextPath}/user/${user.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>






</body>
</html>


