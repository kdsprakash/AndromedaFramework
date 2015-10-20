function showPage(path, targetDiv) {
	var jqxhr = jQuery.post(path, function(data) {
		jQuery("#" + targetDiv).html(data);
	});
}

function showLoginPage() {
	var path = "html/login/loginForm.html";
	showPage(path, "containerDiv");
}

function showHomePage() {
	var path = "html/general/home.html";
	showPage(path, "containerDiv");
}

function setSessionValue(key, value) {
	sessionStorage.setItem(key, value);
}

function getSessionValue(key) {
	return sessionStorage.getItem(key);
}

function removeSessionValue(key) {
	sessionStorage.removeItem(key);
}

function showError(errorMessage) {
	var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>"+errorMessage+"</div>"
	jQuery("#errorDiv").html(message);
}

function logout() {
	var username = getSessionValue("username") || "";
	
	setSessionValue("username", null);
	setSessionValue("context", null);
	var data = {
		username : username
	};

	post('security/logout', data);
	showLoginPage();
}

function post(url, data) {
	var responseData = null;

	jQuery.ajax({
		url : url,
		type : 'post',
		data : JSON.stringify(data), // Stringified Json Object
		dataType : 'json',
		async : false, // Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
		cache : false, // This will force requested pages not to be cached by the browser
		processData : false, // To avoid making query String instead of JSON
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			responseData = data;
		}
	});

	return responseData;
}

function isUserLoggedIn() {
	var username = getSessionValue("username") || "";
	var context = getSessionValue("context") || "";
	var data = {
		username : username,
		context : context
	};

	return post('security/loggedin', data) || false;
}

