import { useState} from 'react'
import React from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'
import './style.css'

const Home = () => {
  const navigate = useNavigate();
  const [bankUniqueCode, setBankUniqueCode] = useState("");
  const [validityDate, setValidityDate] = useState("");
  const [generatedLicense, setGeneratedLicense] = useState("");
  const currentDate = new Date();
  const handleSubmit = async(e) => {
    e.preventDefault()
    
    if (new Date(validityDate) >= currentDate) {
      try {
        const server = {
          bankUniqueCode: bankUniqueCode,
          validityDate: validityDate
        };
        
        const response = await axios.post("http://localhost:8081/server/saveServerInfos",server);
        setBankUniqueCode(" ");
        setValidityDate(" ")
        setGeneratedLicense(response.data);
        navigate("/license", { state: response.data}
    );

      //navigate("/license");
      } catch (error) {
        console.log(error);
      }
    } else {
      alert("The date you entered has passed")
    }
  }
  return (
    <div className='container'>
      <div className="row row-form">
        <div className="header">
          <p className='heade-title'>Get the licence</p>
        </div>
        <div className="form-wrapper content-center">
          <form action="" className="form-wrapper-form-group" id="serer-log" method="post" onSubmit={handleSubmit}>
            <div className="form-input-wrapper">
              <input
                placeholder='Bank Unique Number'
                type="text"
                name="bankUniqueCode"
                id="bankUniqueCode"
                value={bankUniqueCode}
                onChange={e => setBankUniqueCode(e.target.value)}
                className='bankUniqueCode input'
              />
            </div>
            <div className="form-input-wrapper">
              <input
                placeholder='Date expiration'
                type="date"
                name="validityDate"
                id="validityDate"
                value={validityDate}
                className='expiration-date input'
                onChange={e => setValidityDate(e.target.value)}
              />
            </div>
            <div className="button-wrapper">
              <input type="submit" className='button-wrapper-item' value="get the licence" />
            </div>
            <Link to="/license-verification" className="LicenceVerificationLink"> <p>I have a liecence</p></Link>
          </form>
        </div>
      </div>
      <div className="row row-picture">
        <div className="image-side">
          <img src="./undraw_certification_re_ifll.svg" alt="" />
        </div>
      </div>
    </div>
  )
}

export default Home