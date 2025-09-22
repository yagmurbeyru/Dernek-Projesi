package com.yagmurbeyru.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class DtoHaber extends DtoEtkinlik {

    private String haberLinki;
}
