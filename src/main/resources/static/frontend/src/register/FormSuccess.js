import React from 'react';
import './Form.css';

const FormSuccess = () => {

  return (
    <div className='form-content-right'>
      <h1 className='form-success'>We have received your request! Login <a href='#'>here</a></h1>
      
      <img className='form-img-2' src='img/img-3.svg' alt='success-image' />
      
    </div>
  );
};

export default FormSuccess;
