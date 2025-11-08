import { Routes, Route } from 'react-router-dom';
import Strengthening from './pages/Strengthening';
import Category from './components/Category';

function App() {
  return (
    <div>
      <Routes>
        <Route path="/strengthening" element={<Strengthening />} />
        {/* <Route path="/number-baseball" element={<NumberBaseball />} /> */}
      </Routes>
    </div>
  );
}

export default App;