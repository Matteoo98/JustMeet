<%@ include file = "common/headerBootstrap.jspf"%>

<section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>Just Meet</h1>
        </div>
      </div>
    </section>

<div class="container2">  

    <article class="single">
      <div class="single_copy shadow p-3 mb-5 bg-white rounded">
      
        <div class="p-3 mb-2 bg-light text-dark shadow-sm p-3 mb-5 bg-white rounded single_copy_title"><h2 align="center">DETTAGLI EVENTO</h2></div>
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
        <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/build/ol.js"></script>
    
    <div id="map" class="map"></div> 
        <br>

        <a class="btn btn-outline-success" href="javascript:history.go(-1)" onMouseOver="self.status=document.referrer;return true">
          Torna a Eventi</a>

      </div>

    </article>
    
    </div>

<%@ include file = "common/footer.jspf"%>