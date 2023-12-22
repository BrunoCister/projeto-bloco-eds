import styles from './Edit.module.css'
import { useParams } from 'react-router-dom'
import { useState, useEffect } from 'react'
import Carregando from '../components/layout/Carregando'
import Container from '../components/layout/Container'
import ItemForm from '../components/forms/ItemForm'

function ItemEdit() {
    const { id } = useParams()
    
    const [item, setItem] = useState([])
    const [mostrarItemForm, setMostrarItemForm] = useState(false)

    useEffect(() => {
        setTimeout(() => {
            fetch(`http://localhost:8080/itens/${id}`, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json'
            }
        }).then(resp => resp.json()).then(data => {
            setItem(data)
        }).catch(err => console.log(err))
        }, 300)
    }, [id])

    function editItem(item) {
        fetch(`http://localhost:8080/itens/${item.id}`, {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(item)
        }).then(resp => resp.json()).then(data => {
            setItem(data)
            setMostrarItemForm(false)
        }).catch(err => console.log(err))
    }

    function ativarItemForm() {
        setMostrarItemForm(!mostrarItemForm)
    }

    return(
        <>
        {item.nome ? (
            <div className={styles.edit_details}>
                <Container customClass="column">
                    <div className={styles.container_details}>
                        <h1>Item: {item.nome}</h1>
                        <button className={styles.btn} onClick={ativarItemForm}>
                            {!mostrarItemForm ? 'Editar' : 'Fechar'}
                        </button>
                        {!mostrarItemForm ? (
                            <div className={styles.info}>
                                <p>
                                    <span>Nome:</span> {item.nome}
                                </p>
                                <p>
                                    <span>Valor:</span> R${item.valor}
                                </p>
                                <p>
                                    <span>Url da imagem:</span> {item.img_url}
                                </p>
                            </div>
                        ) : (
                            <div className={styles.info}>
                                <ItemForm handleSubmit={editItem} 
                                btnText="Concluir edição" 
                                itemData={item}/>
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

export default ItemEdit