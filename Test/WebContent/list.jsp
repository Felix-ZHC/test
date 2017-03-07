<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="InsertInit.do">新增</a><br>
	标题:<input name="title" value="${title}">
	<table border="1">
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>创建时间</th>
			<th>详情</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="f" varStatus="num">
			<tr>
				<td>${f.id}</td>
				<td>${f.title}</td>
				<td>${f.createdate}</td>
				<td>${f.content}</td>
				<td>${f.classes.cname}</td>
				<td>
					<a href="findById.do?id=${f.id}">修改</a>
					<a href="deleteById.do?id=${f.id}" onclick="return confirm('确认删除?')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="findByTitle.do?pageIndex=1">首页</a>
	<a href="findByTitle.do?pageIndex=${page.pageIndex-1}">上一页</a>
	<a href="findByTitle.do?pageIndex=${page.pageIndex+1}">下一页</a>
	<a href="findByTitle.do?pageIndex=${page.pageCount}">末页</a>
</body>
</html>