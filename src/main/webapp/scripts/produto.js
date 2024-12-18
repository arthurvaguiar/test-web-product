document.addEventListener("DOMContentLoaded", () => {
	
    const form = document.querySelector("#form-produto");
    const codigoInput = document.getElementById("codigo");
    const descricaoInput = document.getElementById("descricao");
    const valorInput = document.getElementById("valor");
    const mensagemDiv = document.getElementById("mensagem");


    function exibirMensagem(texto, tipo) {
        mensagemDiv.textContent = texto;
        mensagemDiv.style.color = tipo === "erro" ? "red" : "green";
    }


    function validarCampos() {

        if (!codigoInput.value.trim()) {
            exibirMensagem("O campo Código é obrigatório.", "erro");
            return false;
        }

        if (!descricaoInput.value.trim()) {
            exibirMensagem("O campo Descrição é obrigatório.", "erro");
            return false;
        }

        if (!valorInput.value.trim() || parseFloat(valorInput.value) <= 0) {
            exibirMensagem("O campo Valor deve ser maior que zero.", "erro");
            return false;
        }

        return true;
    }

    function enviarDadosViaAjax() {
		const valorCorrigido = valorInput.value.replace(",", ".");

        const data = {
            codigo: parseInt(codigoInput.value,10),
            descricao: descricaoInput.value,
            valor: valorCorrigido,
        };
		
		console.log("Dados a serem enviados:", JSON.stringify(data)); 


        fetch("salvarProduto", {
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
            },
            body: JSON.stringify(data), 
        })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    return response.json().then((error) => {
                        throw new Error(error.error || "Erro desconhecido.");
                    });
                }
            })
            .then((data) => {
                exibirMensagem(data.message || "Produto salvo com sucesso!", "sucesso");
                form.reset(); 
            })
            .catch((error) => {
                exibirMensagem(error.message || "Erro ao salvar produto.", "erro");
            });
    }

    form.addEventListener("submit", (event) => {
        event.preventDefault(); 
        if (validarCampos()) {
            enviarDadosViaAjax(); 
        }
    });
});
