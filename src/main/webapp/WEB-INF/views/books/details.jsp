<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Book details</title>

    <c:import url="../fragments/head.jsp"/>

</head>
<body>

    <c:import url="../fragments/header.jsp"/>

    <table>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Type</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td><c:out value="${bookDTO.isbn}"/></td>
            <td><c:out value="${bookDTO.title}"/></td>
            <td><c:out value="${bookDTO.author}"/></td>
            <td><c:out value="${bookDTO.publisher}"/></td>
            <td><c:out value="${bookDTO.type}"/></td>
            <td>
                <a href="/admin/books/edit?id=<c:out value="${bookDTO.id}"/>">Edit</a>,
                <a href="/admin/books/confirm-delete?id=<c:out value="${bookDTO.id}"/>">Delete</a>
            </td>
        </tr>
    </table>

</body>
</html>
