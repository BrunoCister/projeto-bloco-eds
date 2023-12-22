import { useState, useEffect } from "react"
import VendedorForm from "../components/forms/VendedorForm"
import Container from "../components/layout/Container"
import VendedorCard from "../components/layout/VendedorCard"
import Carregando from "../components/layout/Carregando"

function Vendedor() {

    const [vendedores, setVendedores] = useState([])
    const [naoCarregando, setNaoCarregando] = useState(false)

    function createVendedor(vendedor) {

        fetch('http://localhost:8080/vendedores', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(vendedor),
        }).then(resp => resp.json()).catch(err => console.log(err))
    }

    useEffect(() => {
        setTimeout(() => {
            fetch('http://localhost:8080/vendedores', {
                method: 'GET',
                headers: {
                    'Content-type': 'application/json'
                }
            }).then(resp => resp.json()).then(data => {
                setVendedores(data)
                setNaoCarregando(true)
            }).catch((err) => console.log(err))
        }, 300) 
    }, [])

    function deleteVendedor(id) {
        fetch(`http://localhost:8080/vendedores/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json'
            }
        }).then(resp => resp.json()).then(() => {
            setVendedores(vendedores.filter(vendedor => vendedor.id !== id))
        }).catch(err => console.log(err))
    }

    return(
        <div>
            <h1>Vendedor</h1>
            <p>Adicionar um novo Vendedor</p>
            <VendedorForm btnText="Adicionar vendedor" handleSubmit={createVendedor} />
            <Container customClass="start">
                {vendedores.length > 0 && vendedores.map((vendedor) => (
                    <VendedorCard 
                        key={vendedor.id}
                        id={vendedor.id}
                        nome={vendedor.nome} 
                        email={vendedor.email}
                        handleRemove={deleteVendedor}
                    />
                ))}
                {!naoCarregando && <Carregando />}
                {naoCarregando && vendedores.length == 0 && (<p>Não há vendedores cadastrados...</p>)}
            </Container>
        </div>
    )
}

export default Vendedor