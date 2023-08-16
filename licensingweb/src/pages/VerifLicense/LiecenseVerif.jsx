import React, { useRef} from 'react'

const LiecenseVerif = () => {
  const inputRef = useRef(null);
  const handleCopy = () => {
    
  };
  return (
    <>
      <div className='container'>
        <div className="row row-form">
          <div className="header">
            <p className='heade-title'>Enter your license</p>
          </div>
          <div className="form-wrapper content-center">
            <div className="form-input-wrapper">
              <input
                placeholder='Your license'
                type="text"
                name="license"
                id="license"
                readOnly
                className='input'
                ref={inputRef}
              />
              <button onClick={handleCopy}>Submit my License</button>
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

export default LiecenseVerif