package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "currency_id")
    private Long id;

    @Column(name = "currency_name")
    private String name;

    @Column(name = "currency_code")
    private String code;
}
