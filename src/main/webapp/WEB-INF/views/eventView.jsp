<%@ include file = "common/header.jspf"%>

<section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>Just Meet</h1>
        </div>
      </div>
    </section>

    <article class="single">
      <div class="single_copy">
        <h2 class="single_copy_title">Dettagli Evento</h2>
        <p></p>
        <p class="single_copy_meta"> Nome Evento : </p>
        <p>${evento.name}</p>
        <p class="single_copy_meta"> Descrizione Evento : </p>
        <p>${evento.description}</p>
        <p class="single_copy_meta"> Luogo Evento : </p>
        <p>${evento.luogo}</p>
        <p class="single_copy_meta"> Owner Evento : </p>
        <p>${evento.owner}</p>
        <p class="single_copy_meta"> Categoria Evento : </p>
        <p>${evento.category}</p>
        <p class="single_copy_meta"> Giorno Evento : </p>
        <p>${evento.day}</p>
        <p class="single_copy_meta"> Mese Evento : </p>
        <p>${evento.month}</p>
        <p class="single_copy_meta"> Anno Evento : </p>
        <p>${evento.year}</p>
        <p class="single_copy_meta"> Ora Evento : </p>
        <p>${evento.ora}</p>
        <p class="single_copy_meta"> Minuto Evento : </p>
        <p>${evento.minuti}</p>
        <p class="single_copy_meta"> Partecipanti Evento : </p>
        <c:forEach items="${partecipanti}" var="user" varStatus="tagStatus">
              <a href="${contextPath}/eventView/account?nomeUser=${user.username}">${user.username}</a>
        </c:forEach>
        <p class="single_copy_meta">Torna indietro</p>
        <a href="javascript:history.go(-1)" 
onMouseOver="self.status=document.referrer;return true">
Torna indietro</a>
      </div>
    </article>

<%@ include file = "common/footer.jspf"%>