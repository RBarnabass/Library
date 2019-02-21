function validateDate(dateEl) {

    const re = /^(\d{4})-(\d{1,2})-(\d{1,2})$/;
    const dateValue = dateEl.value;

    const regs = dateValue.match(re);

    if (!!regs && dateValue !== '') {


        if (!dateValue.match(re)) {
            // alert("Invalid date format: " + dateValue);
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid date format: ' + dateValue
            });
            dateEl.focus();
            return false;
        }

        if (regs[1] < 1902 || regs[1] > new Date().getFullYear()) {
            //alert("Invalid value for year: " + regs[1] + " - must be between 1902 and " + (new Date()).getFullYear());
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid value for year: ' + regs[1] + ' - must be between 1902 and ' + (new Date()).getFullYear()
            });
            dateEl.focus();
            return false;
        }

        if (regs[2] < 1 || regs[2] > 12) {
            //alert("Invalid value for month: " + regs[2]);
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid value for month: ' + regs[2]
            });
            dateEl.focus();
            return false;
        }

        if (regs[3] < 1 || regs[3] > 31) {
            // alert("Invalid value for day: " + regs[2]);
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid value for day: ' + regs[2]
            });
            dateEl.focus();
            return false;
        }
    } else {
        // alert("Invalid date format: " + dateValue);
        Swal.fire({
            type: 'error',
            title: 'Validation failed',
            text: 'Date should not be empty'
        });
        dateEl.focus();
        return false;
    }

    return true;
}

function validateName(nameEl) {

    const re = /^[A-Za-z\s]+$/;
    const nameValue = nameEl.value;
    const regs = nameValue.match(re);

    if (!!regs && nameValue !== '') {

        if (!nameValue.match(re)) {
            // alert("Invalid name: " + nameValue);
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid name: ' + nameValue
            });
            nameEl.focus();
            return false;
        }

        return true;
    } else {
        //alert("Invalid name: " + nameValue);
        Swal.fire({
            type: 'error',
            title: 'Validation failed',
            text: 'Name should not be empty'
        });
        nameEl.focus();
        return false;
    }
}

function validateLogin(loginEl) {
    const re = /^[a-zA-Z0-9_]*$/;
    const loginValue = loginEl.value;
    const regs = loginValue.match(re);

    if (!!regs && loginValue !== '') {

        if (!loginValue.match(re)) {
            // alert("Invalid login: " + loginValue + ". Please, use only alphanumeric symbols and underscore.");
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid login: ' + loginValue + '. Please, use only alphanumeric symbols and underscore'
            });
            loginEl.focus();
            return false;
        }

        return true;
    } else {

        //alert("Invalid login: " + loginValue + ". Please, use only alphanumeric symbols and underscore.");
        Swal.fire({
            type: 'error',
            title: 'Validation failed',
            text: 'Invalid login: ' + loginValue + '. Please, use only alphanumeric symbols and underscore'
        });
        loginEl.focus();
        return false;

    }
}

function validatePassword(passwordEl) {
    const re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    const passwordValue = passwordEl.value;
    const regs = passwordValue.match(re);

    if (!!regs && passwordValue !== '') {

        if (!passwordValue.match(re)) {
            // alert("Invalid password. Password must be 6 to 20 characters length with at least one numeric digit, one uppercase and one lowercase letter.");
            Swal.fire({
                type: 'error',
                title: 'Validation failed',
                text: 'Invalid password. Password must be 6 to 20 characters length with at least one numeric digit, one uppercase and one lowercase letter.'
            });
            passwordEl.focus();
            return false;
        }

        return true;
    } else {
        // alert("Invalid password. Password must be 6 to 20 characters length with at least one numeric digit, one uppercase and one lowercase letter.");
        Swal.fire({
            type: 'error',
            title: 'Validation failed',
            text: 'Invalid password. Password must be 6 to 20 characters length with at least one numeric digit, one uppercase and one lowercase letter.'
        });
        passwordEl.focus();
        return false;
    }
}