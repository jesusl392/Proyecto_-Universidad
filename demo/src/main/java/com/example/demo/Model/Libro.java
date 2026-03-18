package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

@Table(name = "Libros")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false, length = 150)
    private String autor;

    @Column(name = "Año publicación", nullable = false)
    private int aniopublicacion;  // ← minúscula

    //OPTIONAL - lIBROS SIEMPRE DEBEN TENER UNA CATEGORIA
    //FETCH EAFER - CUANDO SE CARGA UN LIBRO TAMBIEN SE CARGA LA CATEGORIA

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, int aniopublicacion, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.aniopublicacion = aniopublicacion;  // ← this. en lugar de Aniopublicacion =
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAniopublicacion() {
        return aniopublicacion;  // ← minúscula
    }

    public void setAniopublicacion(int aniopublicacion) {
        this.aniopublicacion = aniopublicacion;  // ← this.
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", Aniopublicacion=" + aniopublicacion +
                ", categoria=" + categoria +
                '}';
    }
}