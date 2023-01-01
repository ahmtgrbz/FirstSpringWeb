package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ogretmen;
import com.garanti.FirstSpringWeb.repo.OgretmenRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "ogretmen")
public class OgretmenController{

    private OgretmenRepo repo;
    public OgretmenController() {
        this.repo = new OgretmenRepo();
    }

    //Arraylisti json array olarak geri veriyor. GetAll için yazdığımız metod.
    @GetMapping(value = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Ogretmen> getAll() {
        return repo.getAll();
    }

    //queryParam anotasyonu ile yaptım.
    @GetMapping(value = "getById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogretmen getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        return repo.getById(id);
    }

    //PathParam anotasyonu ile yaptık.
    @GetMapping(value = "getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogretmen getByIdPathParam(@PathVariable(value = "id") Integer id) {
        return repo.getById(id);
    }

    @GetMapping(value = "getByIdHeader",produces = MediaType.APPLICATION_JSON_VALUE)
    public Ogretmen getByIdHeader(@RequestHeader(value = "id") Integer id) {
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

    // ResponseEntity
    @PostMapping(value = "save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Ogretmen ogretmen) {
        if (repo.save(ogretmen)) {
            return "Başarı ile kaydedildi.";
        } else {
            return "Kayıt başarısız.";
        }
    }
}
