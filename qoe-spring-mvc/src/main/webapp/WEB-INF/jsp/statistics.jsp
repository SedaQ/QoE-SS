<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="head">
		<script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
		
	</jsp:attribute>
	<jsp:attribute name="body">
			<h1 class="page-header">
				Statistiky <small></small>
			</h1>
			<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<script type="text/javascript">
		window.onload = function() {
			var chart = new CanvasJS.Chart("chartContainer", {
				theme : "theme2",//theme1
				title : {
					text : "Basic Column Chart - CanvasJS"
				},
				animationEnabled : false, // change to true
				data : [ {
					// Change type to "bar", "area", "spline", "pie",etc.
					type : "column",
					dataPoints : [ {
						label : "apple",
						y : 10
					}, {
						label : "orange",
						y : 15
					}, {
						label : "banana",
						y : 25
					}, {
						label : "mango",
						y : 30
					}, {
						label : "grape",
						y : 44
					} ]
				} ]
			});
			chart.render();
		}
	</script>
	</jsp:attribute>
</my:pagetemplate>