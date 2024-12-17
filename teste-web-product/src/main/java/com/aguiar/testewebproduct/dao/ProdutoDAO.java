package com.aguiar.testewebproduct.dao;

import com.aguiar.testewebproduct.model.Produto;

public class ProdutoDAO {

    public void salvar(Produto produto) {

        String sqlCommand = String.format(
                "INSERT INTO PRODUTOS (COD, DESCRICAO, VALOR) VALUES (%d, '%s', %.2f);",
                produto.getCodigo(), produto.getDescricao(), produto.getValor()
        );
        System.out.println(sqlCommand);
    }
}
