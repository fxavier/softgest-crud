package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "customer")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "customer_id")
    private Long id;

    @NotBlank(message = "customer-1")
    @Column(name = "customer_name")
    private String name;

    @NotBlank(message = "customer-2")
    @Column(name = "phone_number")
    private String phone;

    @NotBlank(message = "customer-3")
    @Column(name = "cell_number")
    private String cell;

    @NotBlank(message = "customer-4")
    private String email;

    @NotBlank(message = "customer-5")
    private String account;

    @Column(name = "credit_limit")
    private BigDecimal CreditLimit;

    private BigDecimal credit;

    private Boolean active;

    public Boolean isNew() {
       return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }
}
