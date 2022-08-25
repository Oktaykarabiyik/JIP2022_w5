<!DOCTYPE html>
<html>

<head>
</head>

<body>
<font color="red">${errorMessage}</font>
<form action="/userLogin" method="post" >
    Name : <input type="text" name="username" value="" />
    Password : <input type="password" name="password" value="" />
    <input type="submit" value="Submit" /> <br>
    <br>
</form>

<form action="/userRegistration" method="get">
    <button type="submit">Create User</button>
</form>
</body>

</html>