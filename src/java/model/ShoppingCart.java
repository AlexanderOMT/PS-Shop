
package model;

import java.util.List;



public class ShoppingCart {
    
    private List<Product> cart;
    
    public ShoppingCart(){}
    
    public void addProduct(Product product){
        cart.add(product);
    }
    
    public void removeProduct(Product product){
        cart.remove(product);
    }
    
    public List<Product> getCart(){
        return cart;
    }
    
}
