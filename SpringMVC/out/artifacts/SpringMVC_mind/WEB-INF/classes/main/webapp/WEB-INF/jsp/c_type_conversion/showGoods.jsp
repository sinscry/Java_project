<%--
  Created by IntelliJ IDEA.
  User: YY
  Date: 2020/11/27
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showGoods</title>
</head>
<body>
您创建的商品信息如下：
<!-- 使用EL表达式取出model中的goods信息 -->
商品名称为:${goods.goodsname }
商品价格为:${goods.goodsprice }
商品名称为:${goods.goodsnumber }
</body>
</html>
