
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ShoppingCart {
    
    private final HashMap<String, Product> cart;
    
    public ShoppingCart(){
        cart = new HashMap<>();
    }
    
    public void addProduct(Product product){
        cart.put(product.getIsbn(), product);
    }
    
    public void removeProduct(Product product){
        cart.remove(product.getIsbn());
    }

    public void clearCart(){
        cart.clear();
    }
    
    public List<Product> getCart(){
        List<Product> list = new ArrayList<>();
        for(Object p : cart.values().toArray()){
            list.add((Product)p);
        }
        return list;
    }
    
    public Integer getCartPrice(){
        Integer price = 0;
        for(Object p : cart.values().toArray()){
            Product product = (Product)p;
            price += product.getPrice();
        }
        return price;
    }
    
}
