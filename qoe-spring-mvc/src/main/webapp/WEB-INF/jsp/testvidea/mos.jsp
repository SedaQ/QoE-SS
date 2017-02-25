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
		  Ohodnoťte přehrané video na stupnici MOS<small></small>
	    </h1>
	    <section class="container">
	   	    <article class="row">
				<div class="col-md-3">
					<form:form method="post"
				action="${pageContext.request.contextPath}/mos/sendevaluation"
				modelAttribute="mosCreateDTO"
				enctype="multipart/form-data;charset=UTF-8">
						<div class="form-group">
						  <label for="school">Hodnocení MOS</label>
						  <select class="form-control" name="mosValue" id="mosValue" required="true">
						    <option>5</option>
						    <option>4</option>
						    <option>3</option>
						    <option>2</option>
						    <option>1</option>
						  </select>
						</div>
		  				<!-- <input type="hidden" name="questionary" value="${questionaryObj}" />
						<input type="hidden" name="video" value="${videoObj}" />
						<input type="hidden" name="scenario" value="${scenarioObj}" /> -->
						  
						<button type="submit" class="btn btn-primary">Odešli hodnocení</button>
					</form:form>
					<br />
					<br />
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-3">
				    <label>Hodnotící škála MOS</label>
					<table class="table table-bordered">
					    <tbody>
					      <tr>
					        	<td>5</td>
								<td>Excellent (vynikající)</td>
					       </tr>
					       <tr>
					       		<td>4</td>
								<td>Good (dobrá)</td>
							</tr>
				     	    <tr>
					       		<td>3</td>
								<td>Fair (průměrná)</td>
							</tr>
				     	    <tr>
					       		<td>2</td>
								<td>Poor (špatná)</td>
							</tr>
				     	    <tr>
					       		<td>1</td>
								<td>Bad (mizerná)</td>
							</tr>
					    </tbody>
				  	</table>
				</div>
			</article>
		</section>
	</jsp:attribute>
</my:pagetemplate>