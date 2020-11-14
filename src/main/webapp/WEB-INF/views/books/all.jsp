<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Books list</title>

    <c:import url="../fragments/head.jsp"/>

</head>
<body>

    <c:import url="../fragments/header.jsp"/>

    <table>
        <tr>
            <th>Id</th>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Type</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${bookDTOS}" varStatus="index">
            <tr>
                <td><c:out value="${index.index + 1}"/></td>
                <td><c:out value="${book.isbn}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.publisher}"/></td>
                <td><c:out value="${book.type}"/></td>
                <td>
                    <a href="/admin/books/edit?id=<c:out value="${book.id}"/>">Edit</a>,
                    <a href="/admin/books/confirm-delete?id=<c:out value="${book.id}"/>">Delete</a>,
                    <a href="/admin/books/details?id=<c:out value="${book.id}"/>">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
