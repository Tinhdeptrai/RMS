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
		<div class="alert alert-default has-icon m-0" id="alert-edit-course"
			style="display: none;">
			<i class="mdi mdi-information"></i>コースの追加、変更が終了したら完了ボタンを押して下さい。<br />編集内容を取り消す場合は取消ボタンを押して下さい。
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
		<h3>点検コース一覧</h3>
		<div class="panel panel-default">
			<table
				class="table table-hover table-primary table-editable table-account edit-mode "
				id="table-js">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom"
							style="width: 50px;">No</th>
						<th class="text-center border-bottom" style="width: 442px;">コース名</th>
						<th class="text-center border-bottom td-actions"><button
								type="button" class="btn btn-primary btn-raised  btn-add-new">
								<span class="mdi mdi-plus-circle"></span>追加
							</button></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courses}" var="course" varStatus="index">
						<tr id="object-${course.getCourseId()}">
							<td class="bg-index text-center">${index.index + 1}</td>
							<td class="course-name">
								<input type="text" name="name" class="input-inside-table update-mode update-${course.getCourseId()}" value="${course.getCourseName()}" data-id="${course.getCourseId()}"/>
							</td>
							<td class="text-center bg-info td-actions">
								<button type="button"
									class="btn btn-danger btn-raised btn-course-delete"
									data-id="${course.getCourseId()}">
									<span class="mdi mdi-delete"></span>削除
								</button>
							</td>
						</tr>
					</c:forEach>
					<tr class="new-line hidden">
						<td class="bg-index text-center"></td>
						<td class="course-name">
							<input type="text" name="name" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="text-center td-actions">
							<button type="button"
								class="btn btn-danger btn-raised btn-course-delete"
								data-id="##random##" data-name = "">
								<span class="mdi mdi-delete"></span>削除
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-1">
		<h3>&nbsp;</h3>
		<div class="table-editable-actions edit-mode"
			id="table-course-actions">
			<button type="button"
				class="btn btn-primary btn-raised btn-block btn-finish"
				id="btn-course-finish">完了</button>
			<button type="button"
				class="btn btn-danger btn-raised btn-block btn-cancel"
				id="btn-course-cancel">取消</button>
		</div>
	</div>
</div>
