package com.example.demo.Service;

import com.example.demo.Model.PerfilUsuario;
import com.example.demo.Repository.PerfilUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PerfilUsuarioServiceImp {

    private final PerfilUsuarioRepository repository;

    public PerfilUsuarioServiceImp(PerfilUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<PerfilUsuario> findAll() {
        return repository.findAll();
    }

    public Optional<PerfilUsuario> findById(Long id) {
        return repository.findById(id);
    }

    public PerfilUsuario save(PerfilUsuario perfil) {
        return repository.save(perfil);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}