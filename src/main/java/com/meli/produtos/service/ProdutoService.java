package com.meli.produtos.service;

import com.meli.produtos.domain.Produto;
import com.meli.produtos.dto.ProdutoDto;
import com.meli.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements ProdutoServiceInterface{

    private final ProdutoRepository repository;

    public ProdutoService (ProdutoRepository repository) {
        this.repository =  repository;
    }

    @Override
    public Produto save(ProdutoDto produtoDto) {
        return repository.save(Produto.builder()
                .nome(produtoDto.getNome())
                .categorias(produtoDto.getCategorias())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .armazem(produtoDto.getArmazem())
                .build());
    }

    @Override
    public Optional<Produto> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Produto> findAllAsList() {
        return repository.findAllAsList();
    }

    @Override
    public Produto update(String id, Produto produto, ProdutoDto produtoDto) {
        produto.setNome(produtoDto.getNome());
        produto.setCategorias(produtoDto.getCategorias());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());
        produto.setArmazem(produtoDto.getArmazem());
        return repository.save(produto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
