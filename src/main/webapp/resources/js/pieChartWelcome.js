google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Object', 'Number'],
          ['Tutti gli Eventi',     y],
          ['Eventi a cui stai partecipando ',      w]
        ]);

        var options = {
          title: 'Eventi dove partecipo',
          backgroundColor: '#eee',
          colors: ['black','red'],
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }