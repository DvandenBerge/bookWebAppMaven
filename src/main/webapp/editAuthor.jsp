<%-- 
    Document   : editAuthor
    Created on : Feb 29, 2016, 5:46:26 PM
    Author     : dvandenberge
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="edu.wctc.dfb.bookwebappmaven.model.Author" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Author</title>
    </head>
    <body>
        <h1>Edit Author</h1>
        <form action="AuthorController" method="POST">
        <input type="text" value="${authorToEdit.getAuthorId()}" name="authorId" readonly/>
        <input type="text" value="${authorToEdit.getAuthorName()}" name="authorName" />
        <input type="submit" value="Cancel" name="action">
        <input type="submit" value="Save" name="action">
        </form>
    </body>
</html>
