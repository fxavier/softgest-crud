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

@Entity
@Table(name = "subcategory")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "subcategory_id")
    private Long id;

    @NotBlank(message = "subcategory-1")
    private String name;

    @NotNull(message = "subcategory-2")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }
}
