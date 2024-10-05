<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>相应不同类型的文件</title>
  <style>
    ul li {
      list-style: none;
      float: left;
      margin-top: 40px;
    }

    ul li a {
      padding: 20px 50px;
      height: 40px;
      background-color: #00897b;
      color: #fff;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;
    }

    ul li a:hover {
      background-color: #ea8363;
    }
  </style>
</head>
<body>
<h1><%= "设置Content-Type不同类型的资源" %></h1>
<br/>
<h2><%= "根据不同的参数类型返回不同的资源" %></h2>
<br/>
<ul>
  <li>
    <a href="/download?a=photo">下载图片</a>
  </li>
  <li>
    <a href="/download?a=txt">下载文件</a>
  </li>

  <li>
    <a href="/res?type=img">返回图片</a>
  </li>
  <li>
    <a href="/servletContextDemo02" >返回txt</a>
  </li>
  <li>
    <a href="/viewPdf">pdf</a>
  </li>
</ul>
</body>
</html>