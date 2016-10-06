function signinValidation() {
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("pass").value;

    if ((userName == "") || (/^\s*$/.test(userName))) {
        alert("User Name can't blank");
    } else if (userName.match(/^[a-zA-Z0-9]*$/)) {

    } else {
        alert("Enter User Name here");
    }
    if ((password == "") || (/^\s*$/.test(password))) {
        alert("Enter password here");
    } else if (password.length < 6) {
        alert("minimum six characters")
    }
}