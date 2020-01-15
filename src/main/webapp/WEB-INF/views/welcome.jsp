<%@ include file = "common/header.jspf"%>


    <section class="cover">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>Just Meet</h1>
            <h2>Benvenuto ${principal}</h2>
        </div>
      </div>
    </section>

    <section class="banner_notify clearfix">
      <div class="banner_copy">
        <div class="banner_copy_text">
          <p>Descrizione sito...</p>
        </div>
      </div>
    </section>

<table style="width:100%" border="">
  <tr>
    <th>NUMERO UTENTI REGISTRATI</th>
    <th>NUMERO EVENTI REGISTRATI</th>
  </tr>
  
  <tr>
    <td>${numeroutenti}</td> 
   
    <td>${numeroeventi}</td>
    </tr>
</table> 
  
    
    <table style="width:100%" border="1">
      <tr>
        <th>NOME UTENTI REGISTRATI</th>
      </tr>
      <c:forEach items="${utenti}" var="utente" varStatus="tagStatus">
        <tr>
          <td>- ${utente.username}</td>
        </tr>
      </c:forEach> 
    </table> 
     
    <table style="width:100%" border="1">
      <tr>
        <th>NOME EVENTI REGISTRATI</th>
      </tr>
    
      <c:forEach items="${eventi}" var="evento" varStatus="tagStatus">
        <tr>
          <td>- ${evento.name}</td>  
        </tr>
      </c:forEach>
   </table>
  
<%@ include file = "common/footer.jspf"%>
