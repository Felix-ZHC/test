<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="js/WdatePicker.js"></script>
</head>
<body>
	<form:form action="update.do" method="post" modelAttribute="faqs">
		<form:hidden path="id" /><br>
		标题：<form:input path="title" /><br>
		创建时间：<form:input path="createdate" class="Wdate"
			onClick="WdatePicker()" /><br>
		内容：<form:textarea path="content" /><br>
		类型：<form:select path="classid">
			<form:options  items="${list}" itemLabel="cname" itemValue="id"/>
			<%-- <c:forEach items="${list}" var="c">
				<form:option value="${c.id}">${c.cname}</form:option>
			</c:forEach> --%>
		</form:select><br>
		<form:button>提交</form:button>
	</form:form>
</body>
</html>