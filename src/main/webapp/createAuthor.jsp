<%-- 
    Document   : createAuthor
    Created on : Mar 2, 2016, 5:25:10 PM
    Author     : dvandenberge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Author</title>
    </head>
    <body>
        <h1>Enter Author Info</h1>
        <form method="POST" action="AuthorController">
            <label>Author Name</label>
            <input type="text" value="Enter Author Name Here"  name="authorName">
            <input type="submit" value="Create" name="action">
            <input type="submit" value="Cancel" name="action">
        </form>
    </body>
</html>
