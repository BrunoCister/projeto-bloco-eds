import { useState } from "react"

import Input from "./Input"
import SubmitButton from "./SubmitButton"

function VendedorForm({ handleSubmit, vendedorData, btnText }) {

    const [vendedor, setVendedor] = useState(vendedorData || {})

    const submit = (e) => {
        e.preventDefault()
        handleSubmit(vendedor)
    }

    function handleChange(e) {
        setVendedor({ ...vendedor, [e.target.name]: e.target.value })
    }

    return(
        <form onSubmit={submit}>
        <Input type="text" text="Nome do vendedor" name="nome" placeholder="Insira o nome do vendedor..." value={vendedor.nome ? vendedor.nome : ''} handleOnChange={handleChange}/>
        <Input type="email" text="Email do vendedor" name="email" placeholder="Insira o email do vendedor..." value={vendedor.email ? vendedor.email : ''} handleOnChange={handleChange}/>
        <SubmitButton text={btnText} />
    </form>
    )
}

export default VendedorForm