package com.example.demo.Controller;

import com.example.demo.Model.Categoria;
import com.example.demo.Service.CategoriaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaServiceImp categoriaService;

    public CategoriaController(CategoriaServiceImp categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria)
    {
        Categoria save = categoriaService.save(categoria);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Categoria>getAll()
    {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria>getById(@PathVariable Long id)
    {
        return categoriaService.findById(id)
                .map(ResponseEntity:: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria)
    {
        if(!categoriaService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        Categoria update = categoriaService.save(categoria);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if(!categoriaService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}