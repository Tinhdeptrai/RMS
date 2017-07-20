<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="home" value="${pageContext.request.contextPath}/" />
<div class="row">
	<div class="col-xs-4">
		<div class="alert alert-default has-icon m-0" id="alert-select-course">
			<i class="mdi mdi-information"></i>
			点検コースの追加・削除、名前の変更をする場合は編集ボタンを押して下さい。<br />点検場所を変更する場合は変更したいコース名を選択して下さい。
		</div>
	</div>
	<div class="col-xs-7">
		<div class="alert alert-default has-icon m-0"
			id="alert-select-location">
			<i class="mdi mdi-information"></i>
			点検場所の追加・削除、順序の変更、名前の変更をする場合は編集ボタンを押して下さい。<br />点検項目を変更する場合は変更したい場所を選択して下さい。
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
		<h3>点検コース一覧</h3>
		<div class="panel panel-default">
			<table class="table table-hover table-course table-editable"
				id="table-course">
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
	<div class="col-xs-4">
		<h3>点検場所一覧</h3>
		<div class="panel panel-default">
			<table class="table table-hover table-location table-editable"
				id="table-location">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom"
							style="width: 50px;">No</th>
						<th class="text-center border-bottom">場所</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${locations}" var="location" varStatus="index">
						<tr>
							<td class="bg-index text-center">${index.index + 1}</td>
							<td><a
								href="<c:url value="/location/${location.getLocationId()}/abc" />">${ location.getLocationName()}</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-3">
		<h3>コースマップ</h3>
		<div class="form-group m-0">
			<input type="file" id="inputFile4" multiple="" />
			<div class="input-group">
				<span class="input-group-addon"><span
					class="mdi mdi-google-maps"></span></span> <input type="text" readonly=""
					class="form-control" /> <span class="input-group-btn">
					<button class="btn btn-default btn-raised" type="button">ファイル選択</button>
				</span>
			</div>
		</div>

	</div>
	<div class="col-xs-1">
		<h3>&nbsp;</h3>
		<div class="table-editable-actions" id="table-location-actions">
			<a href="<c:url value="/course/${currentCourse}/location/edit" />"
				class="btn btn-primary btn-raised btn-block btn-edit"
				id="btn-location-edit">編集</a>
		</div>
	</div>
</div>
