document.getElementById('saveButton').addEventListener('click', () => {
    const cod = document.getElementById('cod').value;
    const descricao = document.getElementById('descricao').value;
    const valor = document.getElementById('valor').value;

    fetch('/product', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ cod, descricao, valor })
    }).then(response => response.json())
        .then(data => alert(data.message))
        .catch(err => console.error(err));
});
