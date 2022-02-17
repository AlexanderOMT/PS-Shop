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

<%! 
    Catalog catalog = new Catalog();
    String url = "C:\\Users\\oscar\\Documents\\Projects\\Netbeans\\Shop\\books_ulr.json";
    String url_context = "\\books_ulr.json";
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Catalog</title>
    </head>
    <body>
        <h1>Main Catalog</h1> <br>

        <br>
        <a href="CartView.jsp">Ir a Carrito</a> <br />
        <br>
        
        <%
            ProductArchiveLoader loader = new ProductArchiveLoader(url);
            List<Product> listProduct = catalog.loadListProduct(loader);
            session.setAttribute("catalog", catalog);
            
            if (listProduct != null){
                for (Product p: listProduct) {
                    %>
                    <div>
                        <h2>
                            <%out.println(p.getTitle());%>
                        </h2>
                        <p>
                                <%if (p.getShortDescription() != null)
                                    out.println("Descrición " + p.getShortDescription());%>
                        </p>
                        <p>    
                            <b>
                                <%if (p.getPrice() != null)
                                out.println("Precio: " + p.getPrice() + " €");%>
                            </b>
                        </p>
                    </div>
                    <img src=<%out.println(p.getThumbnailUrl());%>>
                    <form action="FrontController">
                        <input type="hidden" name="isbn" value="<%=p.getIsbn()%>"/>
                        <input type="hidden" name="command" value="AddCartCommand"/>
                        <input type="submit" value="<%="Añadir a carrito: " + p.getTitle()%>"/>
                    </form>
                    <br>
        <%        }                
            } else{  
                out.println("Productos no encontrado en el catálogo");
            }
        %>
        
        <%
        %> 
    </body>
</html>
