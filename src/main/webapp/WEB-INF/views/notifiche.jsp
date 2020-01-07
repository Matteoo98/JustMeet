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
<a href="${contextPath}/notifiche/getNotificaInfoToAccept?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}" class=button_partecipa>ACCETTA</a>
<a href="${contextPath}/notifiche/getNotificaInfoToDeny?idevento=${notifica.idEventoToJoin}&user=${notifica.sender}&idnotifica=${notifica.id}" class=button_disdici>RIFIUTA</a>
        </c:forEach>
      </div>
    </article>
     
<h3>NOTIFICHE COMUNI</h3>
<c:forEach items="${notifichecomuni}" var="notifica" varStatus="tagStatus">
    <section class="banner_notify clearfix">
      <div class="banner_copy">
        <div class="banner_copy_text">
          <p>Descrizione : ${notifica.descrizione}</p>
          <p>Data : ${notifica.day}/${notifica.month}/${notifica.year}</p>
          <p>Orario : ${notifica.ora}:${notifica.minuti}</p>
          <a href="${contextPath}/notifiche/getId?id=${notifica.id}" class=button_dettagli>REMOVE</a>
        </div>
      </div>
    </section>
   </c:forEach>



<%@ include file = "common/footer.jspf"%>