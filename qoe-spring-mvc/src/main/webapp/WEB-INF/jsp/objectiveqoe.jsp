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
	</jsp:attribute>

	<jsp:attribute name="body">
	<h1 class="page-header">
		Objektivní QoE <small></small>
	</h1>
	<div>
		Objektivní QoE se vyhodnocuje zpravidla strojově, což vede na rozdíl od subjektivního QoE k menší náročnosti na lidské a finanční zdroje, 
		proto se někdy upřednostňují objektivní metody před subjektivními. Objektivní metody měření kvality se dají rozčlenit do 3 skupin:
		<ul>
			<li>plná reference,</li>
			<li>redukovaná reference,</li>
			<li>bez reference.</li>
		</ul>
		Některé z těchto metod jsou založeny na zahrnutí původního referenčního signálu v měření.
		Plná reference vyžaduje původní materiál v celku. 
		Operují na základě porovnávání původního s pozměněným či narušeným signálem k vypočítání degradace. 
		Výpočty této degradace se pohybují od jednoduchých algoritmů typu odhadu chyb v signálu k velmi 
		komplexním.
		Plná reference vyžaduje původní materiál v celku. Operují na základě porovnávání původního s pozměněným či narušeným signálem k vypočítání degradace. 
		Výpočty této degradace se pohybují od jednoduchých algoritmů typu odhadu chyb v signálu k velmi komplexním.
		Redukovaná reference používá část původního videa pro výpočet degradace. Jsou vhodné pro situace, 
		kde je původní obsah těžké uložit nebo přenést na místo určení nebo výpočetní výkon je limitován. 
		Objektivní metoda bez reference nepoužívá žádnou část původního obsahu. Nezávisí na porovnání s původním signálem, 
		ale na měření externích faktorů k vytvoření modelu QoE. Modely bez reference jsou obvykle určeny pro specifické aplikace a nejsou vhodné k obecnému použití, 
		ale vyžadují nejméně zdrojů a jsou užitečné v případě, kdy původní obsah není dostupný.
		
		Mezi metody objektivního měření QoE patří:
		<ul>
			<li>PSNR (Peak Signal to Noise Ratio),</li>
			<li>VQM (Video Quality Metric),</li>
			<li>MPQM (Moving Picture Quality Metric),</li>
			<li>SSIM (Structural Similarity Index),</li>
			<li>QM (Noise Quality Measure).</li>
		</ul>
		Metoda PSNR je navržena pro obecnější použití, protože dokáže detekovat chyby v jakémkoliv typu signálu.
		 Je často používaná pro hodnocení kvality obrazu a hodnocení kvality videa, díky své jednoduchosti. 
		 PSNR je odvozena nastavováním střední mocniny chyby (MSE), ve vztahu k maximální možné hodnotě jasu 
		 (například pro 8-bitové hodnoty je to $2^8-1 = 255$) jako v následující rovnici:
		 
		 \begin{equation}
		   MSE = \frac{\displaystyle\sum\limits_{i=1}^{M}  \sum\limits_{j=1}^{N} [f(i,j)-F(i,j)]^2}{M\times N}
		\end{equation}
		\begin{equation}
		    PSNR = 20\cdot\log_{10}\left(\frac{255}{\sqrt{MSE}}\right)
		\end{equation}
		kde:
		\begin{align*}
		    &f(i,j):&&\text{je původní signál na pixelu $(i,j)$}\\
		    &F(i,j):&&\text{je rekonstruovaný signál}\\
		    &M\times N:&&\text{je velikost obrázku}
		\end{align*}
		Výsledkem je číslo v decibelech v rozmezí od 30 do 40 decibelů pro středně až vysoce kvalitní videa.
		<div>
			<br></br>
		</div>
	</div>
	
	
			
	</jsp:attribute>
</my:pagetemplate>