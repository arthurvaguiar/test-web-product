package com.aguiar.testewebproduct.controllers;


import com.aguiar.testewebproduct.model.Produto;
import com.aguiar.testewebproduct.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {

    private final ProdutoService produtoService;

    public ProdutoServlet() {
        this.produtoService = new ProdutoService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Produto produto = mapper.readValue(request.getInputStream(), Produto.class);
            produtoService.salvar(produto);

            response.setStatus(HttpServletResponse.SC_OK);
            out.print("{\"message\": \"Produto salvo com sucesso!\"}");
            out.flush();
        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"" + e.getMessage() + "\"}");
            out.flush();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\": \"Erro interno no servidor.\"}");
            out.flush();
        }
    }
}