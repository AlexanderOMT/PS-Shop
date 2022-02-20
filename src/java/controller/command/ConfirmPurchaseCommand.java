
package controller.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.ShoppingCart;


public class ConfirmPurchaseCommand extends FrontCommand{
    
    @Override
    public void process() {
        
        HttpSession session = request.getSession(true);
        
        ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");
        shopCart.clearCart();
        
        session.setAttribute("shopCart", shopCart);
        
        try {
            forward("/view/CartView.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UnknownCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
