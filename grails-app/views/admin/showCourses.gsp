<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCourses']">
    <h3>Courses:</h3>
    <g:if test="${courses!=null}">
        <table style="border: 1px solid black;">
            <g:each in="${courses}" var="course">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${course.title}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${course.maxPlayers}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deleteCourse" id="${course.id}"><input type="button" value="Delete"/></g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </g:if>
    <g:else>
        <p>Brak piłkarzy</p>
    </g:else>
</g:form>
</body>
</html>