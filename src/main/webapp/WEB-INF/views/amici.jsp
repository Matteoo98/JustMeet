<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>AMICI</h1>
		</div>
	</div>
</section>
<br>

<div class="container2">

	<div id="myBtnContainer" class="button_Sh_My allinea_dx">
		<form:form class="form-inline my-2 my-lg-0" name="searchFriend"
			id="contattaci" action="amici/search" method="POST">
			<input class="form-control mr-sm-2" type="search" name="searchFriend"
				placeholder="Cerca nuovi amici.." aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
				<i class="fa fa-search"></i> Cerca
			</button>
		</form:form>
	</div>
</div>

<br><br><br>

<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">

			<section class="cards clearfix">
				
				<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">TUOI AMICI</h1></div>

				<div class="container4">

					<c:forEach items="${listaAmici}" var="user" varStatus="tagStatus">

						<div class="card shadow p-3 mb-5 bg-white rounded">

							<c:choose>
								<c:when test="${user.username=='Noyz Narcos'}">
									<img class="card_image"
										src="http://3.citynews-latinatoday.stgy.ovh/~media/original-hi/45112367075825/noyz-12-2.jpg"
										alt="Nature">
								</c:when>

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
								<p>${user.email}</p>
								<p>${user.citta}</p>
								
								<br>

								<div class="allinea">
									<a
										href="${contextPath}/eventView/account?nomeUser=${user.username}"
										class="button_dettagli">Dettagli</a>
								</div>

								<div class="allinea">
									<a href="${contextPath}/amici/remove?username=${user.username}"
										class="button_disdici">Rimuovi</a>
								</div>

							</div>
						</div>
					</c:forEach>

				</div>

			</section>

		</div>
		<div class="carousel-item">
			<section class="cards clearfix">
				
				<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">TUTTI GLI UTENTI</h1></div>

				<div class="container4">

					<c:forEach items="${tutti}" var="user" varStatus="tagStatus">
						<div class="card shadow p-3 mb-5 bg-white rounded">

							<c:choose>
								<c:when test="${user.username=='Kaka22'}">
									<img class="card_image"
										src="https://www.pianetamilan.it/wp-content/uploads/sites/23/2016/03/Kak%C3%A0_Milan_Chievo_2013_Getty_Images.jpg"
										alt="Nature">
								</c:when>

								<c:when test="${user.username=='Pato07'}">
									<img class="card_image"
										src="https://i.pinimg.com/originals/d4/51/00/d4510008149492dd4d554d20d426bea9.jpg">
								</c:when>

								<c:when test="${user.username=='Noyz Narcos'}">
									<img class="card_image"
										src="http://3.citynews-latinatoday.stgy.ovh/~media/original-hi/45112367075825/noyz-12-2.jpg"
										alt="Nature">
								</c:when>

								<c:otherwise>
									<img class="card_image"
										src="${contextPath}/resources/images/persona.jpg" alt="Nature">
								</c:otherwise>
							</c:choose>

							<div class="card_copy">
								<h3>${user.username}</h3>
								<p>${user.email}</p>
								<p>${user.citta}</p>

								<br>



								<div class="allinea">
									<a
										href="${contextPath}/eventView/account?nomeUser=${user.username}"
										class="button_dettagli">Dettagli</a>
								</div>

								<div class="allinea">
									<a href="${contextPath}/amici/add?username=${user.username}"
										class="button_partecipa" onclick="myFunctionAmicizia()">Aggiungi</a>
								</div>

							</div>
						</div>
					</c:forEach>

				</div>

			</section>
		</div>
	</div>
	<br>
	<br>
	<br>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>


<%@ include file="common/footer.jspf"%>