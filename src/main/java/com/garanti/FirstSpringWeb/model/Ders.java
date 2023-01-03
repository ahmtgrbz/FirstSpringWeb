package com.garanti.FirstSpringWeb.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ders
{
    private Integer ID;
    // bu bir foreign key 'dir
    private Integer OGR_ID;
    // bu bir foreign key 'dir
    private Integer KONU_ID;
}
