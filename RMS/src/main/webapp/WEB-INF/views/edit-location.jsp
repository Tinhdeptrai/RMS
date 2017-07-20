<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-4">
		<div class="alert alert-default has-icon m-0" id="alert-edit-course">
			<i class="mdi mdi-information"></i>コースの追加、変更が終了したら完了ボタンを押して下さい。<br />編集内容を取り消す場合は取消ボタンを押して下さい。
		</div>
	</div>
	<div class="col-xs-7">
		<div class="alert alert-default has-icon m-0" id="alert-edit-location">
			<i class="mdi mdi-information"></i> 場所の追加、変更が終了したら完了ボタンを押して下さい。<br />編集内容を取り消す場合は取消ボタンを押して下さい。
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
							<td><a href="<c:url value="/course/${course.getCourseId()}/location/edit" />">${course.getCourseName()}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-4">
		<h3>点検場所一覧</h3>
		<div class="panel panel-default">
			<table
				class="table table-hover table-location table-editable edit-mode"
				id="table-location">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom"
							style="width: 50px;">No</th>
						<th class="text-center border-bottom" style="width: 442px;">場所</th>
						<th class="text-center border-bottom td-actions"><button
								type="button" class="btn btn-primary btn-raised">
								<span class="mdi mdi-plus-circle"></span>追加
							</button></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${locations}" var="location" varStatus="index">
						<tr>
							<td class="bg-index text-center">${index.index + 1}</td>
							<td>${ location.getLocationName()}</td>
							<td>
								<button type="button"
									class="btn btn-danger btn-raised btn-location-delete"
									data-id="${location.getLocationId()}"
									data-locationname="${location.getLocationName()}">
									<span class="mdi mdi-delete"></span>削除
								</button>
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
		<div class="table-editable-actions edit-mode"
			id="table-location-actions">
			<button type="button"
				class="btn btn-primary btn-raised btn-block btn-finish"
				id="btn-location-finish">完了</button>
			<button type="button"
				class="btn btn-danger btn-raised btn-block btn-cancel"
				id="btn-location-cancel">取消</button>
		</div>
	</div>
</div>
