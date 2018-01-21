<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your courses</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'showCourse']">
    <h3>Title: ${title}</h3>
    <p>Players on course</p>
    <table style="border: 1px solid black;">

    <g:each in="${players}" var="player">
        <tr style="padding: 15px; border: 1px solid black;">
            <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
            <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
            <td style="padding: 15px;  border: 1px solid black;" nowrap="true">ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</td>
        </tr>
    </g:each></table>
</g:form>
</body>
</html>