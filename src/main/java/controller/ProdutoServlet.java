package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/salvarProduto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ProdutoService produtoService;

	public ProdutoServlet() {
		super();
		this.produtoService = new ProdutoService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		try {

			Produto produto = produtoService.buildSave(request);
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
