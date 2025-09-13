package com.problemsolving.mobiquity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {
    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        List<SimpleSoldProduct> lstprod = products.map(prod -> new SimpleSoldProduct(prod.getName(), prod.getPrice()))
                .collect(Collectors.toList());

        BigDecimal total = products.map(prod -> prod.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

        SoldProductsAggregate res = new SoldProductsAggregate(lstprod, total);

        return res;
    }
}
