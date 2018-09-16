fetch('/create', {
	method: 'post',
	body: JSON.stringify({
		receipeId: document.getElementById('receipeIdCreate').value,
		receipeName: document.getElementById('receipeNameCreate').value
	})}).then(function(response) {
		
	}).catch(function(err) {
		// Error :(
});

fetch('/retrieve', {
	method: 'get'
}).then(function(response) {
	
}).catch(function(err) {
	// Error :(
});

fetch("/update", {
	method: 'put',
	body: json
	})
	.then(response => {
	if(response.status === 200)
	console.log("OK");
	})
	.catch(err => console.log(err));