<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add book</title>
</head>
<body>
<g:form controller="book" action="save">
    <label>Title: </label><g:textField name="title" value="${book?.title}"/><g:renderErrors bean="${book}" as="list" field="title"/> <br>
    <label>Author: </label><g:textField name="author" value="${book?.author}"/><g:renderErrors bean="${book}" as="list" field="author"/><br>
    <label>Pages: </label><g:textField name="pages" value="${book?.pages}"/><g:renderErrors bean="${book}" as="list" field="pages"/><br>
    <label>Publisher: </label><g:select name="publisher.id" from="${publishers}" optionKey="id" optionValue="name" value="${publisher}"/>
    <g:renderErrors bean="${book}" as="list" field="publisher"/><br>
    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>