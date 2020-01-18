<%@ include file = "common/header.jspf"%>



<section class="cards clearfix" >
    <h1  class="font-effect-fire-animation">Risultati della ricerca "${searched}": </h1>
    <c:forEach items="${ricerca}" var="event" varStatus="tagStatus">
    <div class="card">
        <img class="card_image" src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
        <div class="card_copy">
          <h3>${event.name}</h3>
          <p>Descrizione : ${event.description}</p>
          <p>Luogo : ${event.luogo}</p>
          
          <p></p>

          <div class="allinea">
            <a href="${contextPath}/eventi/getEventId?idEvento=${event.id}" class="button_dettagli">Dettagli</a>
          </div>
          
          <div class="allinea">
            <a href="${contextPath}/eventi/askToJoin?idevento=${event.id}" class="button_partecipa">Partecipa</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>



















<%@ include file = "common/footer.jspf"%>