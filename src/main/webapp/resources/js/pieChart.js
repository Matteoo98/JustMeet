google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Object', 'Number'],
          ['Utenti Registrati',     x],
          ['Tutti gli Eventi ',      y]
        ]);

        var options = {
          title: 'JustMeet Statistics',
          backgroundColor: '#eee',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }