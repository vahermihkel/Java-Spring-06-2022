import './App.css';
import { Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import AddProduct from './pages/AddProduct';
import NavigationBar from './components/NavigationBar';

function App() {

  return (
    <div className="App">
      
        <NavigationBar />
        
        <Routes>
          <Route path="/" element={ <HomePage /> } />
          <Route path="/ostukorv" element={ <div>SEE ON OSTUKORV</div> } />
          <Route path="/lisa-toode" element={ <AddProduct /> } />
        </Routes>
    </div>
  );
}

export default App;
