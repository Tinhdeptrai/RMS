<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input class="hidden" id="homePath"
	value="${pageContext.request.contextPath}/">
<div class="row">
	<div class="col-xs-4">
		<div class="alert alert-default has-icon m-0" id="alert-select-course">
			<i class="mdi mdi-information"></i>
			点検コースの追加・削除、名前の変更をする場合は編集ボタンを押して下さい。<br />点検場所を変更する場合は変更したいコース名を選択して下さい。
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
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
							<td><a
								href="<c:url value="/course/${course.getCourseId()}/location" />">${course.getCourseName()}</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-1">
		<h3>&nbsp;</h3>
		<div class="table-editable-actions" id="table-course-actions">
			<a href="<c:url value="edit-course" />"
				class="btn btn-primary btn-raised btn-block btn-edit"
				id="btn-course-edit">編集</a>
		</div>
	</div>
</div>
