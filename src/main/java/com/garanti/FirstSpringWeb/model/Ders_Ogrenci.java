package com.garanti.FirstSpringWeb.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ders_Ogrenci {
    private Integer ID;
    private Integer DERS_ID;
    private Integer OGRENCI_ID;
    private Integer NOTE;
    private Integer DEVAMSIZLIK;
}
