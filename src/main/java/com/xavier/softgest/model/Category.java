package com.xavier.softgest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "category-1")
    private String name;

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }
}
