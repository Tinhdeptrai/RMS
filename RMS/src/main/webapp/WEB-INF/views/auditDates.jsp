<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
	<div class="col-xs-5">
		<div class="alert alert-default has-icon mb-0">
			<i class="mdi mdi-information"></i>認したいコース名を選択して下さい。
		</div>
	</div>
	<div class="col-xs-5">
		<div class="alert alert-default has-icon mb-0">
			<i class="mdi mdi-information"></i>確認したい点検日を選択して下さい。<br />サマリを確認する時はサマリ表示ボタンを押して下さい。

		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-5">
		<h3>点検コース一覧</h3>
		<div class="panel panel-default">
			<table class="table table-hover table-course" id="table-course">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom"
							style="width: 50px;">No</th>
						<th class="text-center border-bottom">コース名</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courses}" var="course" varStatus="index">
						<tr>
							<td class="bg-index text-center">${index.index + 1}</td>
							<td>
								<a href="<c:url value="/course/${course.getCourseId()}/date" />">${course.getCourseName()}</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-5">

		<h3>点検日一覧</h3>
		<div class="panel panel-default">
			<table class="table table-hover table-date" id="table-date">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom"
							style="width: 50px;">No</th>
						<th class="text-center border-bottom">点検日時</th>
						<th class="text-center border-bottom" style="width: 50px;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${auditDates}" var="auditDate" varStatus="index">
						<tr>
							<td class="bg-index text-center">${index.index + 1}</td>
							<td><fmt:formatDate value="${auditDate.getDate()}" pattern="dd/MM/yyyy HH:mm" /></td>
							<c:choose>
		                		<c:when test="${auditDate.getStatus() eq true}">
		                			<td class="text-center bg-success">良</td>
		                		</c:when>
		                		<c:otherwise>
		                			<td class="text-center bg-danger">否</td>
	                		 	</c:otherwise>
	                		</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-2">
		<h3>&nbsp;</h3>
		<a href="02-04-summary-display.html"
			class="btn btn-primary btn-raised btn-block m-0">サマリ表示</a>
	</div>
</div>


<script>
	$(document).ready(function() {
		$('.alert').matchHeight({
			byRow : false
		});
		$('#table-course tbody tr').click(function() {
			$(location).attr('href', '02-02-date-selection.html');
		});
		$('#table-date tbody tr').click(function() {
			$(location).attr('href', '02-03-achievement-display.html');
		});
		$('#table-course, #table-date').DataTable({
			"scrollY" : 400,
			"paging" : false,
			"ordering" : false,
			"info" : false,
			"searching" : false
		});
	});
</script>