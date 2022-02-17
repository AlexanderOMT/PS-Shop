<%-- 
    Document   : CartView
    Created on : 14-Feb-2022, 21:16:07
    Author     : oscar
--%>

<%@page import="model.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%! ShoppingCart shopCart = new ShoppingCart();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Cart</h1>
        <a href="CatalogView.jsp">Ir a Catálogo</a>
        <br>
        <br>
        <%
            shopCart = (ShoppingCart) session.getAttribute("shopCart");
            
            if (shopCart != null){
                if (shopCart.getCart().size() != 0){
                for (Product p: shopCart.getCart()) {
                    %>
                    <div>
                        <h4><%out.println(p.getTitle());%></h4>
                        <b>
                            <%if (p.getPrice() != null)
                            out.println("\nPrecio: " + p.getPrice() + " €");%>
                        </b>
                    </div>
                    <img src=<%out.println(p.getThumbnailUrl());%>>
                    <form action="FrontController">
                        <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                        <input type="hidden" name="command" value="RemoveCartCommand"/>
                        <input type="submit" value="<%="Eliminar del carrito " + p.getTitle()%>"/>
                    </form>
                    <br>
        
        <%      } %>  
                <form action="FrontController">
                        <input type="hidden" name="command" value="BuyCartCommand"/>
                        <input type="submit" value="<%="Comprar total(" + shopCart.getCartPrice() + ")"%>"/>
                </form>
        <%            
                    }  else{  
                out.println("\nCarrito vacío.");
            }              
            } else{  
                out.println("\nCarrito vacío.");
            }
        %>
    </body>
</html>
