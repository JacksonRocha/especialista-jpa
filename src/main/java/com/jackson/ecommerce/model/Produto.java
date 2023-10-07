package com.jackson.ecommerce.model;

import com.jackson.ecommerce.listener.GenericoListener;
import com.jackson.ecommerce.listener.GerarNotaFiscalListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EntityListeners({ GenericoListener.class})
@Entity
@Table(name = "produto",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = {"nome"}) },
        indexes = { @Index(name = "idx_nome", columnList = "nome")})
public class Produto extends EntidadeBaseInteger{

    @Column(name = "data_criacao", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "nome", length = 100, nullable = false ) // nome varchar(100) not null
    private String nome;

    @Column(columnDefinition = "varchar(275) not null default 'descricao'")
    private String descricao;

    private BigDecimal preco;

    @Lob
    @Column(length = 1000)
    private byte[] foto;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
   private List<Categoria> categorias;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    @ElementCollection
    @CollectionTable(name = "produto_tag",
            joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tag", length = 50, nullable = false)
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "produto_atributo",
    joinColumns = @JoinColumn(name = "produto_id"))
    private List<Atributo> atributos;

}
