<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath}" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1576261_51iq19kjpqg.css">
    <link rel="stylesheet" href="${baseUri}/static/css/login.css">
    <link rel="stylesheet" href="${baseUri}/static/layui/css/layui.css">
    <title>LOGIN</title>
</head>
<body>
<div class="form-wrapper">
    <div class="header">Bookshelf</div>
    <div class="input-wrapper">
        <form name="form_login" action="${baseUri}/verify/login" method="post">
            <div class="border-wrapper">
                <input type="text" name="username" placeholder="username" class="border-item">
            </div>
            <div class="border-wrapper">
                <input type="password" name="password" placeholder="password" class="border-item">
            </div>
            <%--
            <div class="layui-form-item">
                <label class="layui-form-label">选择框</label>
                <div class="layui-input-block">
                    <select name="interest" lay-filter="interest">
                        <option value="0">User</option>
                        <option value="1">Admin</option>
                    </select>
                </div>
            </div>
            --%>
            <div class="action">
                <input class="btn" type="submit" value="Login" readonly>
            </div>
        </form>
    </div>
    <%--
            <div class="icon-wrapper">
              <i class="iconfont phs-weixin"></i>
              <i class="iconfont phs-weibo"></i>
              <i class="iconfont phs-github"></i>
            </div>
    --%>
</div>
</body>
</html>