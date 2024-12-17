package com.aguiar.testewebproduct.service;

import com.aguiar.testewebproduct.dao.ProdutoDAO;
import com.aguiar.testewebproduct.model.Produto;

import java.math.BigDecimal;

public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvar(Produto produto) throws IllegalArgumentException {

        if (produto.getCodigo() <= 0) {
            throw new IllegalArgumentException("Código do produto deve ser maior que zero.");
        }
        if (produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto é obrigatória.");
        }
        if (produto.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor do produto deve ser maior que zero.");
        }

        // Chamar DAO para salvar o produto
        produtoDAO.salvar(produto);
    }
}
