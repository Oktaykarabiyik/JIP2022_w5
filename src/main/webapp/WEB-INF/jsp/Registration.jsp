<!DOCTYPE html>
<html>

<head>
</head>

<body>
<font color="red">${errorMessage}</font>
<div class="error" id="div_error"></div>
<div class="success"></div>
<form action="/userRegistration" method="post" onsubmit="return formValidation()">
    Username : <input type="text" name="username" id="username" value=""/> <br>
    Email : <input type="email" name="email" value="" id="email"/> <br>
    Birthday : <input type="date" name="birthday" id="birthday" value=""/> <br>
    Sex:
    <input type="radio" name="sexsmall" value="0" checked> Female
    <input type="radio" name="sexsmall" value="1"> Male <br/>
    Password : <input type="password" name="password" value="" id="password"/> <br>
    Password Confirmation : <input type="password" name="confirmpassword" id="confirmpassword" value=""/>
    <input type="submit" value="Submit"/>
</form>
</body>
<script type="text/javascript">
    function formValidation() {
        var username = document.getElementById('username').value;
        var email = document.getElementById('email').value;
        var birthday=document.getElementById('birthday').value;
        const password = document.getElementById('password').value;
        const confirmpassword = document.getElementById('confirmpassword').value;


        if (username == "") {
            alert("Username Null!")
            return false;
        } else {
            var pattern_username = /^[a-zA-Z0-9]+$/;
            if (!pattern_username.test(username)) {
                alert("Please enter a valid username")
                return false;
            }
        }

        if (email == "") {
            alert("Email Null!")
            return false;
        } else {
            var pattern_email = /^[a-zA-Z0-9.%_-]+@[A-zA-Z0-9]+\.[a-zA-Z]{2,10}$/;
            if (!pattern_email.test(email)) {
                alert("Please enter a valid email")
                return false;
            }
        }
        if(birthday==""){
            alert("Birthday Null!")
            return false;
        }
        if (password == "") {
            alert("Password Null!")
            return false;
        } else {
            var pattern_password = /^(?=.*[a-z])(?=.*[0-9])(?=.*[@#%_)(!])[a-zA-Z0-9@#%_)(!]{8,15}$/;
            if (!pattern_password.test(password)) {
                alert("Please enter a valid password");
                return false
            }
        }
        if (confirmpassword == "") {
            alert("Please ente a confirm password");
            return false;
        }
        if (password != confirmpassword) {
            alert("Password and confirm password doesn't match");
            return false;
        }

        return true;

    }
</script>

</html>