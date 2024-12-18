<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de Produtos</title>
<link rel="stylesheet" href="/TesteProduto/style.css">
</head>
<body>
	<h1>Cadastro de Produtos</h1>

	<form id="form-produto">
		<table>
			<tr>
				<td><input class="input" id="codigo" name="codigo" type="number"
					placeholder="Código" required /></td>
			</tr>
			<tr>
				<td><input class="input" id="descricao" name="descricao" type="text"
					placeholder="Descrição" required /></td>
			</tr>
			<tr>
				<td><input class="input" id="valor" name="valor" type="text"
					placeholder="Valor" step="0.01" required /></td>
			</tr>
		</table>
		<input class="botao"  type="submit" value="Salvar" />
		<div id="mensagem"></div>
	</form>

	<script src="scripts/produto.js"></script>

</body>
</html>
