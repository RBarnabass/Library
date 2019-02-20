const signupButton = document.getElementById('signupButton');

signupButton.addEventListener('click', function () {

    let password = document.getElementById('passwordField').value;
    let hashedPasswordElement = document.getElementById('data-hashedPassword');

    let hashedPassword = sjcl.codec.hex.fromBits(sjcl.hash.sha256.hash(password));

    hashedPasswordElement.value = hashedPassword;

});

function validate() {

    const nameEl = document.getElementById("nameField");
    const loginEl = document.getElementById("loginField");
    const dateEl = document.getElementById("birthDateField");
    const passwordEl = document.getElementById("passwordField");


    if(!validateName(nameEl)) return false;
    if(!validateLogin(loginEl)) return false;
    if(!validateDate(dateEl)) return false;
    return validatePassword(passwordEl);



}