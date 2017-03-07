<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="js/WdatePicker.js" ></script>
</head>
<body>
	<form action="insert.do" method="post" >
		标题：<input name="title" /><br>
		创建时间：<input class="Wdate" name="createdate" onClick="WdatePicker()" /><br>
		内容：<input name="content" /><br>
		类型：<select name="classid">
			<c:forEach items="${list}" var="c">
				<option label="${c.cname}" value="${c.id}"/>
			</c:forEach>
		</select><br>
		<input type="submit" value="提交"><br>
		<input type="reset" value="重置"><br>
		<input type="button" value="返回" onclick="javascript:window.localhost.go(-1)">
	</form>
</body>
</html>