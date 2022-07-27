package com.meli.produtos.repository;

import com.meli.produtos.domain.Produto;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends ElasticsearchRepository<Produto, String> {
    @Query("{\"match_all\": {} }")
    List<Produto> findAllAsList();
}
