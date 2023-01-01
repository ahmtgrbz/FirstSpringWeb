package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ders_Ogrenci;
import com.garanti.FirstSpringWeb.repo.Ders_OgrenciRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "dersogrenci")
public class DersOgrenciController {

    private Ders_OgrenciRepo repo;

    public DersOgrenciController() {
        this.repo = new Ders_OgrenciRepo();
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Ders_Ogrenci> getAll() {
        return repo.getAll();
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders_Ogrenci getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders_Ogrenci getByIdPathParam(@PathVariable(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders_Ogrenci getByIdHeader(@RequestHeader(value = "id") Integer id) {
        return repo.getById(id);
    }

    @DeleteMapping(value = "deleteById/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id) {

        if (repo.deleteById(id)) {
            return "Başarı ile silindi.";
        } else {
            return "Silme başarısız.";
        }
    }

    @DeleteMapping(value = "deleteByIdHeader")
    public String deleteByHeader(@RequestHeader(value = "id") Integer id) {

        if (repo.deleteById(id)) {
            return "Başarı ile silindi.";
        } else {
            return "Silme başarısız.";
        }
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Ders_Ogrenci dersOgrenci) {
        if (repo.save(dersOgrenci)) {
            return "Başarı ile kaydedildi.";
        } else {
            return "Kayıt başarısız.";
        }
    }


}
