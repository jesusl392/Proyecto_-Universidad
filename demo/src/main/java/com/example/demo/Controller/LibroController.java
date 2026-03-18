package com.example.demo.Controller;

import com.example.demo.Model.Libro;
import com.example.demo.Service.LibroServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroServiceImp libroService;

    public LibroController(LibroServiceImp libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<Libro> create(@RequestBody Libro libro)
    {
        Libro saved =  libroService.save(libro);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Libro> getAll()
    {
        return libroService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Libro> getById(@PathVariable Long id)
    {
        return libroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Long id, @RequestBody Libro libro)
    {
        if(!libroService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        libro.setId(id);
        Libro updated = libroService.save(libro);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if(!libroService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        libroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}