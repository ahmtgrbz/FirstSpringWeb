package com.garanti.FirstSpringWeb.model;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
// lombok yukarıdaki anotasyonlar ile otomatik oluşturmayı sağlıyor.
public class Person {
    private int yas;
    private String isim;

    public Person(int yas, String isim) {
        this.yas = yas;
        this.isim = isim;
    }
}
