<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><g:layoutTitle default="Grails"/></title>
    <asset:stylesheet src="application.css"/>
    <style>
    #header {background-color:#FFFFFF;text-align: center; height: 250px}
    #footer {background-color:#5e5e5e;text-align: center; height: 50px}
    </style>
    <g:layoutHead/>

</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'index']">

    <div id="header">
        <asset:image src="KamocinekFC.jpg" style="height: 250px"/>
    </div>
    <g:layoutBody/>
    <div id="footer">
        <p>KAMOCINEK FOOTBALL CLUB 2018 OWNER: MATEUSZ CYPEL</p>
    </div>

</g:form>
</body>
</html>