<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>CENTRO NOTIFICHE</h1>
		</div>
	</div>
</section>

<div class="container2">

	<article class="single">
		<div class="single_copy shadow p-3 mb-5 bg-white rounded">

			<div
				class="p-3 mb-2 bg-light text-dark shadow-sm p-3 mb-5 bg-white rounded single_copy_title">
				<h2 align="center">RICHIESTE PARTECIPAZIONE EVENTO</h2>
			</div>
			<c:forEach items="${notificherichieste}" var="notifica"
				varStatus="tagStatus">
				<p class="single_copy_meta">Il
					${notifica.day}/${notifica.month}/${notifica.year} alle
					${notifica.ora}:${notifica.minuti}</p>
				<p>${notifica.descrizione}</p>

				<a class="btn btn-primary btn-lg btn-block"
					href="${contextPath}/notifiche/getNotificaInfoToAccept?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}">ACCETTA</a>
				<a class="btn btn-secondary btn-lg btn-block"
					href="${contextPath}/notifiche/getNotificaInfoToDeny?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}">RIFIUTA</a>

			</c:forEach>

			<br> <br>

			<div
				class="p-3 mb-2 bg-light text-dark shadow-sm p-3 mb-5 bg-white rounded single_copy_title">
				<h2 align="center">RICHIESTE AMICIZIA</h2>
			</div>
			<c:forEach items="${notificheamicizia}" var="notifica"
				varStatus="tagStatus">
				<p class="single_copy_meta">Il
					${notifica.day}/${notifica.month}/${notifica.year} alle
					${notifica.ora}:${notifica.minuti}</p>
				<p>${notifica.descrizione}</p>
				<a class="btn btn-primary btn-lg btn-block"
					href="${contextPath}/notifiche/accettaAmicizia?username=${notifica.sender}&idnotifica=${notifica.id}">ACCETTA</a>
				<a class="btn btn-secondary btn-lg btn-block"
					href="${contextPath}/notifiche/rifiutaAmicizia?username=${notifica.sender}&idnotifica=${notifica.id}">RIFIUTA</a>
			</c:forEach>
		</div>
	</article>

</div>

<br>

<div
	class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded">
	<h1 align="center">NOTIFICHE COMUNI</h1>
</div>
<c:forEach items="${notifichecomuni}" var="notifica"
	varStatus="tagStatus">
	<section
		class="banner_notify shadow p-3 mb-5 bg-white rounded clearfix">

		<div class="container5">

			<div class="banner_copy">
				<div class="banner_copy_text">
					<p>
					<h4>${notifica.descrizione}</h4>
					</p>
					<p>${notifica.day}/${notifica.month}/${notifica.year}-
						${notifica.ora}:${notifica.minuti}</p>

					<a class="btn btn-outline-danger"
						href="${contextPath}/notifiche/getId?id=${notifica.id}">REMOVE</a>
				</div>
			</div>

		</div>

	</section>
</c:forEach>



<%@ include file="common/footer.jspf"%>