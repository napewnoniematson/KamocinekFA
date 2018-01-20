<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of books by publisher</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'index']">

    Books published by: <g:select name="selectedPublisher" from="${publishers}" value="${selectedPublisher? selectedPublisher : ''}"
                                  optionKey="id" optionValue="name" onchange="form.submit();" noSelection="['':'-Choose publisher-']"></g:select>
    <br>
    <g:if test="${!books.empty}">
        <p>Publisher: ${selectedPublisherName}</p>
        <h2>Books:</h2>
        <g:each in="${books}" var="book">
            <p>${book.coach.name}</p>
            <g:each in="${book.players}" var="player">
                <p>${player.name}</p>
            </g:each>
        </g:each>
    </g:if>


</g:form>
</body>
</html>