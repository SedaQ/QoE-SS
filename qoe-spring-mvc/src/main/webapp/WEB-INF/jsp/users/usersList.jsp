<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="body">
			<h1 class="page-header">
				Uživatelé, kteří podstoupili testování <small></small>
			</h1>
			<table class="table">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>Email</th>
			      <th>Věk</th>
			      <th>Dosažené vzdělání</th>
			      <th>Typ připojení</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${questionaries}" var="questionary" varStatus="loop">
			    <tr>
			      <th scope="row">${loop.count}</th>
			      <td><c:out value="${questionary.email}" />
						</td>
			      <td><c:out value="${questionary.age}" />
						</td>
			      <td><c:out value="${questionary.school}" />
						</td>
			      <td><c:out value="${questionary.userConnection}" />
						</td>
			    </tr>
		      </c:forEach>
			  </tbody>
			</table>
	</jsp:attribute>
</my:pagetemplate>