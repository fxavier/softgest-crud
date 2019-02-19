package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "unity")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "unity_id")
    private Long id;

    @Column(name = "unity_name")
    private String name;
}
