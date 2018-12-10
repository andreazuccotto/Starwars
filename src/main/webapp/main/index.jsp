<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <h2>Home page</h2>
        
        <p>Available actions:</p>
        
        <ul>
            <li><a href="controller?action=listcars">Show all</a></li>
            <li><a href="controller?action=readbyid">Show car by ID</a></li>
            <li><a href="controller?action=readcar">Create a new car</a></li>
        </ul>
        
        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>      
        
    </body>
</html>