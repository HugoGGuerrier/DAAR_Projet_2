package com.lambda.cvlibrary;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "CV")
public class CV {

    // ----- Attributes -----

    @Id
    private String id;

    private String name;

    private String text;


    // ----- Getters -----

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getText() {
        return text;
    }

    // ----- Setters -----
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

}
