package com.dmitrenko.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Integer id;
    private String name;
    private Integer price;
    private String category;

    public Game(Integer id, String name, Integer price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Game(String name, Integer price, String category) {
        this(null, name, null, category);
    }

    @Override
    public String toString() {
        return "\n\nGame: id: " + id + ", name: " + name + ", price: " + price
                + ", category: " + category;
    }
}
