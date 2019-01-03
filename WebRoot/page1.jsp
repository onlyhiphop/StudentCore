<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<body>
		<center>
			<h3>输入课程编号为 ${courseNo } 的所有学生成绩</h3>
			<form name="form1" action="${pageContext.request.contextPath }/UpdateServlet" method="get">
				<input type="submit" value="提交成绩"/>
				<table>
					<tr>
						<td>学号</td>
						<td>姓名</td>
						<td>考试类型</td>
						<td>分数</td>
					</tr>
					<input type="hidden" name="courseNo" value="${courseNo }" />	
					<c:forEach var="item" items="${scoreList }" step="1">
						<tr>
							<td>${item.stuNo }</td>						
							<td>${item.stuName }</td>						
							<td>${item.type }</td>						
							<td>
								<input type="text" name="score" value="${item.core }">
							</td>				
							<input type="hidden" name="stuNo" value="${item.stuNo }" />	
							<input type="hidden" name="type" value="${item.type }" />	
						</tr>
					</c:forEach>
				</table>
			</form>
		</center>
	</body>
</html>
