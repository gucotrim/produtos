package com.meli.produtos.service;

import com.meli.produtos.domain.Produto;
import com.meli.produtos.dto.ProdutoDto;

import java.util.List;
import java.util.Optional;

public interface ProdutoServiceInterface {
    Produto save(ProdutoDto produtoDto);
    Optional<Produto> findById(String id);
    List<Produto> findAllAsList();
    Produto update(String id, Produto produto, ProdutoDto produtoDto);
    void delete(String id);
}
