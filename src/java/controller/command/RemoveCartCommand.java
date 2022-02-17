
package controller.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Catalog;
import model.Product;
import model.ShoppingCart;

public class RemoveCartCommand extends FrontCommand{

    @Override
    public void process() {
        HttpSession session = request.getSession(true);

        Catalog catalog = (Catalog) session.getAttribute("catalog");
        ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");

        if(shopCart == null){
            shopCart = new ShoppingCart();
            session.setAttribute("shopCart", shopCart);
        }
        
        Product product = catalog.getProductByIsbn((String) request.getParameter("isbn"));
        
        shopCart.removeProduct(product);
        session.setAttribute("shopCart", shopCart);

        try {
            forward("/CartView.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
