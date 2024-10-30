<%@ page import="top.soft.bookonline.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>图书详情页面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
  <style type="text/css">
    /* 其他样式保持不变 */

    /* 新增价格样式 */

    .price {
      color: #ff5722; /* 橙色 */
      font-weight: bold; /* 加粗 */
      font-size: 32px; /* 字体大小 */
    }

    .description {
      color: rgba(0, 0, 0, 0.62); /* 设置字体颜色，您可以根据需要更改颜色值 */
      font-weight: bold; /* 加粗字体 */
      font-size: 18px; /* 增加字体大小 */
    }

    /* 可以添加其他样式来美化页面 */
  </style>
</head>
<body>
<%
  Book book = (Book) request.getAttribute("book");
  if (book == null) {
    out.println("<p>未找到图书信息，请检查数据是否正确传递。</p>");
    return; // 如果book为null，停止后续处理
  }
%>

<div id="top">
  <jsp:include page="top.jsp"/>
  <!-- 如果top.jsp中包含图片，您也可以直接在这里注释掉或删除以下行 -->
  <!-- <img src="${pageContext.request.contextPath}/images/top-image.png"> -->
</div>

<div id="search">
  <h2>读书时刻</h2>
  <input type="text" placeholder="书名、作者、ISBN" class="search-input">
  <div class="search-btn">
    <!-- 注释掉搜索按钮图片 -->
    <!-- <img src="${pageContext.request.contextPath}/images/search.png"> -->
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-8">
      <p style="font-weight: bold;font-size: 22px;color: #232525">${book.name}</p>
      <hr>
      <div class="row">
        <div class="col-4">
          <img src="${book.cover}" alt="书籍封面"> <!-- 显示封面 -->
        </div>
        <div class="col-6">
          <p style="color: #bdbdbd; font-size: 16px; font-weight: bold; margin-bottom: 10px;">作者: ${book.author}</p>
          <p class="price">价格: <%= book.getPrice() %> 元</p><!-- 应用价格样式 -->
          <!-- 在这里添加书籍的详细介绍 -->
          <p class="description">详细介绍: 我是<%= book.getDescription() %> </p>
        </div>
      </div>
    </div>
    <!-- 注释掉右侧热门标签和图片 -->
    <!-- <div class="col-4">
      <h3>热门标签</h3>
      <hr>
      <img src="${pageContext.request.contextPath}/images/right.png">
    </div> -->
  </div>
</div>
</body>
</html>