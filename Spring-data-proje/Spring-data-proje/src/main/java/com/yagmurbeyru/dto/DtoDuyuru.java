package com.yagmurbeyru.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DtoDuyuru extends DtoEtkinlik {

    private String resimYolu;
}

