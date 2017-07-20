<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-4 col-xs-offset-4">
		<div class="panel panel-default panel-home">
			<div class="panel-body">
				<a href="<c:url value="/course" />"
					class="btn btn-primary btn-raised btn-block btn-xl m-0">点検データ確認</a>
				<a href="<c:url value="/course/view-list-cosese" />"
					class="btn btn-primary btn-raised btn-block btn-xl m-0 mt-15">点検コース作成・変更</a>
				<a href="<c:url value="/user" />"
					class="btn btn-primary btn-raised btn-block btn-xl m-0 mt-15">ユーザ設定</a>
				<a href="<c:url value="/logout" />"
					class="btn btn-primary btn-raised btn-block btn-xl m-0 mt-15">データ連系</a>
			</div>
		</div>
	</div>
</div>
