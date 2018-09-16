function onCreate() {
	var receipeIdCreate = document.querySelector('#receipe-id-create');
	var receipeNameCreate = document.querySelector('#receipe-name-create');
	var jsonReqString = JSON.stringify({
		receipeId : receipeIdCreate.value,
		receipeName : receipeNameCreate.value
	});
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("create-message").innerHTML = "The receipeId is "
					+ this.response.receipeId
					+ ".  "
					+ "The receipeName is "
					+ this.response.receipeName;
			console.log('response', this.response);
			var x = this.response;
			console.log(x.receipeId);
			console.log(x.receipeName);

		}
	};
	xhttp.open("POST", "/create", true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send(jsonReqString);
}

function onRead() {
	var receipeIdRead = document.querySelector('#receipe-id-read');
	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("read-message").innerHTML = "The receipeId is "
					+ this.response.receipeId
					+ ".  "
					+ "The receipeName is "
					+ this.response.receipeName + " ";
			console.log('response', this.response);
			var x = this.response;
			console.log(x.receipeId);
			console.log(x.receipeName);

		}
	};
	xhttp.open("GET", "/read?receipeId=" + receipeIdRead.value, true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send();
}

function onUpdate() {
	let receipeIdUpdate = document.querySelector('#receipe-id-update');
	let receipeNameUpdate = document.querySelector('#receipe-name-update');
	let data = {};
	data.receipeId = receipeIdUpdate.value;
	data.receipeName = receipeNameUpdate.value;
	const jsonData = JSON.stringify(data);

	let xhttp = new XMLHttpRequest();

	xhttp.onload = () => {
		if (xhttp.readyState === 4 && xhttp.status === 200) {
			document.getElementById("update-message").innerHTML = "Successfully Updated";
		} else {
			document.getElementById("update-message").innerHTML = "Oops!!Receipe Not Found";
		}
	};
	xhttp.open("PUT", "/update", true);
	xhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xhttp.send(jsonData);	
}
function onDelete() {
	var receipeIdDelete = document.querySelector('#receipe-id-delete');

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("delete-message").innerHTML = "Successfully deleted";
		}
	};
	xhttp.open("DELETE", "/delete?receipeId=" + receipeIdDelete.value, true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send();
}







