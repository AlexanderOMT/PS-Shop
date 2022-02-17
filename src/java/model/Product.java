
package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Product {
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("isbn")
    private String isbn;
    
    @JsonProperty("pageCount")
    private Integer pageCount;
    
    @JsonProperty("publishedDate")
    private Object publishedDate;
    
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    
    @JsonProperty("shortDescription")
    private String shortDescription;
    
    @JsonProperty("longDescription")
    private String longDescription;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("authors")
    private List<String> authors;
    
    @JsonProperty("categories")
    private List<String> categories;
    
    private Integer price = (int)(Math.random()*(100-10)+10);
       
    public Product(){}
    
    public Product(String title,
            String isbn,
            Integer pageCount,
            Object publishedDate,
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
    
    
    public String getTitle(){
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getPublishedDate() {
        return (String) publishedDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getCategories() {
        return categories;
    }
    
    public Integer getPrice() {
        return price;
    }

    
}
