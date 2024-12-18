package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import dao.ProdutoDAO;
import model.Produto;

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

		produtoDAO.salvar(produto);
	}

	public Produto buildSave(HttpServletRequest request) throws IOException {
		try {
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			try (BufferedReader reader = request.getReader()) {
				while ((line = reader.readLine()) != null) {
					jsonBuilder.append(line);
				}
			}
			String json = jsonBuilder.toString();
			Gson gson = new Gson();

			Produto produto = gson.fromJson(json, Produto.class);
			return produto;

		} catch (IOException e) {
			throw new IllegalArgumentException("Erro ao processar o JSON: " + e.getMessage());
		} catch (JsonSyntaxException e) {
			throw new IllegalArgumentException("Formato de JSON inválido: " + e.getMessage());
		}
	}

}
