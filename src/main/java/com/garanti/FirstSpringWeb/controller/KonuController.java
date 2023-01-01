package com.garanti.FirstSpringWeb.controller;


import com.garanti.FirstSpringWeb.model.Konu;
import com.garanti.FirstSpringWeb.repo.KonuRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "konu")
public class KonuController {

    private KonuRepo repo;

    public KonuController() {
        this.repo = new KonuRepo();
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Konu> getAll() {
        return repo.getAll();
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Konu getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Konu getByIdPathParam(@PathVariable(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public Konu getByIdHeader(@RequestHeader(value = "id") Integer id) {
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
    public String save(@RequestBody Konu konu) {
        if (repo.save(konu)) {
            return "Başarı ile kaydedildi.";
        } else {
            return "Kayıt başarısız.";
        }
    }
}
