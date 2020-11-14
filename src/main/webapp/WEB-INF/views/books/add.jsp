<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add new book</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>

    <c:import url="../fragments/header.jsp"/>

    <form:form modelAttribute="bookDTO">
        <fieldset>
            <legend>Book data:</legend>
            <form:hidden path="id"/>

            <form:label path="isbn">ISBN: </form:label>
            <form:input path="isbn"/>
            <form:errors path="isbn" cssClass="text-danger"/>
            <br/>
            <form:label path="title">Title: </form:label>
            <form:input path="title"/>
            <form:errors path="title" cssClass="text-danger"/>
            <br/>
            <form:label path="author">Author: </form:label>
            <form:input path="author"/>
            <form:errors path="author" cssClass="text-danger"/>
            <br/>
            <form:label path="publisher">Publisher: </form:label>
            <form:input path="publisher"/>
            <form:errors path="publisher" cssClass="text-danger"/>
            <br/>
            <form:label path="type">Type: </form:label>
            <form:input path="type"/>
            <form:errors path="type" cssClass="text-danger"/>
            <br/>
            <input type="submit" value="Add"/>
        </fieldset>
    </form:form>
</body>
</html>
