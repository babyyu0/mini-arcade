import { Routes, Route } from 'react-router-dom';
import Strengthening from './pages/Strengthening';
import NumberBaseball from './pages/NumberBaseball';

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Strengthening />} />
        <Route path="/strengthening" element={<Strengthening />} />
        <Route path="/number-baseball" element={<NumberBaseball />} />
      </Routes>
    </div>
  );
}

export default App;