<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="body">
			<h1 class="page-header">
				K náhledu celá práce zabývající se QoE measurement <small></small>
			</h1>
			<div class='embed-responsive' style='padding-bottom: 150%'>
			    <embed 
				src='${pageContext.request.contextPath}/assets/pdf/DP.pdf'
				type='application/pdf' width='100%' height='100%'></embed>
			</div>
			
	</jsp:attribute>
</my:pagetemplate>