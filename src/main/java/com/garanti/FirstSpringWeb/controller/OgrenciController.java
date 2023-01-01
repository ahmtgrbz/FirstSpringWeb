package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ogrenci;
import com.garanti.FirstSpringWeb.repo.OgrenciRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "ogrenci")
public class OgrenciController {

    private OgrenciRepo repo;

    public OgrenciController() {
        this.repo = new OgrenciRepo();
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Ogrenci> getAll() {
        return repo.getAll();
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogrenci getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogrenci getByIdPathParam(@PathVariable(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogrenci getByIdHeader(@RequestHeader(value = "id") Integer id) {
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
    public String save(@RequestBody Ogrenci ogrenci) {
        if (repo.save(ogrenci)) {
            return "Başarı ile kaydedildi.";
        } else {
            return "Kayıt başarısız.";
        }
    }
}
