package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudianteServiceImp {

    private final EstudianteRepository repository;

    public EstudianteServiceImp(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    public Optional<Estudiante> findById(Long id) {
        return repository.findById(id);
    }

    public Estudiante save(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}