<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="admin"/>
    <title>Player home</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'saveCourse']">
    <h3><g:message code="show.course.message3"/></h3>
    <g:message code="course.title"/><g:textField name="title" value=" ${title}"/><g:renderErrors bean="${course}" as="list" field="title"/> <br>
    <g:message code="course.start.date"/><g:textField name="startDate" value=" ${startDate}"/><g:renderErrors bean="${course}" as="list" field="startDate"/> <br>
    <g:message code="course.end.date"/><g:textField name="endDate" value=" ${endDate}"/><g:renderErrors bean="${course}" as="list" field="endDate"/> <br>
    <g:message code="course.maximum.players"/><g:textField name="maxPlayers" value=" ${maxPlayers}"/><g:renderErrors bean="${course}" as="list" field="maxPlayers"/> <br>
    <g:message code="show.coach.message"/><g:select name="coach.id" from="${coaches}" value=" ${coach}" optionKey="id" optionValue="name"/><g:renderErrors bean="${course}" as="list" field="coach"/> <br>
    <g:actionSubmit action="saveCourse" value="${message(code: 'button.add')}"/>
</g:form>
</body>
</html>