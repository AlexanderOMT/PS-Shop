/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Catalog;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author oscar
 */
public class DecrementFromCartCommand extends FrontCommand {

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
        
        shopCart.decrementProduct(product);
        
        session.setAttribute("shopCart", shopCart);

        try {
            forward("/view/CartView.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
