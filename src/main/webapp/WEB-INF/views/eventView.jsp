<%@ include file = "common/header.jspf"%>

<section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1 class="font-effect-fire-animation">Just Meet</h1>
        </div>
      </div>
    </section>

    <article class="single">
      <div class="single_copy">
        <h2 class="single_copy_title font-effect-fire-animation">Dettagli Evento</h2>
        <br>

        <p class="single_copy_meta2"> <strong>Nome Evento : </strong>&emsp;${evento.name}</p>

        <p class="single_copy_meta2"> <strong>Descrizione Evento : </strong>&emsp;${evento.description}</p>

        <p class="single_copy_meta2"> <strong>Luogo Evento : </strong>&emsp;${evento.luogo}</p>

        <p class="single_copy_meta2"> <strong>Owner Evento : </strong>&emsp;${evento.owner}</p>

        <p class="single_copy_meta2"> <strong>Categoria Evento : </strong>&emsp;${evento.category}</p>

        <p class="single_copy_meta2"> <strong>Giorno Evento : </strong>&emsp;${evento.day}</p>

        <p class="single_copy_meta2"> <strong>Mese Evento : </strong>&emsp;${evento.month}</p>

        <p class="single_copy_meta2"> <strong>Anno Evento : </strong>&emsp;${evento.year}</p>

        <p class="single_copy_meta2"> <strong>Ora Evento : </strong>&emsp;${evento.ora}</p>

        <p class="single_copy_meta2"> <strong>Minuto Evento : </strong>&emsp;${evento.minuti}</p>

        <p class="single_copy_meta2"> <strong>Partecipanti Evento : 
        <c:forEach items="${partecipanti}" var="user" varStatus="tagStatus">
              <a href="${contextPath}/eventView/account?nomeUser=${user.username}"> </strong>&emsp;${user.username}&emsp;|</a>
        </c:forEach>
        </p>
        <br>

        <a class="btn btn-outline-success font-effect-fire-animation" href="javascript:history.go(-1)" onMouseOver="self.status=document.referrer;return true">
          Torna a Eventi</a>

      </div>

      

    </article>

<%@ include file = "common/footer.jspf"%>