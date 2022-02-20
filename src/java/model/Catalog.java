
package model;

import java.util.ArrayList;
import java.util.List;
import model.Persistence.ProductLoader;


public class Catalog {
    
    private List<Product> listProduct;
    
    public Catalog(){
        this.listProduct = new ArrayList<>();
    }

    
    public Product getProductByIsbn(String isbn) {
        for(Product p : listProduct){
            if(p.getIsbn().equals(isbn)) return p;
        }
        return null;
    }
    
    public void addProduct(Product product){
        this.listProduct.add(product);
    }
    
    public void removeProduct(Product product){
        this.listProduct.remove(product);
    }
    
    public List<Product> loadListProduct(ProductLoader loader){
        this.listProduct = loader.loadAllProduct();
        return listProduct;
    }
    
    public List<Product> getCatalog(){
        return this.listProduct;
    }
    
}
