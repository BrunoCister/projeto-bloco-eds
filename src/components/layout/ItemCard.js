import styles from "./Card.module.css"
import { Link } from "react-router-dom"

import { BsPencil, BsFillTrashFill } from "react-icons/bs"

function Card({id, nome, valor, img_url, handleRemove}) {

    const remove = (e) => {
        e.preventDefault()
        handleRemove(id)
        window.location.reload(false);
    }

    return(
        <div className={styles.card}>
            <h4>{nome}</h4>
            <p>
                <span>Valor:</span> R${valor}
            </p>
            <p>
                <img className={styles.img} src={img_url} alt="" />
            </p>
            <div className={styles.card_actions}>
                <Link to={`/itemEdit/${id}`}>
                    <BsPencil /> Editar
                </Link>
                <button onClick={remove}>
                    <BsFillTrashFill /> Excluir
                </button>
            </div>
        </div>
    )
}

export default Card