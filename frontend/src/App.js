import React from 'react';
import UploadForm from './components/SplitForm';
import SplitForm from './components/UploadForm';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Welcome to PDF Splitter</h1>
      </header>
      <main>
        <UploadForm />
        <SplitForm />
      </main>
    </div>
  );
}

export default App;
