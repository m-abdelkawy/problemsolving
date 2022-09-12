package com.problemsolving.mobiquity;

import java.math.BigDecimal;

public class SimpleSoldProduct {

    private String name;
    private BigDecimal price;

    public SimpleSoldProduct() {
    }

    public SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
