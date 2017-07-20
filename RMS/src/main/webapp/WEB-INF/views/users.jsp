<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-xs-11">
		<div class="alert alert-default" id="alert-select-account">
			<strong><i class="mdi mdi-information"></i></strong>
			ユーザの追加・削除、内容の変更をする場合は編集ボタンを押して下さい。
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-11">
		<div class="row">
			<div class="col-xs-2">
				<h3>録ユーザ一覧</h3>
			</div>
		</div>
		<div class="panel panel-default">
			<table
				class="table table-hover table-primary table-editable table-account"
				id="table-account">
				<thead>
					<tr>
						<th class="bg-index text-center border-bottom" rowspan="2"
							style="width: 50px;">No</th>
						<th class="text-center" colspan="2">ユーザ名<br />漢字
						</th>
						<th class="text-center" colspan="2">ユーザ名<br />カナ
						</th>
						<th class="text-center border-bottom" rowspan="2">ューザーＩＤ</th>
						<th class="text-center border-bottom" rowspan="2">パスワード</th>
						<th class="text-center border-bottom" rowspan="2">役割</th>
						<th class="text-center border-bottom td-actions" rowspan="2"
							style="width: 100px;"><button type="button"
								class="btn btn-primary btn-raised">
								<span class="mdi mdi-plus-circle"></span>追加
							</button></th>
					</tr>
					<tr>
						<th class="text-center border-bottom">（姓）</th>
						<th class="text-center border-bottom">（名）</th>
						<th class="text-center border-bottom">（姓）</th>
						<th class="text-center border-bottom">（名）</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${users}" var="user" varStatus="index">
						<tr>
							<td class="bg-index text-center">${index.index + 1}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.firstName1}</td>
							<td>${user.lastName1}</td>
							<td>${user.username}</td>
							<td>********</td>
							<td>${user.getRole().getRole()}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-xs-1">
		<h3>&nbsp;</h3>
		<div class="table-editable-actions" id="table-account-actions">
			<a href="<c:url value="user/edit-users" />"
				class="btn btn-primary btn-raised btn-block btn-edit"
				id="btn-account-edit">編集</a>
		</div>
	</div>
</div>