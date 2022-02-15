<%-- 
    Document   : CatalogView
    Created on : 14-Feb-2022, 21:12:35
    Author     : oscar
--%>

<%@page import="model.Persistence.ProductArchiveLoader"%>
<%@page import="model.Catalog"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Catalog</title>
    </head>
    <body>
        <h1>Main Catalog</h1> <br>
        <form action="FrontController">
            <input type="submit" value="Cargar catálogo" />
        </form>
        <br>
        <%
            if (request.getAttribute("catalog") != null){
                List<Product> listProduct = (List<Product>)request.getAttribute("catalog");
                for (Product p: listProduct) {
                    %>
                    <div>
                    <%out.println(p.getTitle());%>
                    
                    </div>
                    <img src=<%out.println(p.getThumbnailUrl());%>>
                    <br>
                    
        <%        }
                out.println(listProduct.size());
                
            } else{  
                out.println("Productos no encontrado");
            }
        %>
        
        <%
        %> 
    </body>
</html>
