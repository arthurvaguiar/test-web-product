# test-web-product
Teste programador WEB, descrição do problema:

A ideia é simular um cadastro (apenas inserção) de produtos.
A tabela destino:
TB_PRODUTOS (
COD number,
DESCRICAO varchar2(50),
VALOR number(12,2))

Desenvolver:
1) Frontend: Criar pagina usando HTML e CSS conforme exemplo abaixo:
Cadastro de Produtos
Cod: _______
Descrição: _________________________
Valor: _______________
[ Salvar ]

2) Frontend: Implementar o botão SALVAR (com Javascript ou Jquery)
- chamada ajax (http) para o servidor Java (passando os 3 campos)

3) Backend: Criar um servlet (java) para receber a requisição
- Organize a estrutura do backend como julgue o correto para uma aplicação
transacional.
- Simular a gravação no banco com os dados recebidos
- Fazer o print dos comandos do banco

Exemplo: System.out.println("insert into PRODUTOS
(COD,DESCRICAO,VALOR) ")

4) Observações:
Não será aceito uso do frameworks que gerem códigos para o
desenvolvedor. (ex spring).



![image](https://github.com/user-attachments/assets/75344c1d-4901-41e1-b820-322610c735b8)
