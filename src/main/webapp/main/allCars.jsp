<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cars</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
              integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
              crossorigin="anonymous">  

        <style>
            body { padding:1em }
            nav { margin-top: 2em }
        </style>
    </head>
    <body>

        <h2>All cars</h2>

        <table class="pure-table pure-table-horizontal">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>

            <c:forEach items="${carList}" var='car'>
                <tr>
                    <td>
                        <c:out value="${car.id}"/>
                    </td>
                    <td>
                        <c:out value="${car.name}"/>
                    </td>
                    <td>
                        <c:out value="${car.price}"/>
                    </td>                    
                </tr>
            </c:forEach>          

        </table>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>  

    </body>
</html>