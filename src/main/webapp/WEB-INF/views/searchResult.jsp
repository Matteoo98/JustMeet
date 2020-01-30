<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Risultati della ricerca "${searched}"</h1>
		</div>
	</div>
</section>

<div class="container4">

<section class="cards clearfix">

	<c:forEach items="${ricerca}" var="event" varStatus="tagStatus">
		<div class="card shadow p-3 mb-5 bg-white rounded">
			<img class="card_image"
				src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
			<div class="card_copy">
				<h3>${event.name}</h3>
				<p>Descrizione : ${event.description}</p>
				<p>Luogo : ${event.luogo}</p>

				<br>

				<div class="allinea">
					<a href="${contextPath}/eventi/getEventId?idEvento=${event.id}"
						class="button_dettagli">Dettagli</a>
				</div>

				<div class="allinea">
					<a href="${contextPath}/eventi/askToJoin?idevento=${event.id}"
						class="button_partecipa">Partecipa</a>
				</div>

			</div>
		</div>
	</c:forEach>

</section>

</div>

<%@ include file="common/footer.jspf"%>