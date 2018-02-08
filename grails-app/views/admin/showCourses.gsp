<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCourses']">
    <h3><g:message code="show.course.message2"/></h3>
    <g:if test="${courses!=null}">
        <table style="border: 1px solid black;">
            <tr style="padding: 15px; border: 1px solid black;">
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.title"/>
                </td>
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.maxplayers"/>
                </td>
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.actions"/>
                </td>
            </tr>
            <g:each in="${courses}" var="course">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${course.title}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${course.maxPlayers}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deleteCourse" id="${course.id}"><input type="button" value="${message(code: 'button.delete')}"/></g:link>
                        <g:link action="editCourse" id="${course.id}"><input type="button" value="${message(code: 'button.edit')}"/></g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </g:if>
    <g:else>
        <g:message code="show.course.error.message"/>
    </g:else>
</g:form>
</body>
</html>