import VendedorForm from "../components/forms/VendedorForm"

function Vendedor() {

    function createVendedor(vendedor) {

        vendedor.nome = ""
        vendedor.email = ""

        fetch('http://localhost:8080/vendedores', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify(vendedor),
        }).then((resp) => resp.json()).catch(err => console.log(err))
    }

    return(
        <div>
            <h1>Vendedor</h1>
            <p>Adicionar um novo Vendedor</p>
            <VendedorForm btnText="Adicionar vendedor" handleSubmit={createVendedor} />
        </div>
    )
}

export default Vendedor