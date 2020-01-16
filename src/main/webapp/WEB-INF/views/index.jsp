<%@ include file = "common/headerIndex.jspf"%>
<script>
var x = ${numeroutenti}
var y = ${numeroeventi}
</script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="${contextPath}/resources/js/pieChart.js"></script>

    <section class="cover">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>Just Meet</h1>
            <h2>Per trovare il decimo a calcetto</h2>
            <a href="${contextPath}/login" class="button">Login</a> | <a href="${contextPath}/registration" class="button">Registration</a>
        </div>
      </div>
    </section>
    
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>

 <%@ include file = "common/footer.jspf"%>