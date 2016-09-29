function validateFunction(){
	var Name = document.getElementById("Name").value;
	var dob = document.getElementById("dob").value;
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("pass").value;
	var type = document.getElementById("type").value;

if((Name=="")||(/^\s*$/.test(Name))){
	alert("Name can't be blank");
}
else if(Name.match(/^[a-zA-Z]+$/)){

	}
	else{alert("Use characters only");}
	if((dob=="")||(/^\s*$/.test(dob))){
	alert("Date of Birth can't be blank");
}
else {}
	if((userName=="")||(/^\s*$/.test(userName))){
	alert("User Name can't blank");
}
else if(userName.match(/^[a-zA-Z0-9]*$/)){

	}
	else{alert("Enter User Name here");}
	if((password=="")||(/^\s*$/.test(password))){
	alert("Enter password here");
}
else if(password.length<6){
alert("minimum six characters")
}
else if(password.match(/^[a-zA-Z0-9]+$/)){

	}else{}
	

}

