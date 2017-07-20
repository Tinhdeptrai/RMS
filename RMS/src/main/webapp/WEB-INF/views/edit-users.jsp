<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-xs-11">
		<div class="alert alert-default" id="alert-edit-account">
			<strong><i class="mdi mdi-information"></i></strong>
			ユーザの追加、変更が終了したら完了ボタンを押して下さい。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;編集内容を取り消す場合は取消ボタンを押して下さい。
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
				class="table table-hover table-primary table-editable table-account edit-mode "
				id="table-js">
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
						<th class="text-center border-bottom td-actions" rowspan="2" style="width: 100px;">
							<button type="button" class="btn btn-primary btn-raised btn-add-new">
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
						<tr id="object-${user.id}">
							<td class="bg-index text-center">
								${index.index + 1}
							</td>
							<td class="firstname">
								<input type="text" name="firstname" class="input-inside-table update-mode update-${user.id}" value="${user.firstName}" data-id="${user.id}"/>
							</td>
							<td class="lastname">
								<input type="text" name="lastname" class="input-inside-table update-mode update-${user.id}" value="${user.lastName}" data-id="${user.id}"/>
							</td>
							<td class="firstname1">
								<input type="text" name="firstname1" class="input-inside-table update-mode update-${user.id}" value="${user.firstName1}" data-id="${user.id}"/>
							</td>
							<td class="lastname1">
								<input type="text" name="lastname1" class="input-inside-table update-mode update-${user.id}" value="${user.lastName1}" data-id="${user.id}"/>
							</td>
							<td class="username">
								<input type="text" name="username" class="input-inside-table update-mode update-${user.id}" value="${user.username}" data-id="${user.id}"/>
							</td>
							<td class="password">
								<input type="password" name="password" class="input-inside-table update-mode update-${user.id}" value="********" data-id="${user.id}"/>
							</td>
							<td class="role">
								<select class="select-inside-table update-mode update-${user.id}">
									<c:forEach items="${roles}" var="role">
										<option value="${role.getId()}" ${role.getId() == user.getRole().getId() ? 'selected' : ''}>${role.getRole()}</option>
									</c:forEach>
								</select>
							</td>
							<td class="text-center td-actions">
								<button type="button"
									class="btn btn-danger btn-raised btn-user-delete"
									data-id="${user.id}" data-name="${user.username}">
									<span class="mdi mdi-delete"></span>削除
								</button>
							</td>
						</tr>
					</c:forEach>
					<tr class="new-line hidden">
						<td class="bg-index text-center"></td>
						<td class="firstname">
							<input type="text" name="firstname" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="lastname">
							<input type="text" name="lastname" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##" />
						</td>
						<td class="firstname1">
							<input type="text" name="firstname1" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="lastname1">
							<input type="text" name="lastname1" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="username">
							<input type="text" name="username" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="password">
							<input type="password" name="password" class="input-inside-table update-mode-new-line update-mode update-##random##" data-id="##random##"/>
						</td>
						<td class="role">
							<select class="select-inside-table update-mode update-##random##" data-id="##random##">
								<c:forEach items="${roles}" var="role">
									<option value="${role.getId()}">${role.getRole()}</option>
								</c:forEach>
							</select>
						</td>
						<td class="text-center td-actions">
							<button type="button"
								class="btn btn-danger btn-raised btn-user-delete"
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
		<div class="table-editable-actions edit-mode"
			id="table-account-actions">
			<button type="button"
				class="btn btn-primary btn-raised btn-block btn-finish"
				id="btn-account-finish">完了</button>
			<button type="button"
				class="btn btn-danger btn-raised btn-block btn-cancel"
				id="btn-account-cancel">取消</button>
		</div>
	</div>
</div>

