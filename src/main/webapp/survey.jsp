<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Survey Results</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <div class="thank-card">
        <img src="images/murachlogo.jpg" alt="Murach" width="80">

        <h1>Thanks for taking our survey!</h1>
        <p>Here is the information that you entered:</p>

        <table class="info-table">
            <tr><td>Email:</td><td>${user.email}</td></tr>
            <tr><td>First Name:</td><td>${user.firstName}</td></tr>
            <tr><td>Last Name:</td><td>${user.lastName}</td></tr>
            <tr><td>Heard From:</td><td>${user.heardFrom}</td></tr>
            <tr><td>Updates:</td><td>${user.updates}</td></tr>
            
            <% 
                murach.business.User user = (murach.business.User) request.getAttribute("user");
                if (user != null && "Yes".equals(user.getUpdates())) {
            %>
                <tr><td>Contact Via:</td><td>${user.contactVia}</td></tr>
            <%
                }
            %>
        </table>

        <!-- Nút Back và New Survey -->
        <div style="margin-top: 20px;">
            <input type="button" value="Back" onclick="window.history.back()" 
                   class="btn" style="margin-right: 10px;">
            
            <input type="button" value="New Survey" onclick="window.location.href='index.html'" 
                   class="btn" style="background-color: #4CAF50;">
        </div>

        <!-- Hoặc dùng form nếu muốn -->
        <form action="index.html" method="get" style="margin-top: 10px;">
            <input type="submit" class="btn" value="Take Another Survey">
        </form>
    </div>
</body>
</html>