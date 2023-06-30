import React, { useState } from 'react';
import axios from 'axios';
import './split-form.css';

const SplitForm = () => {
  const [startPage, setStartPage] = useState('');
  const [endPage, setEndPage] = useState('');
  const [message, setMessage] = useState('');

  const handleStartPageChange = (event) => {
    setStartPage(event.target.value);
  };

  const handleEndPageChange = (event) => {
    setEndPage(event.target.value);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();

    if (startPage && endPage) {
      const splitRequest = {
        fileName: '', // Provide the filename if required by the API
        pdfFileId: null, // Provide the ID of the uploaded PDF file
        pageRanges: [
          {
            startPage: parseInt(startPage),
            endPage: parseInt(endPage),
          },
        ],
      };

      try {
        const response = await axios.post('http://localhost:9090/api/pdf/split', splitRequest);

        if (response.status === 200) {
          const splitResult = response.data;
          // Handle the split result as needed
          setMessage('PDF split successfully');
        } else {
          setMessage('Failed to split PDF');
        }
      } catch (error) {
        setMessage('Failed to split PDF');
      }
    }
  };

  return (
    <div className="split-form">
      <h2 className="split-form__title">Split PDF</h2>
      <form className="split-form__form" onSubmit={handleFormSubmit}>
        <label htmlFor="startPage" className="split-form__label">Start Page:</label>
        <input className="split-form__input" type="number" id="startPage" value={startPage} onChange={handleStartPageChange} />

        <label htmlFor="endPage" className="split-form__label">End Page:</label>
        <input className="split-form__input" type="number" id="endPage" value={endPage} onChange={handleEndPageChange} />

        <button className="split-form__button" type="submit">Split</button>
      </form>
      {message && <p className="split-form__message">{message}</p>}
    </div>
  );
};

export default SplitForm;
