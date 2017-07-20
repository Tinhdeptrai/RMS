<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-xs-5">
		<div class="alert alert-default has-icon mb-0">
			<i class="mdi mdi-information"></i>確認したいコース名を選択して下さい。
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
</div>

<script>
$(document).ready(function() {
    $('.alert').matchHeight({
        byRow : false
    });
    $('#table-course tbody tr').click(function(){
        $(location).attr('href', '02-02-date-selection.html');
    });
    $('#table-course, #table-date').DataTable({
        "scrollY": 400,
        "paging": false,
        "ordering": false,
        "info": false,
        "searching": false
    });
});
	</script>