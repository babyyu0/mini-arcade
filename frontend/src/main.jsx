import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom'; // 1. import 하기
import App from './App';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter> {/* 2. <App /> 컴포넌트를 통째로 감싸주세요 */}
      <App />
    </BrowserRouter>
  </React.StrictMode>
);