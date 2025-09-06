<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Thanks</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <div class="thank-card">
        <img src="images/murachlogo.jpg" alt="Murach" width="80">

        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>

        <table class="info-table">
            <tr><td>Email:</td><td>${user.email}</td></tr>
            <tr><td>First Name:</td><td>${user.firstName}</td></tr>
            <tr><td>Last Name:</td><td>${user.lastName}</td></tr>
            <tr><td>Date of Birth:</td><td>${user.dateOfBirth}</td></tr>
            <tr><td>Heard From:</td><td>${user.heardFrom}</td></tr>
            <tr><td>Wants Updates:</td><td>${user.wantsUpdates}</td></tr>
            <tr><td>Email OK:</td><td>${user.emailOK}</td></tr>
            <tr><td>Contact Via:</td><td>${user.contactVia}</td></tr>
        </table>

        <form action="emailList" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" class="btn" value="Return">
        </form>
    </div>
</body>
</html>
