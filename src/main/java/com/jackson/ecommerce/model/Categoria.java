package com.jackson.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//    @SequenceGenerator(name = "seq", sequenceName = "sequencia_chave_primaria")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
    @TableGenerator(name = "tabela", table = "hibernate_sequences", pkColumnName = "sequence_name",
            pkColumnValue = "categoria", valueColumnName = "next_val", initialValue = 0, allocationSize = 50)
    private Integer id;

    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
