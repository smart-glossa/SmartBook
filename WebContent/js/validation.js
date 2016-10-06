function validate() {
	if (document.getElementById("title").value == "") {
		alert("Enter the title");
	} else if (document.getElementById("des").value == "") {
		alert("Enter the description");
	} else if (document.getElementById("due").value == "") {
		alert("Enter the due");
	} else if(document.getElementById("sta").value == "") {
		alert("Enter the status");
	}
}