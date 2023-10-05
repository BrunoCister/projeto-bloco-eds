function VendedorForm() {
    return(
        <form>
            <div>
                <input type="text" placeholder="Insira o nome do vendedor..." />
            </div>
            <div>
                <input type="email" placeholder="Insira o email do vendedor..."/>
            </div>
            <div>
                <input type="submit" value="Adicionar"/>
            </div>
        </form>
    )
}

export default VendedorForm