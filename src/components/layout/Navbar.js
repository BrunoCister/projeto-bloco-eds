import { Link } from "react-router-dom"
import styles from './Navbar.module.css'

function Navbar() {
    return(
        <ul className={styles.list}>
            <li className={styles.item}>
            <Link to="/">Home</Link>
            </li>
            <li className={styles.item}>
            <Link to="/vendedor">Vendedor</Link>
            </li>
            <li className={styles.item}>
            <Link to="/compra">Compra</Link>
            </li>
            <li className={styles.item}>
            <Link to="/item">Item</Link>
            </li>
        </ul>
    )
}

export default Navbar