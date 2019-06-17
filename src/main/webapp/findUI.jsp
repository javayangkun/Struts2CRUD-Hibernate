<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 400px;
	height: 400px;
	text-align: center;
	margin-top: 80px;
}

a {
	text-decoration: none;
	cursor: pointer;
}
</style>
<link
	href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<table class="table  table-bordered table-hover table-striped">
		<caption>
			<font size="5">用户列表</font>
		</caption>
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>时间</th>
			<th>金钱</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach var="page" items="${page.list}">
			<tr>
				<td>${page.id }</td>
				<td>${page.name }</td>
				<td>${page.birthday }</td>
				<td>${page.money}</td>
				<td><a href="User_updateUI?id=${page.id }">编辑</a></td>
				<td><a href="User_delete?id=${page.id }">删除</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="6"><a href="User_find?p=1">首页</a> <a
				href="User_find?p=${page.prev }">上一页</a> <c:forEach
					begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${page.p == x }">
						<font color="red"> ${x } </font>
					</c:if>
					<c:if test="${page.p != x }">
						<a href="User_find?p=${x }"> ${x } </a>
					</c:if>
				</c:forEach> <a href="User_find?p=${page.next }">下一页</a> <a
				href="User_find?p=${page.maxPage }">末页</a> <font color="red"
				size="3"> ${page.p} </font> /${page.maxPage }
				<form action="User_find" style="display: inline;">
					跳到第<input size="1" type="text" name="p" />页
					<button type="submit">GO</button>
				</form></td>
		</tr>

	</table>
</body>
</html>