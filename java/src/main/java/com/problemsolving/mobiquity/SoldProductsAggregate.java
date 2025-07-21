package com.problemsolving.mobiquity;

import java.math.BigDecimal;
import java.util.List;

public class SoldProductsAggregate {
    public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public SoldProductsAggregate() {
    }

    List<SimpleSoldProduct> products;
    BigDecimal total;

    public List<SimpleSoldProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SimpleSoldProduct> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
