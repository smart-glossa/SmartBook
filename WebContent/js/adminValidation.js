function validateFunction() {
    var Name = document.getElementById("Name").value;
    var dob = document.getElementById("dob").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("pass").value;
    var type = document.getElementById("type").value;

    if ((Name == "") || (/^\s*$/.test(Name))) {
        alert("Name can't be blank");
        return true;
    } else if (Name.match(/^[a-zA-Z]+$/)) {

    } else {
        alert("Use alphabets only");
    }
    if ((dob == "") || (/^\s*$/.test(dob))) {
        alert("Date of Birth can't be blank");
        return true;
    } else {}
    if ((userName == "") || (/^\s*$/.test(userName))) {
        alert("User Name can't blank");
        return true;
    } else if (userName.match(/^[a-zA-Z0-9]*$/)) {

    } else {
        alert("Enter User Name here");
    }
    if ((password == "") || (/^\s*$/.test(password))) {
        alert("Enter password here");
        return true;
    } else if (password.length < 6) {
        alert("Password length is minimum six");
        return true;
    } else if (password.match(/^[a-zA-Z0-9]+$/)) {

    } else {}
    return false;

}
