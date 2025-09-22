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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("DUYURU")
public class Duyuru extends Etkinlik {

    @Size(max = 500, message = "Resim yolu en fazla 500 karakter olabilir")
    @Column(name = "resim_yolu", length = 500)
    private String resimYolu;
}
