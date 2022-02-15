
package model;

import java.util.List;


public class Catalog {
    
    private List<Product> listProduct;
    
    public Catalog(){}
    
    public void addProduct(Product product){
        this.listProduct.add(product);
    }
    
    public void removeProduct(Product product){
        this.listProduct.remove(product);
    }
    
    public void setListProduct(List<Product> listProduct){
        this.listProduct = listProduct;
    }
    
    public List<Product> getCatalog(){
        return this.listProduct;
    }
    
}
