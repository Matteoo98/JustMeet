<%@ include file = "common/header.jspf"%>

    <section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
          <h1>Just Meet</h1>
        </div>
      </div>
    </section>
    
  

<c:forEach items="${User}" var="user" varStatus="tagStatus">
    <article class="single">
      <div class="single_copy">
        <h2 class="single_copy_title">INFORMAZIONI UTENTE</h2>
        <p></p>
        <p class="single_copy_meta"> Nome : </p> 
        <p>${user.username}</p>
        <p class="single_copy_meta"> Cognome : </p>
        <p>${user.cognome}</p>
        <p class="single_copy_meta"> Città : </p>
        <p>${user.citta}</p>
        <p class="single_copy_meta"> Email : </p>
        <p>${user.email}</p>
        <p class="single_copy_meta"> Preferenza 1 : </p>
        <p>${user.preferenceUno}</p>
        <p class="single_copy_meta"> Preferenza 2 : </p>
        <p>${user.preferenceDue}</p>
        <p class="single_copy_meta"> Preferenza 3 : </p>
        <p>${user.preferenceTre}</p>
        <p class="single_copy_meta"> Lista amici : </p>
        <c:forEach items="${amici}" var="user" varStatus="tagStatus">
        <p>- <a href="${contextPath}/eventView/account?nomeUser=${user.username}">${user.username}</a></p>
        </c:forEach>
        </div>
    </article>
</c:forEach>


 
  <section class="cards clearfix" >
    <h1>EVENTI A CUI TI SEI UNITO</h1>
    <c:forEach items="${Events}" var="event" varStatus="tagStatus">
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
            <a href="${contextPath}/account/getEventNamePerDisdire?id=${event.id}" class="button_disdici">Disdici</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>
    
    <section class="cards clearfix" >
    <h1>EVENTI CHE HAI CREATO</h1>
    <c:forEach items="${owner}" var="event" varStatus="tagStatus">
    <div class="card">
        <img class="card_image" src="${contextPath}/resources/images/myevents.jpg" alt="Nature">
        <div class="card_copy">
          <h3>${event.name}</h3>
          <p>Descrizione : ${event.description}</p>
          <p>Luogo : ${event.luogo}</p>
          
          <p></p>

          <div class="allinea">
            <a href="${contextPath}/adminEvent?idEvento=${event.id}" class="button_partecipa">Modifica</a>
          </div>
          
          <div class="allinea">
            <a href="${contextPath}/managePartecipanti?idEvento=${event.id}" class="button_dettagli">Add/Remove Users </a>
          </div>
          
          <div class="allinea">
            <a href="${contextPath}/account/deleteEvent?idEvento=${event.id}" class="button_disdici">Elimina</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>



 <%@ include file = "common/footer.jspf"%>