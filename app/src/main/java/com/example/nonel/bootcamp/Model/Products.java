package com.example.nonel.bootcamp.Model;

public class Products {
    private String name;
    private String description;
    private Float price;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPrice(Float price){
        this.price = price;
    }

    public Float getPrice(){
        return price;
    }
}
