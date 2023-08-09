package com.codegym.model;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long price;
    private long old;
    private long card;
    private String description;
    private String image;
    public Product() {
    }

    public Product(Long id, String name, long price, long old, long card, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.old = old;
        this.card = card;
        this.description = description;
        this.image = image;
    }

    public Product(String name, long price, long old, long card, String description, String image) {
        this.name = name;
        this.price = price;
        this.old = old;
        this.card = card;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getOld() {
        return old;
    }

    public void setOld(long old) {
        this.old = old;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }
}
