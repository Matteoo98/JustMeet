<%@ include file = "common/header.jspf"%>

    <section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>CENTRO NOTIFICHE</h1>
        </div>
      </div>
    </section>

    <article class="single">
      <div class="single_copy">
        <h2 class="single_copy_title">RICHIESTE PARTECIPAZIONE EVENTO</h2>
        <c:forEach items="${notificherichieste}" var="notifica" varStatus="tagStatus">
        <p class="single_copy_meta"> Il ${notifica.day}/${notifica.month}/${notifica.year} alle ${notifica.ora}:${notifica.minuti} </p>
        <p>${notifica.descrizione}</p>

        <a class="btn btn-primary btn-lg btn-block" href="${contextPath}/notifiche/getNotificaInfoToAccept?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}">ACCETTA</a>
        <a class="btn btn-secondary btn-lg btn-block" href="${contextPath}/notifiche/getNotificaInfoToDeny?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}">RIFIUTA</a>
        
        </c:forEach>
        <p>---------------------------------------------------------------------------------------------------</p>
        <h2 class="single_copy_title">RICHIESTE AMICIZIA</h2>
        <c:forEach items="${notificheamicizia}" var="notifica" varStatus="tagStatus">
        <p class="single_copy_meta"> Il ${notifica.day}/${notifica.month}/${notifica.year} alle ${notifica.ora}:${notifica.minuti} </p>
        <p>${notifica.descrizione}</p>
        <a class="btn btn-primary btn-lg btn-block" href="${contextPath}/notifiche/accettaAmicizia?username=${notifica.sender}&idnotifica=${notifica.id}">ACCETTA</a>
        <a class="btn btn-secondary btn-lg btn-block" href="${contextPath}/notifiche/rifiutaAmicizia?username=${notifica.sender}&idnotifica=${notifica.id}">RIFIUTA</a>
        </c:forEach>
      </div>
    </article>
    
    
<c:forEach items="${notifichecomuni}" var="notifica" varStatus="tagStatus">
    <section class="banner_notify clearfix">
      <div class="banner_copy">
        <div class="banner_copy_text">
          <p><h4>${notifica.descrizione}</h4></p>
          <p>${notifica.day}/${notifica.month}/${notifica.year} - ${notifica.ora}:${notifica.minuti}</p>

          <a class="btn btn-outline-danger" href="${contextPath}/notifiche/getId?id=${notifica.id}">REMOVE</a>
        </div>
      </div>
    </section>
   </c:forEach>



<%@ include file = "common/footer.jspf"%>