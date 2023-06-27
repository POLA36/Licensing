import { useState} from 'react'
import React from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const Home = () => {
  const navigate = useNavigate();
  const [bankUniqueCode, setBankUniqueCode] = useState("");
  const [validityDate, setValidityDate] = useState("");
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
        console.log("data saved uniquecode ", bankUniqueCode);
        console.log("data saved validity date ", validityDate);
        console.log("data saved", response);
        navigate("/license");
      } catch (error) {
        console.log(error);
      }
    } else {
      alert("The date you entered has passed")
    }
  }
  return (
    <div className='bg-black text-red-400'>
      <div>ASk for License</div>
      <form action="" id="login" method="post" onSubmit={handleSubmit}>
        <div className="item">
          <label htmlFor="bankUniqueCode"> Code unique de la banque </label>
          <input
            type="text"
            name="bankUniqueCode"
            id="bankUniqueCode"
            value={bankUniqueCode}
            onChange={e => setBankUniqueCode(e.target.value)}
          />
        </div>
        <div className="item">
          <label htmlFor="validityDate"> Date expiration </label>
          <input
            type="date"
            name="validityDate"
            id="validityDate"
            value={validityDate}
            onChange={e => setValidityDate(e.target.value)}
          />
        </div>
        <div className="item">
          <input type="submit" value="Login" />
        </div>
      </form>
    </div>
  )
}

export default Home