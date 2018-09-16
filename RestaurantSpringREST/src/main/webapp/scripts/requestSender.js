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
		if (this.readyState == 4 && this.status == 200) {
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
		if (this.readyState == 4 && this.status == 200) {
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
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("update-message").innerHTML = xhttp.responseText;
			console.log(th)
		} else {
			document.getElementById("update-message").innerHTML = xttp.responseText;
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
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("delete-message").innerHTML = this.responseText;
		}
	};
	xhttp.open("DELETE", "/delete?receipeId=" + receipeIdDelete.value, true);
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhttp.send();
}








// function validate(receipeId, receipeName) {
// if (receipeId.length == 0 || receipeName.length == 0) {
// document.querySelector(".error-messages-while-submitting").innerHTML = "INPUT
// FIELD IS EMPTY!!!";
// console.log("hi");
// return false;
// }

// var name_regex = /^[a-zA-Z]+$/;
// var number_regex = /^[0-9]+$/;
// if (!receipeId.match(number_regex) || !receipeName.match(name_regex)) {
// document.querySelector(".error-messages-while-submitting").innerHTML = "NOT A
// VALID INPUT!!!"
// document.querySelector(".error-messages-while-submitting").innerHTML.fadeIn();
// return false;
// }
// }



// var receipeIdUpdate = document.querySelector('#receipe-id-update');
// var receipeNameUpdate = document.querySelector('#receipe-name-update');
// var d={};
// d.receipeId=receipeIdUpdate;
// d.receipeName=receipeNameUpdate;
// var json=JSON.stringify(d);
// var xhttp = new XMLHttpRequest();
// xhttp.responseType = 'json';
// xhttp.onreadystatechange = function() {
// var data=JSON.parse(xhttp.response)
// if (this.readyState == 4 && this.status == 200) {
// console.log(data);
// document.getElementById("update-message").innerHTML = this.response;
// console.log('response', JSON.stringify(this.response));
// console.log('response', JSON.parse(this.response));
// }
// else{
// console.log(data);
// }
// };
// xhttp.open("PUT", "/update?", true);
// xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
// xhttp.send(json);









// var receipeIdUpdate = document.querySelector('#receipe-id-update');
// var receipeNameUpdate = document.querySelector('#receipe-name-update');
// var xhttp = new XMLHttpRequest();
// //xhttp.responseType = 'json';
// xhttp.onreadystatechange = function() {
// if (this.readyState == 4 && this.status == 200) {
// document.getElementById("update-message").innerHTML = this.responseText;
// console.log('response', this.response);
// }
// };
// xhttp.open("PUT", "/update?receipeId=" +
// receipeIdUpdate.value+"&receipeName=" + receipeNameUpdate.value, true);
// //xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
// xhttp.send();

// let receipeIdUpdate = document.querySelector('#receipe-id-update');
// let receipeNameUpdate = document.querySelector('#receipe-name-update');
// let d = {};
// d.receipeId = receipeIdUpdate.value;
// d.receipeName = receipeNameUpdate.value;
// const json = JSON.stringify(d);
//
// let xhttp = new XMLHttpRequest();
//
// xhttp.responseType = 'json';
// xhttp.open("PUT", "/update?receipeId=" +
// receipeIdUpdate.value+"&receipeName=" + receipeNameUpdate.value, true);
// xhttp.setRequestHeader('Content-type', 'application/json; charset=utf-8');
//
// xhttp.onload = () => {
// let resData = JSON.parse(xhttp.response);
// if (xhttp.readyState == 4 && xhttp.status == 200) {
// console.log(resData);
// } else {
// console.error(resData);
// }
// };
//
// xhttp.send();
