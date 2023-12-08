import ItemForm from "../components/forms/ItemForm"

function Item() {

    function createItem(item) {

        item.nome = ""
        item.valor = 0
        item.imgUrl = ""

        fetch('http://localhost:8080/itens', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify(item),
        }).then((resp) => resp.json()).catch(err => console.log(err))
    }

    return(
        <div>
            <h1>Item</h1>
            <p>Adicionar um novo item</p>
            <ItemForm btnText="Adicionar item" handleSubmit={createItem} />
        </div>
    )
}

export default Item