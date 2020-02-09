<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover_studio">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Studio</h1>
			<a href="${contextPath}/eventCreator" class="button">Crea un
				evento</a>
		</div>
	</div>
</section>

<div class="container4">

	<section class="cards clearfix">
	
		<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">EVENTI GRUPPI STUDIO</h1></div>

		<div class="container_flex">
		<c:forEach items="${Events}" var="event" varStatus="tagStatus">
			<div class="item card shadow p-3 mb-5 bg-white rounded">
				<img class="card_image"
					src="${contextPath}/resources/images/LogoStudio.jpg" alt="Nature">
				<div class="card_copy">
					<h3 class="nome">${event.name}</h3>
						<p class="descrizione">${event.description}</p>
						<p class="descrizione">${event.luogo}</p>

				<div class="allinea_container">
					<div class="allinea_item">
						<a href="${contextPath}/eventi/askToJoin?idevento=${event.id}"
							class="button_partecipa">Partecipa</a>
					</div>
					<div class="allinea_item">
						<a href="${contextPath}/eventi/getEventId?idEvento=${event.id}"
							class="button_dettagli">Dettagli</a>
					</div>
				</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</section>

</div>

<%@ include file="common/footer.jspf"%>