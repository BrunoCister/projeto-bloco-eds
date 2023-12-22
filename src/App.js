import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Item from './pages/Item'
import Vendedor from './pages/Vendedor'
import Navbar from './components/layout/Navbar'
import Footer from './components/layout/Footer'
import Container from './components/layout/Container'
import ItemEdit from './pages/ItemEdit'
import VendedorEdit from './pages/VendedorEdit'

function App() {
  return (
    <Router>
      <Navbar />
      <Container customClass="min_height">
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/item" element={<Item />} />
            <Route path="/itemEdit/:id" element={<ItemEdit />} />
            <Route path="/vendedor" element={<Vendedor />} /> 
            <Route path="/vendedorEdit/:id" element={<VendedorEdit />} /> 
        </Routes>
      </Container>
      <Footer />
    </Router>
  )
}

export default App;