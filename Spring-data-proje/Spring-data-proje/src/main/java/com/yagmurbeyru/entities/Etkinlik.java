package com.yagmurbeyru.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "etkinlik")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etkinlik_turu", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public abstract class Etkinlik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Konu boş olamaz")
    @Size(max = 200, message = "Konu 200 karakteri geçemez")
    @Column(name = "konu", nullable = false, length = 200)
    private String konu;

    @NotBlank(message = "İçerik boş olamaz")
    @Size(max = 5000, message = "İçerik 5000 karakteri geçemez")
    @Column(name = "icerik", nullable = false, length = 5000)
    private String icerik;

    @NotNull(message = "Geçerlilik tarihi boş olamaz")
    @Column(name = "gecerlilik_tarihi", nullable = false)
    private LocalDateTime gecerlilikTarihi;



    // Custom constructor
    public Etkinlik(String konu, String icerik, LocalDateTime gecerlilikTarihi) {
        this.konu = konu;
        this.icerik = icerik;
        this.gecerlilikTarihi = gecerlilikTarihi;
    }
}
