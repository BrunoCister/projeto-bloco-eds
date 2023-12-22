import { Link } from "react-router-dom"
import styles from './Navbar.module.css'
import Container from "./Container"

function Navbar() {
    return(
        <nav className={styles.navbar}>
            <Container>
                <ul className={styles.list}>
                    <li className={styles.item}>
                        <Link to="/">Home</Link>
                    </li>
                    <li className={styles.item}>
                        <Link to="/vendedor">Vendedor</Link>
                    </li>
                    <li className={styles.item}>
                        <Link to="/item">Item</Link>
                    </li>
                </ul>
            </Container>
        </nav>
    )
}

export default Navbar