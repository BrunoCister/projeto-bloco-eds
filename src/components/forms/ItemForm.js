import { useState } from "react"

import Input from "./Input"
import SubmitButton from "./SubmitButton"

function ItemForm({ handleSubmit, itemData, btnText }) {

    const [item, setItem] = useState(itemData || {})

    const submit = (e) => {
        e.preventDefault()
        handleSubmit(item)
    }

    function handleChange(e) {
        setItem({ ...item, [e.target.name]: e.target.value })
    }

    return(
        <form onSubmit={submit}>
            <Input type="text" text="Nome do item" name="nome" placeholder="Insira o nome do produto..." value={item.nome ? item.nome : ''} handleOnChange={handleChange}/>
            <Input type="number" text="Valor do item" name="valor" placeholder="Insira o valor do produto..." value={item.valor ? item.valor : ''} handleOnChange={handleChange}/>
            <Input type="text" text="Imagem do item" name="imgUrl" placeholder="Insira um link com a imagem do produto..." value={item.imgUrl ? item.imgUrl : ''} handleOnChange={handleChange}/>
            <SubmitButton text={btnText} />
        </form>
    )
}

export default ItemForm