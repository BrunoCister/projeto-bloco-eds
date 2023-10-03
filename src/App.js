import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Compra from './pages/Compra'
import Item from './pages/Item'
import Vendedor from './pages/Vendedor'
import Navbar from './components/layout/Navbar'
import Footer from './components/layout/Footer'

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/compra" element={<Compra />} />
        <Route path="/item" element={<Item />} />
        <Route path="/vendedor" element={<Vendedor />} />
      </Routes>
      <Footer />
    </Router>
  )
}

export default App;
