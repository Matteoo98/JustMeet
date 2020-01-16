google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Object', 'Number'],
          ['Tutti gli Eventi',     y],
          ['Eventi creati ',      r]
        ]);

        var options = {
          title: 'JustMeet Statistics',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d2'));
        chart.draw(data, options);
      }