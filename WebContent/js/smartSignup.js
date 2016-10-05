function myFunction(){
	var head = document.createElement("div");
		head.className = 'head';
		document.body.appendChild(head);

	var h1 = document.createElement("h1");
		var h1Value = document.createTextNode("SMARTBOOK");
		h1.setAttribute("align","center");
		h1.appendChild(h1Value);
		head.appendChild(h1);

	var button = document.createElement("a");
	    button.className = 'but';
	    button.href = 'smatLogin.html';
		var buttValue = document.createTextNode("LOGIN");
		button.appendChild(buttValue);
		head.appendChild(button);
 	


	var div2 = document.createElement("div");
		div2.className = 'empty';
		document.body.appendChild(div2);

	var div3 = document.createElement("div");
		document.body.appendChild(div3);

	var imgDiv = document.createElement("div");
	    imgDiv.className ='imgd';
		var img = document.createElement("img");
		img.src = 'images/proj.jpg';
		img.id ='img';
		imgDiv.appendChild(img);
		div3.appendChild(imgDiv);

	var acDiv = document.createElement("div");
	    acDiv.className = 'login';
	    var h2 = document.createElement("h2");
	    var h2Value = document.createTextNode("CREATE AN ACCOUNT");
	    h2.appendChild(h2Value);
	    acDiv.appendChild(h2);

	    var l1 = document.createElement("label");
	    var l1Value = document.createTextNode("NAME");
	    l1.appendChild(l1Value);
	    acDiv.appendChild(l1);

	    var in1 = document.createElement("input");
	    in1.id = 'Name';
	    in1.className = 'input';
	    in1.placeholder = 'Enter Name here';
	    acDiv.appendChild(in1);
	    var hr1 = document.createElement("hr");
	    acDiv.appendChild(hr1); 

	    var l2 = document.createElement("label");
	    var l2Value = document.createTextNode("DATE OF BIRTH");
	    l2.appendChild(l2Value);
	    acDiv.appendChild(l2);

	    var in2 = document.createElement("input");
	    in2.id = 'dob';
	    in2.className = 'input';
	    in2.placeholder = 'Enter Date of birth';
	    in2.setAttribute("onfocus","(this.type='date')");
	    acDiv.appendChild(in2);
	    var hr2 = document.createElement("hr");
	    acDiv.appendChild(hr2);

	    var l3 = document.createElement("label");
	    var l3Value = document.createTextNode("USER NAME");
	    l3.appendChild(l3Value);
	    acDiv.appendChild(l3);

	    var in3 = document.createElement("input");
	    in3.id = 'userName';
	    in3.className = 'input';
	    in3.placeholder = 'Enter userName here';
	    acDiv.appendChild(in3);
	    var hr3 = document.createElement("hr");
	    acDiv.appendChild(hr3);

	    var l4 = document.createElement("label");
	    var l4Value = document.createTextNode("PASSWORD");
	    l4.appendChild(l4Value);
	    acDiv.appendChild(l4);

	    var in4 = document.createElement("input");
	    in4.id = 'pass';
	    in4.className = 'input';
	    in4.type = 'password';
	    in4.placeholder = 'Enter password';
	    acDiv.appendChild(in4);
	    var hr4 = document.createElement("hr");
	    acDiv.appendChild(hr4);

	    var l5 = document.createElement("label");
	    var l5Value = document.createTextNode("TYPE");
	    l5.appendChild(l3Value);
	    acDiv.appendChild(l5);

	    var select = document.createElement("select");
	    select.id = 'type';
	    var op1 = document.createElement("option");
	    var op1Value = document.createTextNode("Select type");
	    op1.appendChild(op1Value);
	    select.appendChild(op1);
	    var op2 = document.createElement("option");
	    var op2Value = document.createTextNode("Admin");
	    op2.appendChild(op2Value);
	    select.appendChild(op2);
	    var op3 = document.createElement("option");
	    var op3Value = document.createTextNode("User");
	    op3.appendChild(op3Value);
	    select.appendChild(op3);
	    acDiv.appendChild(select);
	    var hr5 = document.createElement("hr");
	    acDiv.appendChild(hr5);
        
        var bDiv = document.createElement("div");
	    var but = document.createElement("input");
	    but.id = 'lbut';
	    but.type = 'submit';
	    but.value = 'Create Account';
	    but.setAttribute("onclick","validateFunction()");
	 	bDiv.appendChild(but);
	    acDiv.appendChild(bDiv);
	    div3.appendChild(acDiv);

}
		