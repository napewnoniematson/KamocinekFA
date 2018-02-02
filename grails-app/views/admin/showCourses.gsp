<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCourses']">
    <h3><g:message code="show.course.message3"/></h3>
    <g:message code="course.title"/><g:textField name="title" value=" ${course?.title}"/><g:renderErrors bean="${course}" as="list" field="title"/> <br>
    <g:message code="course.start.date"/><g:textField name="startDate" value=" ${course?.startDate}"/><g:renderErrors bean="${course}" as="list" field="startDate"/> <br>
    <g:message code="course.end.date"/><g:textField name="endDate" value=" ${course?.endDate}"/><g:renderErrors bean="${course}" as="list" field="endDate"/> <br>
    <g:message code="course.maximum.players"/><g:textField name="maxPlayers" value=" ${course?.maxPlayers}"/><g:renderErrors bean="${course}" as="list" field="maxPlayers"/> <br>
    <g:message code="show.coach.message"/><g:select name="coach.id" from="${coaches}" value=" ${coach}" optionKey="id" optionValue="name"/><g:renderErrors bean="${course}" as="list" field="coach"/> <br>
    <g:if test="${course == null}">
        <g:actionSubmit action="addCourse" value="${message(code: 'button.add')}"/>
    </g:if>
    <g:else>
        <g:hiddenField name="id" value="${id}"/>
        <g:actionSubmit action="updateCourse" value="${message(code: 'button.update')}"/>
    </g:else>
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