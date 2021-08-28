$('#form-cadastro').submit(function() {
    saveSalgado();
    return false; // return false to cancel form action
});

function deleteSalgado(id){
    if (confirm("Remover esse salgado?")) {
        $.ajax({
            async: false,
            url: "/deletar",
            type: "DELETE",
            data: JSON.stringify(id),
            contentType: "application/json; charset=utf-8",
        }).done(function (){
            alert("Salgado removido com sucesso!");
        }).fail(function (){alert("O salgado não existe ou não foi removido corretamente.")});

        document.location.reload(true);
    }
}

function saveSalgado(){
    let tipo = $('#SelectTipo').val();
    let sabor = $('#SelectSabor').val();

    const rbs = document.querySelectorAll('input[name="fritoOuAssado"]');
    let fritoOuAssado;
    for (const rb of rbs) {
        if (rb.checked) {
            fritoOuAssado = rb.value;
            break;
        }
    }

    let preco = $('#InputPreco').val();
    let quantidade = $('#InputQuant').val();

    $.ajax({
        async: false,
        url: "/cadastro",
        type: "POST",
        data: JSON.stringify({
            id : "",
            tipo : tipo,
            sabor : sabor,
            fritoOuAssado : fritoOuAssado,
            preco : preco,
            quantidade : quantidade}),
        contentType: "application/json; charset=utf-8",
    }).done(function (){
        alert("Salgado salvo com sucesso!");
    }).fail(function (){alert("O salgado não existe ou não foi removido corretamente.")});

    document.location.reload(true);
}