package com.jackson.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "categoria",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = {"nome"})})
public class Categoria extends EntidadeBaseInteger {

    @Column(length = 100, nullable = false) // varchar(100) not null
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id",
            foreignKey = @ForeignKey(name = "fk_categoria_categoria_pai"))
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
