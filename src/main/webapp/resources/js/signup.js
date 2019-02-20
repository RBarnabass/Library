const signupButton = document.getElementById('signupButton');

signupButton.addEventListener('click', function () {

    let password = document.getElementById('passwordField').value;
    let hashedPasswordElement = document.getElementById('data-hashedPassword');

    let hashedPassword = sjcl.codec.hex.fromBits(sjcl.hash.sha256.hash(password));
    hashedPasswordElement.value = hashedPassword;
});