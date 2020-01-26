<%@ include file = "common/headerBootstrap.jspf"%>
<script>
var x = ${numeroutenti};
var y = ${numeroeventi};
var w = ${numeroEventiInCorso};
var r = ${numeroEventiCreati};
var p =	${numeroAmici};
</script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="${contextPath}/resources/js/pieChartWelcome.js"></script>
<script src="${contextPath}/resources/js/pieChartWelcome2.js"></script>
<script src="${contextPath}/resources/js/pieChartWelcome3.js"></script>

    <section class="cover">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>JUST MEET</h1>
            <h2>Benvenuto ${principal}</h2>
        </div>
      </div>
    </section>
    
<div class="container4">

<div id="piechart_3d" style="width: 100%; height: 500px;"></div>
<div id="piechart_3d2" style="width: 100%; height: 500px;"></div>
<div id="piechart_3d3" style="width: 100%; height: 500px;"></div>

</div>
  
<%@ include file = "common/footer.jspf"%>
