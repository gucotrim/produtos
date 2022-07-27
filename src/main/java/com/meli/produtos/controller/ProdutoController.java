package com.meli.produtos.controller;

import com.meli.produtos.domain.Produto;
import com.meli.produtos.dto.ProdutoDto;
import com.meli.produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoDto produtoDto) {
        return new ResponseEntity<>(service.save(produtoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable String id) {
        return service.findById(id)
                .map(prod -> ResponseEntity.ok(prod))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAllAsList() {
        return ResponseEntity.ok(service.findAllAsList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable String id, @RequestBody ProdutoDto produtoDto) {
        return service.findById(id)
                .map(prod -> ResponseEntity.ok(service.update(id, prod, produtoDto)))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return service.findById(id)
                .map(prod -> {
                    service.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
