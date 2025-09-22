package com.yagmurbeyru.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DtoEtkinlik {

    private Integer id;
    private String konu;
    private String icerik;
    private LocalDateTime gecerlilikTarihi;
}
