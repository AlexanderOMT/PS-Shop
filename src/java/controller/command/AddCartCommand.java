
package controller.command;

import model.Product;


public class AddCartCommand extends FrontCommand{

    @Override
    public void process() {
        Product p = (Product) request.getAttribute("");
        
    }
    
}
