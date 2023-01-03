package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ogretmen {

    private Integer ID;
    private String NAME;
    private boolean IS_GICIK;

}