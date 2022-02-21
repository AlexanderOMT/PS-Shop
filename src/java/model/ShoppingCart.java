
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ShoppingCart {
    
    private final HashMap<Product, Integer> cart;
    
    public ShoppingCart(){
        cart = new HashMap<>();
    }

    public void removeProduct(Product product){
        cart.remove(product);
    }

    public void incrementProduct(Product product){
        cart.put(product, cart.containsKey(product) ? cart.get(product)+1 : 1);
    }
    
    public void decrementProduct(Product product){
        if(cart.get(product) == 1) {
            removeProduct(product);
        }
        else{
            cart.put(product, cart.get(product)-1);
        }
    }
    
    public Integer getFrequencyProduct(Product product){
        return cart.get(product);
    }

    public void clearCart(){
        cart.clear();
    }
    
    public List<Product> getCart(){
        List<Product> list = new ArrayList<>();
        for(Object p : cart.keySet().toArray()){
            list.add((Product)p);
        }
        return list;
    }
    
    public Integer getCartPrice(){
        Integer price = 0;
        for(Object p : cart.keySet().toArray()){
            Product product = (Product)p;
            price += product.getPrice() * this.getFrequencyProduct(product);
        }
        return price;
    }
    
}
