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

@Entity
@Table(name = "brand")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "brand_id")
    private Long id;

    @NotBlank(message = "brand-1")
    @Column(name = "brand_name")
    private String name;

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }
}
