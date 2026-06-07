const form = document.getElementById("loginForm");
const email = document.getElementById("email");
const password = document.getElementById("password");

function showError(input, message){
    const formGroup = input.parentElement;
    const error = formGroup.querySelector(".error");

    error.innerText = message;
    input.classList.add("fail");
    input.classList.remove("success");
}

function showSuccess(input){
    const formGroup = input.parentElement;
    const error = formGroup.querySelector(".error");

    error.innerText = "";
    input.classList.add("success");
    input.classList.remove("fail");
}

function validateEmail(emailValue){
    const pattern =
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    return pattern.test(emailValue);
}

function validatePassword(passwordValue){

    const minLength = 8;
    const specialChar =
    /[!@#$%^&*(),.?":{}|<>]/;

    return passwordValue.length >= minLength
           && specialChar.test(passwordValue);
}

form.addEventListener("submit", function(e){

    e.preventDefault();

    let isValid = true;

    if(email.value.trim() === ""){
        showError(email,"Email is required");
        isValid = false;
    }
    else if(!validateEmail(email.value)){
        showError(email,"Invalid email format");
        isValid = false;
    }
    else{
        showSuccess(email);
    }

    if(password.value.trim() === ""){
        showError(password,"Password is required");
        isValid = false;
    }
    else if(!validatePassword(password.value)){
        showError(
            password,
            "Min 8 chars & 1 special character"
        );
        isValid = false;
    }
    else{
        showSuccess(password);
    }

    if(isValid){
        alert("Form Submitted Successfully");
        form.submit();
    }
});