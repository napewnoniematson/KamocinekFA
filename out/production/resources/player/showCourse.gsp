<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your courses</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'showCourse']">
    <h3>Title: ${title}</h3>
    <label>Coach: ${coach}</label></br>
    <label>Start date: ${startdate}</label></br>
    <label>End date: ${enddate}</label></br>
    <label>Maximum players: ${maxplayers}</label></br>
    <label>Actual players: ${actualplayers}</label></br>
</g:form>
</body>
</html>