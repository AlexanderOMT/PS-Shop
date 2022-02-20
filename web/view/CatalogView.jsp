<%-- 
    Document   : CatalogView
    Created on : 14-Feb-2022, 21:12:35
    Author     : oscar
--%>




<%@page import="java.io.InputStream"%>
<%@page import="java.security.AccessController.*"%>
<%@page import="java.security.AccessController"%>
<%@page import="model.Persistence.ProductArchiveLoader"%>
<%@page import="model.Catalog"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! 
    Catalog catalog;
    // String url = "C:\\Users\\oscar\\Documents\\Projects\\Netbeans\\Shop\\books_ulr.json";
    //  ProductArchiveLoader loader = new ProductArchiveLoader(url_context);
    //  List<Product> listProduct = catalog.loadListProduct(loader);
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
            String url_context = request.getServletContext().getRealPath("file/books_ulr.json");
            ProductArchiveLoader loader = new ProductArchiveLoader(url_context);
            List<Product> listProduct;
            
            if(catalog == null) {
                catalog = new Catalog();
                listProduct = catalog.loadListProduct(loader);
            }
            else{
                listProduct = catalog.getCatalog();
            }

            session.setAttribute("catalog", catalog);
            
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
        <%  }                

        %>
        
        <%
        %> 
    </body>
</html>
