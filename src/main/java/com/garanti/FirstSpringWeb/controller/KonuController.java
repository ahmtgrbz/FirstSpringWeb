package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Konu;
import com.garanti.FirstSpringWeb.repo.KonuRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "konu")
public class KonuController {

    private KonuRepo repo;

    public KonuController(KonuRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Konu>> getAll() {
        List<Konu> res = repo.getAll();
        if (res == null || res.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping(value = "findAllByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Konu>> findAllByName(@RequestParam(value = "name", required = true) String name) {
        return ResponseEntity.ok(this.repo.getAllLike(name));
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Konu> getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        Konu res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Konu> getByIdPathParam(@PathVariable(value = "id") Integer id) {
        Konu res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Konu> getByIdHeader(@RequestHeader(value = "id") Integer id) {
        Konu res = repo.getById(id);
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

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Konu konu) {
        if (repo.save(konu)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Basarı ile kaydedildi");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kayıt Başarısız");
        }
    }
}
