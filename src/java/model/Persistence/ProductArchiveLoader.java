
package model.Persistence;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            
            while (iterator.hasNext()) {
                
                JSONObject jsonProduct = (JSONObject) iterator.next();
                String jsonProductString = jsonProduct.toJSONString();
                
                Object objects = objectMapper.readValue(jsonProductString, Product.class);
                Product product = (Product)objects;
                
                listProduct.add(product);
            }
           
       }catch (ParseException | FileNotFoundException ex) {
            Logger.getLogger(ProductArchiveLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductArchiveLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return listProduct;
    }
    
}
