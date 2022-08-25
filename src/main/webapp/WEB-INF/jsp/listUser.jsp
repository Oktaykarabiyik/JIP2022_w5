<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OBSS</title>
    <style>

        label {
            display: block;
            margin-top: 5px;
        }

        input {
            width: 200px;
            height: 25px;
            font-size: 1.2em;
        }

        button {
            border: none;
            display: block;
            margin-top: 5px;
            width: 204px;
            height: 50px;
            text-align: center;
            font-size: 1.2em;
        }

        table {
            background: #0984e3;
            margin: 5px;
            width: 50%;
            color: #fff;
        }

        td, th {
            border: 1px solid white;
            border-spacing: 0px;
            margin: 0px;
        }
    </style>
</head>
<body>

<table id="liste">
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Sexsmall</th>
    </tr>
</table>
<script>
    fetch("/userList")
        .then((response) => response.json()) //parse json data
        .then(function (todos) {
            todos.forEach((todo) => {

                let tUsername = document.createElement("td");
                let tEmail = document.createElement("td");
                let tBirthday = document.createElement("td");
                let tSexsmall = document.createElement("td");

                tUsername.textContent = todo.username;
                tEmail.textContent = todo.email;
                tBirthday.textContent = todo.birthday;
                tSexsmall.textContent = todo.sexsmall;

                console.log(todo.username);
                let tr = document.createElement("tr");

                tr.appendChild(tUsername);
                tr.appendChild(tEmail);
                tr.appendChild(tBirthday);
                tr.appendChild(tSexsmall);
                liste.appendChild(tr);

                todo.username="";
                todo.email="";
                todo.birthday="";
                todo.sexsmall="";

            });
        });

</script>
</body>