<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<ol class="breadcrumb">
		<li><a href="<c:url value="/home" />"><i class="mdi mdi-home"></i> 点検データ確認</a></li>
			<c:forEach items="${breadcrumbs}" var="breadcrumb" varStatus="status">
		        <li>
		        	<c:choose>
		                <c:when test="${breadcrumb.getUrl() eq '#'}">
	                		<c:choose>
		                		<c:when test="${breadcrumb.getValue() eq ''}">
		                			${breadcrumb.getName()} 
		                		</c:when>
		                		<c:otherwise>
		                			${breadcrumb.getName()} <span class="badge badge-info">${breadcrumb.getValue()}</span>
	                		 	</c:otherwise>
	                		</c:choose>
		                </c:when>
		                <c:otherwise>
		                	<a href="${breadcrumb.getUrl()}">
		                		<c:choose>
			                		<c:when test="${breadcrumb.getValue() eq ''}">
			                			${breadcrumb.getName()} 
			                		</c:when>
			                		<c:otherwise>
			                			${breadcrumb.getName()} <span class="badge badge-info">${breadcrumb.getValue()}</span>
		                		 	</c:otherwise>
		                		</c:choose>
							</a>
		                </c:otherwise>
		            </c:choose>
	            </li>
		    </c:forEach>
		</ol>
	</div>
</div>