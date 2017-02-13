<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="head">
		<script type="text/x-mathjax-config">
	  		MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});
		</script>
		<script type="text/javascript"
			src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML">
		</script>
		<script type="text/x-mathjax-config">
			MathJax.Hub.Config({
		      "HTML-CSS": { linebreaks: { automatic: true } },
       	      SVG: { linebreaks: { automatic: true } }
			});
	    </script>
	</jsp:attribute>

	<jsp:attribute name="body">
	<h1 class="page-header">
		Korelace výsledků <small></small>
	</h1>
	Během testování se získává velké množství dat, které zpravidla obsahuje i určitý zlomek šumových dat,
	 a ta mohou mít za následek zkreslení výsledků a tím negativně ovlivnit vzešlé závěry. 
	 Pro jejich redukci je vhodné zařadit některou z metod korelace výsledků, která by měla pomoci odstranit tato šumová data. 
	 Mezi nejpoužívanější metody korelace patří Pearsonova korelace a Spearmanova korelace, které jsou popsány v sekcích níže.

<h3>Pearson korelace</h3>
Pro použití Personovy korelace se předpokládá, že vztah mezi rozsahem kvality a rozsahem skóre z hodnocení od pozorovatelů je lineární. 
Hlavním cílem je jednoduchou metodou ověřit, jestli skóre jednoho pozorovatele je konzistentní se skóre ostatních pozorovatelů z testovací události. 
\begin{equation}
    r(x,y)=\frac{\displaystyle\sum\limits_{i=1}^n x_i y_i - \frac{\left(\displaystyle\sum\limits_{i=1}^{n} x_i\right)\cdot \left(\displaystyle\sum\limits_{i=1}^n y_i\right)}{n}} {\displaystyle\sqrt{\left(\displaystyle\sum\limits_{i=1}^n x_i ^2 - \frac{\left(\displaystyle\sum\limits_{i=1}^n x_i\right)^2}{n}\right)\cdot\left(\displaystyle\sum\limits_{i=1}^n y_i ^2 - \frac{\left(\displaystyle\sum\limits_{i=1}^n y_i\right)^2}{n}\right)}}
\end{equation}
kde:
\begin{align*}
    &x_i :&& \text{průměrné skóre od pozorovatelů z trojice (algo, bitrate, scéna)}\\
    &y_i :&& \text{skóre individuálního pozorovatele ze stejné trojice}\\
    &n :&& \text{(počet algo)} \times \text{(počet scén)}\\
    &i:&&\text{druh kodeku, bitrate, číslo scény}
\end{align*}
<h3>Spearman rank korelace</h3>
Spearman rank korelace může být na rozdíl od Pearsonovy korelace použita, i když vztah mezi rozsahem kvality a rozsahem skóre pozorovatelů není lineární
(Obecně dává Pearson korelace velmi podobné výsledky jako Spearman rank korelace).
\begin{equation}
    r(x,y) = \left(1-\frac{\displaystyle6\cdot\sum\limits_{i=1}^n[R(x_i)-R(y_i)]^2}{n^3-n}\right)
\end{equation}
kde:
\begin{align*}
    &x_i:&&\text{průměrné skóre od pozorovatelů z trojice (algo, bitrate, scene)}\\
    &y_i:&&\text{skóre individuálního pozorovatele ze stejné trojice}\\
    &n:&&\text{(počet algo)} \times \text{(počet scén)}\\
    &R(x_i\text{ nebo }y_i):&&\text{sestupné pořadí}\\
    &i:&&\text{druh kodeku, bitrate, číslo scény}
\end{align*}
				
		<div>
			<br></br>
		</div>
	</jsp:attribute>
</my:pagetemplate>