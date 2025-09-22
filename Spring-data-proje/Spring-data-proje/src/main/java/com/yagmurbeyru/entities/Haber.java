package com.yagmurbeyru.entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("HABER")
public class Haber extends Etkinlik {

    @Size(max = 500, message = "Haber linki en fazla 500 karakter olabilir")
    @Column(name = "haber_linki", length = 500)
    private String haberLinki;
}

