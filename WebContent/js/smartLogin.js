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
	    button.href = 'smartSignup.html';
		var buttValue = document.createTextNode("SIGNUP HERE");
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

		var sigDiv = document.createElement("div");
	    sigDiv.id = 'login';
	    document.body.appendChild(sigDiv);

	    var ldiv1 = document.createElement("div");
	    ldiv1.id = 'sig';
	    var h2 = document.createElement("h2");
	    var h2Value = document.createTextNode("SIGNIN");
	    h2.appendChild(h2Value);
	    ldiv1.appendChild(h2);
	    sigDiv.appendChild(ldiv1);

	    var ldiv2 = document.createElement("div");
	    ldiv2.id = 'form';
	    var la1 = document.createElement("label");
	    var la1Value = document.createTextNode("USER NAME");
	    la1.appendChild(la1Value);
	    ldiv2.appendChild(la1);

	    var inp1 = document.createElement("input");
	    inp1.id = 'userName';
	    inp1.className = 'input';
	    inp1.placeholder = 'USERNAME';
	    ldiv2.appendChild(inp1);
	    var hrV = document.createElement("hr");
	    ldiv2.appendChild(hrV);

	    var la2 = document.createElement("label");
	    var la2Value = document.createTextNode("PASSWORD");
	    la2.appendChild(la2Value);
	    ldiv2.appendChild(la2);

	    var inp2 = document.createElement("input");
	    inp2.id = 'pass';
	    inp2.className = 'input';
	    inp2.placeholder = 'PASSWORD';
	    inp2.type = 'password';
	    ldiv2.appendChild(inp2);
	    var hrV1 = document.createElement("hr");
	    ldiv2.appendChild(hrV1);
	    sigDiv.appendChild(ldiv2);

	    var ldiv3 = document.createElement("div");
	    var sub = document.createElement("input");
	    sub.id = 'sign';
	    sub.type = 'submit';
	    sub.value = 'SIGNIN';
	    sub.setAttribute("onclick","signinValidation()");
	    ldiv3.appendChild(sub);
	    sigDiv.appendChild(ldiv3); 	
	    div3.appendChild(sigDiv);


}
	

		