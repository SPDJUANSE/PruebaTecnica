import React, { useEffect, useState } from 'react';
import './App.css'; // Asegúrate de importar tu archivo de estilos

function App() {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const apiUrl = 'http://localhost:8080/api/consultarPasiente';
    fetch(apiUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Error en la respuesta de la red');
        }
        return response.json();
      })
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h2 className="title">🩺 Resultados del Paciente</h2>

        {error && <p className="error">⚠️ Error: {error}</p>}

        {data ? (
          <div className="card">
            <p><strong>👤 Nombre:</strong> {data.name}</p>
            <p><strong>📝 Orden:</strong> {data.order}</p>

            <h3>📋 Resultados:</h3>
            <ul className="results-list">
              {data.result.map((item, index) => (
                <li key={index}>
                  <span className="test">{item.test}</span>
                  <span className="value">{item.result}</span>
                </li>
              ))}
            </ul>
          </div>
        ) : (
          !error && <p className="loading">⏳ Cargando datos...</p>
        )}
      </header>
    </div>
  );
}

export default App;
