function ItemForm() {
    return(
        <form>
            <div>
                <input type="text" placeholder="Insira o nome do produto..." />
            </div>
            <div>
                <input type="number" placeholder="Insira o valor do produto..."/>
            </div>
            <div>
                <input type="text" placeholder="Insira um link com a imagem do produto..."/>
            </div>
            <div>
                <input type="submit" value="Adicionar"/>
            </div>
        </form>
    )
}

export default ItemForm