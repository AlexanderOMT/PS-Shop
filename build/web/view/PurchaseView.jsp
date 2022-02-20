<%-- 
    Document   : PurchaseView
    Created on : 14-Feb-2022, 21:16:58
    Author     : oscar
--%>

<%@page import="model.ShoppingCart"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase</title>
    </head>
    <body>
        <h1>Purchase</h1>
        <%out.println("Lista de productos: ");%>
        <%ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");%>
        <%
            for (Product p: shopCart.getCart()) {
        %>
            <div>
                <b>
                    <%out.println("\n" + p.getTitle() + " -> precio: " + p.getPrice() + " €");%>
                </b>
            </div>
        <%
            }
        %>
        <p>
            <%out.println("\n-------------------------------------------------------------------");%>
            
        </p>
        <%out.println("\nTotal precio: " + shopCart.getCartPrice());%>
        <form action="FrontController">
            <input type="hidden" name="command" value="ConfirmPurchaseCommand"/>
            <input type="submit" value="<%="Confirmar compra"%>"/>
        </form>
    </body>
</html>
