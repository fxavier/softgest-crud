package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "unity-1")
    @Column(name = "unity_name")
    private String name;
}
