<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login" method="post">
    <table>
        <tr>
            <td colspan="2">
<%--                <img src="${pageContext.request.contextPath }/images/Ringo.jpg">--%>
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <input type="text" name="uname" class="textSize">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="upass" class="textsize">
            </td>
        </tr>
        <tr>
            <td colspan="2">
<%--                <input type="image" src="${pageContext.request.contextPath }/images/ok.gif" onclick="gogo()">--%>
<%--                <input type="image" src="${pageContext.request.contextPath }/images/cancel.gif" onclick="cancel()">--%>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
    ${messageError}
</form>
</body>
</html>