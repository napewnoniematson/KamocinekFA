<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Your courses</title>
</head>
<body>

<g:form name="myForm" url="[controller:'coach', action:'showCourses']">
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