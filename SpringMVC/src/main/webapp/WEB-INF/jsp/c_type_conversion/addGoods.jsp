<%--
  Created by IntelliJ IDEA.
  User: YY
  Date: 2020/11/27
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品信息</title>
</head>
<body>
    <form action="./addGoods" method="post">
        <table>
            <tr>
                <td>商品名称：</td>
                <td><input type="text" name="goodsname"/></td>
            </tr>
            <tr>
                <td>商品价格：</td>
                <td><input type="text" name="goodsprice"/></td>
            </tr>
            <tr>
                <td>商品数量：</td>
                <td><input type="text" name="goodsnumber"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
