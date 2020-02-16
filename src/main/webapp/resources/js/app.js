navigator.serviceWorker && navigator.serviceWorker.register('resources/js/sw.js')
.then(function(registration) {  
	console.log('Excellent, registered with scope: ', registration.scope)
	;});
/*
navigator.serviceWorker.register('resources/js/sw.js', {
	  scope: '/'
	});
*/