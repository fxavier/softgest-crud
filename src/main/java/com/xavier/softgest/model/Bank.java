package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "bank_id")
    private Long id;

    @Column(name = "bank_name")
    private String name;
}
