<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Risultati della ricerca</h1>
		</div>
	</div>
</section>

<div class="container4">  

<section class="cards clearfix">
	<c:forEach items="${ricercati}" var="user" varStatus="tagStatus">
		<div class="card shadow p-3 mb-5 bg-white rounded">
			<c:choose>
				<c:when test="${user.username=='Pato07'}">
					<img class="card_image"
						src="https://i.pinimg.com/originals/d4/51/00/d4510008149492dd4d554d20d426bea9.jpg">
				</c:when>

				<c:when test="${user.username=='Kaka22'}">
					<img class="card_image"
						src="https://www.pianetamilan.it/wp-content/uploads/sites/23/2016/03/Kak%C3%A0_Milan_Chievo_2013_Getty_Images.jpg"
						alt="Nature">
				</c:when>

				<c:otherwise>
					<img class="card_image"
						src="${contextPath}/resources/images/persona.jpg" alt="Nature">
				</c:otherwise>
			</c:choose>
			<div class="card_copy">
				<h3>${user.username}</h3>
				<p>Email : ${user.email}</p>
				<p>Citt� : ${user.citta}</p>

				<br>

				<div class="allinea">
					<a
						href="${contextPath}/eventView/account?nomeUser=${user.username}"
						class="button_dettagli">Dettagli</a>
				</div>

				<div class="allinea">
					<a href="${contextPath}/amici/add?username=${user.username}"
						class="button_partecipa">Aggiungi</a>
				</div>

			</div>
		</div>
	</c:forEach>

</section>

</div>

<%@ include file="common/footer.jspf"%>