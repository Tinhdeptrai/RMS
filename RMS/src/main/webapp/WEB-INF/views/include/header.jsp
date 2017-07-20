<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-xs-6">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value='/home' />">現場点検ッステム</a>
		</div>
	</div>
	<div class="col-xs-6 text-right">
		<span>口グイン中： ${loggedinuser}</span>&nbsp;&nbsp; <a
			href="<c:url value='/logout' />" class="btn btn-danger btn-raised"><span
			class="mdi mdi-logout-variant" aria-hidden="true"></span> ログアウト</a>
	</div>
</div>
