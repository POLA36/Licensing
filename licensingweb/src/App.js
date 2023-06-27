import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Home from './pages/Home/Home';
import License from './pages/License/License';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Home />}/>
        <Route path='license' element={<License/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
