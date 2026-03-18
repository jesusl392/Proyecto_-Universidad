package com.example.demo.Service;

import com.example.demo.Model.Libro;
import com.example.demo.Repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroServiceImp {

    private final LibroRepository repository;

    public LibroServiceImp(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return repository.findById(id);
    }

    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}