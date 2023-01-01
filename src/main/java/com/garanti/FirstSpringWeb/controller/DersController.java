package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.repo.DersRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "ders")
public class DersController {

    private DersRepo repo;

    public DersController() {
        this.repo = new DersRepo();
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Ders> getAll() {
        return repo.getAll();
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders getByIdPathParam(@PathVariable(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ders getByIdHeader(@RequestHeader(value = "id") Integer id) {
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
    public String save(@RequestBody Ders ders) {
        if (repo.save(ders)) {
            return "Başarı ile kaydedildi.";
        } else {
            return "Kayıt başarısız.";
        }
    }
}
