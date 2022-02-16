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
                    <br>
                    <%if (p.getShortDescription() != null)
                        out.println(p.getShortDescription());%>
                    </div>
                    <img src=<%out.println(p.getThumbnailUrl());%>>
                        <form action="FrontController">
                            <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                            <input type="hidden" name="command" value="AddCartCommand"/>
                            <input type="submit" value="<%="Añadir a carrito: " + p.getTitle()%>"/>
                    </form>
                    <br>
                    
        <%        }
                out.println(listProduct.size());
                
            } else{  
                out.println("Productos no encontrado. Intente cargar el catálogo");
            }
        %>
        
        <%
        %> 
    </body>
</html>
