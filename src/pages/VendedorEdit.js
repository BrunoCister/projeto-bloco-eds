import styles from './Edit.module.css'
import { useParams } from 'react-router-dom'
import { useState, useEffect } from 'react'
import Carregando from '../components/layout/Carregando'
import Container from '../components/layout/Container'
import VendedorForm from '../components/forms/VendedorForm'

function VendedorEdit() {
    const { id } = useParams()
    
    const [vendedor, setVendedor] = useState([])
    const [mostrarVendedorForm, setMostrarVendedorForm] = useState(false)

    useEffect(() => {
        setTimeout(() => {
            fetch(`http://localhost:8080/vendedores/${id}`, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json'
            }
        }).then(resp => resp.json()).then(data => {
            setVendedor(data)
        }).catch(err => console.log(err))
        }, 300)
    }, [id])

    function editVendedor(vendedor) {
        fetch(`http://localhost:8080/vendedores/${vendedor.id}`, {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(vendedor)
        }).then(resp => resp.json()).then(data => {
            setVendedor(data)
            setMostrarVendedorForm(false)
        }).catch(err => console.log(err))
    }

    function ativarVendedorForm() {
        setMostrarVendedorForm(!mostrarVendedorForm)
    }

    return(
        <>
        {vendedor.nome ? (
            <div className={styles.edit_details}>
                <Container customClass="column">
                    <div className={styles.container_details}>
                        <h1>Vendedor: {vendedor.nome}</h1>
                        <button className={styles.btn} onClick={ativarVendedorForm}>
                            {!mostrarVendedorForm ? 'Editar' : 'Fechar'}
                        </button>
                        {!mostrarVendedorForm ? (
                            <div className={styles.info}>
                                <p>
                                    <span>Nome:</span> {vendedor.nome}
                                </p>
                                <p>
                                    <span>Email:</span> {vendedor.email}
                                </p>
                            </div>
                        ) : (
                            <div className={styles.info}>
                                <VendedorForm handleSubmit={editVendedor} 
                                btnText="Concluir edição" 
                                vendedorData={vendedor}/>
                            </div>
                        )}
                    </div>
                </Container>
            </div>
        ) : (<Carregando />

        )}
        </>
    )
}

export default VendedorEdit