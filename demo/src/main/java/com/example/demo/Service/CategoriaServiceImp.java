package com.example.demo.Service;

import com.example.demo.Model.Categoria;
import com.example.demo.Repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaServiceImp {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImp(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }
    public Categoria save(Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }
    public List<Categoria> findAll()
    {
        return categoriaRepository.findAll();
    }
    public Optional<Categoria> findById(Long id)
    {
        return categoriaRepository.findById(id);
    }
    public void deleteById(Long id)
    {
        categoriaRepository.deleteById(id);
    }
    public boolean existsById(Long id)
    {
        return categoriaRepository.existsById(id);
    }
}