import React, { useState } from 'react';
import axios from 'axios';
import './upload-form.css';

const UploadForm = () => {
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState('');

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();

    if (file) {
      const formData = new FormData();
      formData.append('file', file);

      try {
        const response = await axios.post('http://localhost:9090/api/pdf/upload', formData);

        if (response.status === 200) {
          setMessage('PDF file uploaded successfully');
        } else {
          setMessage('Failed to upload PDF file');
        }
      } catch (error) {
        setMessage('Failed to upload PDF file');
      }
    }
  };

  return (
    <div className="upload-form">
      <h2 className="upload-form__title">Upload PDF</h2>
      <form className="upload-form__form" onSubmit={handleFormSubmit}>
        <input className="upload-form__input" type="file" onChange={handleFileChange} />
        <button className="upload-form__button" type="submit">Upload</button>
      </form>
      {message && <p className="upload-form__message">{message}</p>}
    </div>
  );
};

export default UploadForm;
