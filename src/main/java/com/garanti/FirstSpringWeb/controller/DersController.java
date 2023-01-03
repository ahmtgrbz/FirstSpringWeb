package com.garanti.FirstSpringWeb.controller;

import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.repo.DersRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ders")
public class DersController {

    private DersRepo repo;

    public DersController(DersRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ders>> getAll() {
        List<Ders> res = repo.getAll();
        if (res == null || res.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    //Join gerekli olduğu için dersler için findallbyname ve repoda - getAllLike sınırlı yazıldı. Güncelle.
    @GetMapping(value = "findAllByKonuId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ders>> findAllByName(@RequestParam(value = "konuid", required = true) int konuid) {
        return ResponseEntity.ok(this.repo.getAllLike(konuid));
    }

    @GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdQueryParam(@RequestParam(value = "id") Integer id) {
        Ders res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdPathParam(@PathVariable(value = "id") Integer id) {
        Ders res = repo.getById(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping(value = "getByIdHeader", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ders> getByIdHeader(@RequestHeader(value = "id") Integer id) {
        Ders res = repo.getById(id);
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
    public ResponseEntity<String> save(@RequestBody Ders ders) {
        if (repo.save(ders)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Basarı ile kaydedildi");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kayıt Başarısız");
        }
    }
}
