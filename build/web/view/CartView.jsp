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
            ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");
            
            if (shopCart != null){
                if (shopCart.getCart().size() != 0){
                for (Product p: shopCart.getCart()) {
                    %>
                    <div>
                        <h4><%out.println(p.getTitle());%></h4>
                        <p>
                            <%out.println("\nNúmero de copia: " + shopCart.getFrequencyProduct(p));%>
                        </p>
                        <b>
                            <%out.println("\nPrecio por unidad: " + p.getPrice() + " €");%>
                        </b>
                        <b>
                            <%out.println("\nPrecio por conjunto: " + p.getPrice() * shopCart.getFrequencyProduct(p) + " €");%>
                        </b>
                    </div>
                    <img src=<%out.println(p.getThumbnailUrl());%>>
                    <br>
                    <form action="FrontController">
                        <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                        <input type="hidden" name="command" value="IncrementFromCartCommand"/>
                        <input type="submit" value="<%="Incrementar una unidad del producto "%>"/>
                    </form>  
                    <br>
                    <form action="FrontController">
                        <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                        <input type="hidden" name="command" value="DecrementFromCartCommand"/>
                        <input type="submit" value="<%="Decrementar una unidad del producto "%>"/>
                    </form>
                    <br>
                    <form action="FrontController">
                        <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                        <input type="hidden" name="command" value="RemoveCartCommand"/>
                        <input type="submit" value="<%="Eliminar del carrito " + p.getTitle()%>"/>
                    </form>
                    <br>
        
        <%      } %>  
            <form action="FrontController">
                <input type="hidden" name="command" value="ClearCartCommand"/>
                <input type="submit" value="Vaciar carrito"/>
            </form>
            <br>
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
