package com.example.demo.Controller;

import com.example.demo.Model.PerfilUsuario;
import com.example.demo.Service.PerfilUsuarioServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfilusuarios")
public class PerfilUsuarioController {

    private final PerfilUsuarioServiceImp service;

    public PerfilUsuarioController(PerfilUsuarioServiceImp service) {
        this.service = service;
    }

    @GetMapping
    public List<PerfilUsuario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PerfilUsuario> create(@RequestBody PerfilUsuario perfil) {
        return new ResponseEntity<>(service.save(perfil), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuario> update(@PathVariable Long id, @RequestBody PerfilUsuario perfil) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        perfil.setId(id);
        return ResponseEntity.ok(service.save(perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}