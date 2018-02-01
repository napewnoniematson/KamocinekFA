<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Attendance</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'attendanceList']">
    <h3>Title: ${coach.courses[0].title}</h3>
    <p>Players on course</p>
    <g:if test="${coach.courses[0].players!=null}">
        <table style="border: 1px solid black;">
            <g:each in="${coach.courses[0].players}" var="player">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
                </tr>
            </g:each>
        </table>
    </g:if>




</g:form>
</body>
</html>