package com.meli.produtos.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(indexName = "produtos")
public class Produto {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nome;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Categoria> categorias;

    @Field(type = FieldType.Double)
    private double preco;

    @Field(type = FieldType.Integer)
    private int quantidade;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Armazem armazem;
}
