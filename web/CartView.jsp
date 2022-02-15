<%-- 
    Document   : CartView
    Created on : 14-Feb-2022, 21:16:07
    Author     : oscar
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Cart</h1>
        <%
            if (request.getAttribute("cart") != null){
                List<Product> listProduct = (List<Product>)request.getAttribute("cart");
                for (Product p: listProduct) {
                    out.println(p.getTitle());
                }
            } else{  
                out.println("No hay Producto(s) en su carrito");
            }
        %>
    </body>
</html>
