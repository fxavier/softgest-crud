package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "supplier")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @NotBlank(message = "supplier-1")
    @Column(name = "supplier_name")
    private String supplierName;

    @NotBlank(message = "supplier-2")
    @Column(name = "supplier_website")
    private String supplierWebsite;

    @NotBlank(message = "supplier-3")
    @Column(name = "supplier_email")
    private String supplierEmail;

    @NotBlank(message = "supplier-4")
    @Column(name = "supplier_phone")
    private String supplierPhone;

    @NotBlank(message = "supplier-5")
    @Column(name = "supplier_cell")
    private String supplierCell;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    private BigDecimal balance;

    private String account;

    private String observation;

    @NotNull(message = "supplier-6")
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }
}
