<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCourses']">
    <h3>New Course</h3>
    <label>Title: </label><g:textField name="title" value="${course?.title}"/><g:renderErrors bean="${course}" as="list" field="title"/> <br>
    <label>Start date: </label><g:textField name="startDate" value="${course?.startDate}"/><g:renderErrors bean="${course}" as="list" field="startDate"/> <br>
    <label>End date: </label><g:textField name="endDate" value="${course?.endDate}"/><g:renderErrors bean="${course}" as="list" field="endDate"/> <br>
    <label>Maximum players: </label><g:textField name="maxPlayers" value="${course?.maxPlayers}"/><g:renderErrors bean="${course}" as="list" field="maxPlayers"/> <br>
    <label>Coach: </label><g:select name="coach.id" from="${coaches}" value="${coach}" optionKey="id" optionValue="name"/><g:renderErrors bean="${course}" as="list" field="coach"/> <br>
    <g:actionSubmit action="addCourse" value="add"/>

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
        <p>Brak kursów</p>
    </g:else>
</g:form>
</body>
</html>