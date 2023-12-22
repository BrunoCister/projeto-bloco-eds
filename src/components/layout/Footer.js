import styles from './Footer.module.css'

function Footer() {
    return(
        <footer className={styles.footer}>
            <p className={styles.copyright}>
                <span>Projeto de bloco</span> &copy; 2023
            </p>
        </footer>
    )
}

export default Footer