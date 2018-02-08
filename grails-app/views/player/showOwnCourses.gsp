<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
</head>
<body>

<g:form name="myForm" url="[controller:'player', action:'showOwnCourses']">
    <g:if test="${flash.message}">
        <div class="message" style="display: block">${flash.message}</div>
    </g:if>
    <g:message code="show.course.message"/></br>
    <g:if test="${courses!=null}">
        <g:each in="${courses}" var="course">
            <g:link action="showCourse" id="${course.id}">${course.title}</g:link></br>
        </g:each>
    </g:if>
    <g:else>
        <g:message code="show.course.error.message"/>
    </g:else>
</g:form>
</body>
</html>