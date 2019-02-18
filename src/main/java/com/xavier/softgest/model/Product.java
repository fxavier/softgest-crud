package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @Column(name = "other_expense")
    private BigDecimal otherExpenses;

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    private BigDecimal vat;

    @Column(name = "sell_price_vat")
    private BigDecimal sellPriceVatIncluded;

    private BigDecimal profit;

    private Long quantity;

    @Column(name = "min_stock")
    private Long minStock;

    @Column(name = "max_stock")
    private Long maxStock;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;
}
