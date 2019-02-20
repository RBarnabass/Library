const loginButton = document.getElementById('loginButton');

loginButton.addEventListener('click', function() {

    const password = document.getElementById("password").value;
    const serverSalt = document.getElementsByTagName("body")[0].getAttribute("data-serverSalt");

    const hashResult = generateHashWithSalt(password, serverSalt);

    const result = {
        hash: hashResult.hash,
        clientSalt: hashResult.clientSalt,
    };

    let clientSaltDataElement = document.getElementById("data-clientSalt");
    let hashResultDataElement = document.getElementById("data-hashResult");

    clientSaltDataElement.value += result.clientSalt;
    hashResultDataElement.value += result.hash;
});