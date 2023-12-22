import { useState, useEffect } from "react"
import ItemForm from "../components/forms/ItemForm"
import Container from "../components/layout/Container"
import ItemCard from "../components/layout/ItemCard"
import Carregando from "../components/layout/Carregando"

function Item() {

    const [itens, setItens] = useState([])
    const [naoCarregando, setNaoCarregando] = useState(false)

    function createItem(item) {

        fetch('http://localhost:8080/itens', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(item)
        }).then(resp => resp.json()).catch(err => console.log(err))
    }

    useEffect(() => {
        setTimeout(
            () => {
            fetch('http://localhost:8080/itens', {
            method: 'GET',
            headers: {
                'Content-type': 'application/json'
            }
        }).then(resp => resp.json()).then(data => {
            setItens(data)
            setNaoCarregando(true)
        }).catch((err) => console.log(err))
            }, 300)
    }, [])

    function deleteItem(id) {
        fetch(`http://localhost:8080/itens/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json'
            }
        }).then(resp => resp.json()).then(() => {
            setItens(itens.filter(item => item.id !== id))
        }).catch(err => console.log(err))
    }

    return(
        <div>
            <h1>Item</h1>
            <p>Adicionar um novo item</p>
            <ItemForm btnText="Adicionar item" handleSubmit={createItem} />
            <Container customClass="start">
                {itens.length > 0 && itens.map((item) => (
                    <ItemCard 
                        key={item.id}
                        id={item.id}
                        nome={item.nome} 
                        valor={item.valor}
                        img_url={item.img_url}
                        handleRemove={deleteItem}
                    />
                ))}
                {!naoCarregando && <Carregando />}
                {naoCarregando && itens.length == 0 && (<p>Não há itens cadastrados...</p>)}
            </Container>
        </div>
    )
}

export default Item