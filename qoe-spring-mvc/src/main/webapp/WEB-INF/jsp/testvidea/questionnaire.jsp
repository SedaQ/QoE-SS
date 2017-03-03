<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="body">
		
		<h1 class="page-header">
			Prosím vyplňte následující dotazník před zahájením testování QoE <small></small>
		</h1>
		<div class="col-md-4 col-md-offset-4">
			<form:form method="post"
				action="${pageContext.request.contextPath}/video/questionnairefilled"
				modelAttribute="questionaryCreate"
				enctype="multipart/form-data;charset=UTF-8">
				<div class="form-group">
				  <label for="email">Email:</label>
				  <input type="email" class="form-control" name="email" id="email"
						placeholder="Enter a valid email address" required="true" />
				</div>
				<div class="form-group">
				  <label for="age">Věk:</label>
				  <input type="number" min="1" max="150" class="form-control"
						name="age" id="age" placeholder="Enter age" required="true">
				</div>
				<label>Vyberte svoje pohlaví:</label>
				<div class="form-group">
					<label class="radio-inline">
					<input type="radio" id="gender" name="gender" value="muz" checked>muž</label>
					<label class="radio-inline">
					<input type="radio" id="gender" name="gender" value="zena">žena</label>
				</div>
				<div class="form-group">
				  <label for="school">Dosažené vzdělání:</label>
				  <select class="form-control" name="school" id="school"
						required="true">
				    <option>zakladni</option>
				    <option>stredni_skola</option>
				    <option>vysoka_skola</option>
				  </select>
				</div>
				<div class="form-group">
				  <label for="userConnection">Typ připojení k internetu:</label>
				  <select class="form-control" name="userConnection"
						id="userConnection" required="true">
				    <option>wifi_pripojeni</option>
				    <option>pripojeni_kabelem</option>
				  </select>
				</div>
				<button type="submit" class="btn btn-primary">Start video</button>
			</form:form>
			<br />
			<br />
		</div>
	</jsp:attribute>
</my:pagetemplate>