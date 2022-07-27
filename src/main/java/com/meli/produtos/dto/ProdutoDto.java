package com.meli.produtos.dto;

import com.meli.produtos.domain.Armazem;
import com.meli.produtos.domain.Categoria;
import lombok.*;

import java.util.Set;

@Getter
@Setter
public class ProdutoDto {

    private String nome;

    private Set<Categoria> categorias;

    private double preco;

    private int quantidade;

    private Armazem armazem;
}
