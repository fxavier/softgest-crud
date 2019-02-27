package com.xavier.softgest.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_suplier")
@Data
public class ProductSuplier {

    @EmbeddedId
    private ProductSuplierId id;
}
