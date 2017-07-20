<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="現場点検システム">
<meta name="author" content="tps">
<link rel="apple-touch-icon-precomposed" sizes="57x57"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-57x57.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-114x114.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-72x72.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-144x144.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="60x60"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-60x60.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="120x120"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-120x120.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="76x76"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-76x76.png' />" />
<link rel="apple-touch-icon-precomposed" sizes="152x152"
	href="<c:url value ='/static/images/favicon/apple-touch-icon-152x152.png' />" />
<link rel="icon" type="image/png"
	href="<c:url value ='/static/images/favicon/favicon-196x196.png" sizes="196x196' />" />
<link rel="icon" type="image/png"
	href="<c:url value ='/static/images/favicon/favicon-96x96.png" sizes="96x96' />" />
<link rel="icon" type="image/png"
	href="<c:url value ='/static/images/favicon/favicon-32x32.png" sizes="32x32' />" />
<link rel="icon" type="image/png"
	href="<c:url value ='/static/images/favicon/favicon-16x16.png" sizes="16x16' />" />
<link rel="icon" type="image/png"
	href="<c:url value ='/static/images/favicon/favicon-128.png" sizes="128x128' />" />
<title>現場点検システム</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value ='/static/css/bootstrap.css" rel="stylesheet' />" />
<!-- Google Material Design Icons -->
<link
	href="<c:url value ='/static/css/materialdesignicons.css" rel="stylesheet' />" />
<!-- Bootstrap plugin -->
<link
	href="<c:url value ='/static/css/bootstrap-select.css" rel="stylesheet' />" />
<link
	href="<c:url value ='/static/css/bootstrap-datetimepicker.css" rel="stylesheet' />" />
<!-- Data Table -->
<link
	href="<c:url value ='/static/css/dataTables.bootstrap.css" rel="stylesheet' />" />
<link
	href="<c:url value ='/static/css/fixedHeader.bootstrap.css" rel="stylesheet' />" />
<link
	href="<c:url value ='/static/css/fixedColumns.bootstrap.css" rel="stylesheet' />" />
<link
	href="<c:url value ='/static/css/rowReorder.bootstrap.css" rel="stylesheet' />" />
<!-- Material Design Theme -->
<link href="<c:url value ='/static/css/ripples.css" rel="stylesheet' />" />
<link
	href="<c:url value ='/static/css/bootstrap-material-design-custom.css" rel="stylesheet' />" />
<script src="<c:url value = '/static/js_page/main.js'/>"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<tiles:insertAttribute name="header" ignore="true" />
		</div>
	</nav>
	<section class="content">
		<div class="container">
			<tiles:insertAttribute name="body" ignore="true" />
		</div>
	</section>
	<!-- Bootstrap core JavaScript
        ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value = '/static/js/jquery.js'/>"></script>
	<script src="<c:url value = '/static/js/bootstrap.js'/>"></script>
	<script src="<c:url value = '/static/js/ripples.js'/>"></script>
	<script src="<c:url value = '/static/js/material.js'/>"></script>
	<script src="<c:url value = '/static/js/bootstrap-select.js'/>"></script>
	<script src="<c:url value = '/static/js/moment-with-locales.js'/>"></script>
	<script
		src="<c:url value = '/static/js/bootstrap-datetimepicker.min.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.matchHeight.js'/>"></script>
	<script src="<c:url value = '/static/js/jquery.dataTables.js'/>"></script>
	<script src="<c:url value = '/static/js/dataTables.bootstrap.js'/>"></script>
	<script src="<c:url value = '/static/js/dataTables.fixedHeader.js'/>"></script>
	<script src="<c:url value = '/static/js/dataTables.fixedColumns.js'/>"></script>
	<script src="<c:url value = '/static/js/common.js'/>"></script>
</body>
</html>
