package com.xavier.softgest.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
@Table(name = "country")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "country_id")
    private Long id;

    @NotBlank(message = "country-1")
    @Column(name = "country_name")
    private String name;

    public Boolean isNew() {
        return this.id == null;
    }

    public Boolean exists() {
        return this.id != null;
    }

}

