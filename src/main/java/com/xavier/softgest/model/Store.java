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
@Table(name = "store")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "store_id")
    private Long id;

    @NotBlank(message = "store-1")
    @Column(name = "store_name")
    private String name;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "cell_number")
    private String cell;

    private String address;

    public Boolean isNew() {
      return this.id == null;
    }

    public Boolean exists() {
      return this.id != null;
    }
}
