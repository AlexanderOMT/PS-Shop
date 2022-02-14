
package model;

import java.util.Date;
import java.util.List;

public class Product {
    
    private final String title;
    private final Integer isbn;
    private final Integer pageCount;
    private final Date publishedDate;
    private final String thumbnailUrl;
    private final String shortDescription;
    private final String longDescription;
    private final String status;
    private final List<String> authors;
    private final List<String> categories;
       
    public Product(String title,
            Integer isbn,
            Integer pageCount,
            Date publishedDate,
            String thumbnailUrl,
            String shortDescription,
            String longDescription,
            String status,
            List<String> authors,
            List<String> categories){
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.thumbnailUrl = thumbnailUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.status = status;
        this.authors = authors;
        this.categories = categories;
    }
    
}
