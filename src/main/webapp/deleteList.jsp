<%-- 
    Document   : deleteList
    Created on : Feb 29, 2016, 7:03:08 PM
    Author     : dvandenberge
--%>
<%@page import="edu.wctc.dfb.bookwebappmaven.model.Author" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Authors</h1>

        <form method="POST" action="AuthorController?action=deleteAuthor">
            <table>
                <tr>
                    <th>Author Name</th>
                    <th>Author Id</th>
                    <th>Date Added</th>
                    <th>DELETE</th>
                </tr>

                <c:forEach items="${authorList}" var="author" begin="0" end="${endOfList}">
                    <tr>
                        <td>
                    <c:out value="${author.getAuthorName()}"/>
                    </td>
                    <td>
                    <c:out value="${author.getAuthorId()}"/>
                    </td>
                    <td>
                    <c:out value="${author.getDateAdded()}"/>
                    </td>
                    <td><input type="submit" value="${author.getAuthorId()}" name="authorID"></td>
                    </tr>
                </c:forEach>

            </table>
        </form>
    </body>
</html>
