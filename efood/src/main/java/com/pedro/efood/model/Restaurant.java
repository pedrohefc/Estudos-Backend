package com.pedro.efood.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String tipo;
    private String descricao;
    private Double avaliacao;
    private String capa;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;
}
