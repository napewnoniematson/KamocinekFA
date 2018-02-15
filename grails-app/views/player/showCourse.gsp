<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>${title}</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'showCourse']">
    <h3><g:message code="course.title"/> ${title}</h3></br>
    <g:message code="course.coach"/> ${coach}</br>
    <g:message code="course.start.date"/> ${startdate}</br>
    <g:message code="course.end.date"/> ${enddate}</br>
    <g:message code="course.maximum.players"/> ${maxplayers}</br>
    <g:message code="course.actual.players"/> ${actualplayers}</br>
</g:form>
</body>
</html>