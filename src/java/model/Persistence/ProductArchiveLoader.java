
package model.Persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ProductArchiveLoader implements ProductLoader {
    private final String filePathName;
    
    public ProductArchiveLoader(String filePathName){
        this.filePathName = filePathName;
    }
    
    @Override
    public List<Product> loadAllProduct() {
       List<Product> listProduct = new ArrayList<>();
       JSONParser parser = new JSONParser();
       try{
            Object obj = parser.parse(new FileReader(this.filePathName));           
            
            JSONArray jsonArrayProduct = (JSONArray) obj;

            Iterator<JSONObject> iterator = jsonArrayProduct.iterator();
            
            while (iterator.hasNext()) {
                // TODO create Product

                
                // listProduct.add(new Product())
            }
           
       }catch (ParseException | FileNotFoundException ex) {
            Logger.getLogger(ProductArchiveLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductArchiveLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return listProduct;
    }
    
}
