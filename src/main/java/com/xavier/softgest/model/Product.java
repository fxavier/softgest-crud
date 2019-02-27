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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "product-1")
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

    @NotNull(message = "product-2")
    @Column(name = "sell_price_vat")
    private BigDecimal sellPriceVatIncluded;

    private BigDecimal profit;

    @NotNull(message = "product-3")
    private Long quantity;

    @NotNull(message = "product-4")
    @Column(name = "min_stock")
    private Long minStock;

    @NotNull(message = "product-5")
    @Column(name = "max_stock")
    private Long maxStock;

    @Column(name = "batch_number")
    private String batchNumber;

    @NotNull(message = "product-6")
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    public Boolean isNew() {
     return this.id == null;
    }

    public Boolean exists() {
     return this.id != null;
    }
}
