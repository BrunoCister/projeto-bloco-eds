import { useState } from "react"

import Input from "./Input"
import SubmitButton from "./SubmitButton"
import styles from "./Form.module.css"

function ItemForm({ handleSubmit, itemData, btnText }) {

    const [item, setItem] = useState(itemData || {})

    const submit = (e) => {
        handleSubmit(item)
    }

    function handleChange(e) {
        setItem({ ...item, [e.target.name]: e.target.value })
    }

    return(
        <form className={styles.form} onSubmit={submit}>
            <Input type="text" text="Nome do item" name="nome" placeholder="Insira o nome do produto..." value={item.nome ? item.nome : ''} handleOnChange={handleChange}/>
            <Input type="number" text="Valor do item" name="valor" placeholder="Insira o valor do produto..." value={item.valor ? item.valor : ''} handleOnChange={handleChange}/>
            <Input type="text" text="Imagem do item" name="img_url" placeholder="Insira um link com a imagem do produto..." value={item.img_url ? item.img_url : ''} handleOnChange={handleChange}/>
            <SubmitButton text={btnText} />
        </form>
    )
}

export default ItemForm