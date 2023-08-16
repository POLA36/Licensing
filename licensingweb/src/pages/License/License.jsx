import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react'
import './style.css'
import { useLocation } from 'react-router-dom';

const License = () => {
  const location = useLocation();
  const license = location.state  ;
  const inputRef = useRef(null);
  const [copied, setCopied] = useState(false);
  const handleCopy = () => {
    if (inputRef.current) {
      inputRef.current.select();
      document.execCommand('copy');
      setCopied(true);

      // Reset the "Copied" text and background after a certain duration
      setTimeout(() => {
        setCopied(false);
      }, 2000);
    }
  };

  return (
    <>
      <div className='container'>
        <div className="row row-form">
          <div className="header">
            <p className='heade-title'>Your license has been generated</p>
          </div>
          <div className="form-wrapper content-center">
            <div className="form-input-wrapper">
              <input
                placeholder='Your license'
                type="text"
                name="license"
                id="license"
                value={license}
                onChange={license}
                readOnly
                className='input'
                ref={inputRef}
              />
              <button onClick={handleCopy}>{copied ? 'Copied' : 'Copy'}</button>
            </div>
          </div>
        </div>
        <div className="row row-picture">
          <img src="./undraw_authentication_re_svpt.svg" alt="" />
        </div>
      </div>
    </>
  )
}

export default License