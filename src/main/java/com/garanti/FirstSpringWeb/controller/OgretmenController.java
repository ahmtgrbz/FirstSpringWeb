package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ogretmen;
import com.garanti.FirstSpringWeb.repo.OgretmenRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ogretmen")
public class OgretmenController {
    private OgretmenRepo repo;

    public OgretmenController(OgretmenRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "findAllByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ogretmen>> findAllByName(@RequestParam(value = "name", required = true) String name) {
        return ResponseEntity.ok(this.repo.getAllLike(name));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ogretmen>> getAll() {
        List<Ogretmen> res = repo.getAll();
        if (res == null || res.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        Ogretmen res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdPathParam(@PathVariable(value = "id") Integer id) {
        Ogretmen res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ogretmen> getByIdHeader(@RequestHeader(value = "id") Integer id) {
        Ogretmen res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id) {
        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi.");
        } else {
            return ResponseEntity.internalServerError().body("Silme başarısız.");
        }
    }

    @DeleteMapping(value = "deleteByIdHeader")
    public ResponseEntity<String> deleteByHeader(@RequestHeader(value = "id") Integer id) {

        if (repo.deleteById(id)) {
            return ResponseEntity.ok("Başarı ile silindi.");
        } else {
            return ResponseEntity.internalServerError().body("Silme başarısız.");
        }
    }

    // ResponseEntity
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Ogretmen ogretmen) {
        if (repo.save(ogretmen)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Basarı ile kaydedildi");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kayıt Başarısız");
        }
    }
}
