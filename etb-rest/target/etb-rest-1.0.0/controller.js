
console.log('******');
function runProducto (event, form) {
    let method = event.submitter.value;
    let url = form.action;
    form.response.value = '----start----';
    let data = {
        id: form.id.value || null,
        codigo: form.codigo.value || null,
        nombre: form.nombre.value || null,
        costo: form.nombre.costo || 0,
    }
    if (method === 'X-UPDATE' || method === 'X-REMOVE') {
        url = form.action + '/' + data.id;
    }

    let config = {
        method: method,
        body: JSON.stringify(data),
        headers: {"Content-Type": "application/json"},
    };

    fetch(url, config)
            .then(r => r.json())
            .then(json => {
                form.response.value = JSON.stringify(json, null, 2);
            }).catch(e => {
        form.response.value = JSON.stringify({message: 'Error', cause: e.message}, null, 2);
    });
    return false;
};
function runPedido (event, form) {
    let method = event.submitter.value;
    let url = form.action;
    form.response.value = '----start----';
    let data = {
        id: form.id.value || null,
        cliente: form.cliente.value || null,
        fecha: form.fecha.value || null,
        descripcion: form.descripcion.value || null,
    }
    if (method === 'X-UPDATE' || method === 'X-REMOVE') {
        url = form.action + '/' + data.id;
    }

    let config = {
        method: method,
        body: JSON.stringify(data),
        headers: {"Content-Type": "application/json"},
    };

    fetch(url, config)
            .then(r => r.json())
            .then(json => {
                form.response.value = JSON.stringify(json, null, 2);
            }).catch(e => {
        form.response.value = JSON.stringify({message: 'Error', cause: e.message}, null, 2);
    });
    return false;
};
function runPedidoDetalle (event, form) {
    let method = event.submitter.value;
    let url = form.action+'/detalle';
    form.response.value = '----start----';
    let data = {
        id: form.id.value || null,
        idPedido: form.idPedido.value || null,
        idProducto: form.idProducto.value || null,
        cantidad: form.cantidad.value || null,
    }
    if (method === 'X-UPDATE' || method === 'X-REMOVE') {
        url = form.action + '/detalle/' + data.id;
    } 

    let config = {
        method: method,
        body: JSON.stringify(data),
        headers: {"Content-Type": "application/json"},
    };

    fetch(url, config)
            .then(r => r.json())
            .then(json => {
                form.response.value = JSON.stringify(json, null, 2);
            }).catch(e => {
        form.response.value = JSON.stringify({message: 'Error', cause: e.message}, null, 2);
    });
    return false;
};
