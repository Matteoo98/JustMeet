var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 43.146775, lng: 13.066049},
          zoom: 8
        });
      }