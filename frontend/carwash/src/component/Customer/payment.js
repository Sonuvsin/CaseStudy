import axios from 'axios';
import { useState } from 'react';
import {TextField} from "@material-ui/core";
import Button from "react-bootstrap/Button";
import Container from "@material-ui/core/Container";

import Typography from "@material-ui/core/Typography";
import "./payment.css";
import { useHistory } from "react-router-dom";

 function Payment(props) {

    const [FullName, setFullName] = useState('');
    const [bankName, setbankName] = useState('');
    const [cardNo,setcardNo] = useState('');
    const [cvv, setcvv] = useState('');
    const [validdate, setavaliddate] = useState('');
    const [amount, setamount] = useState('');
    let history = useHistory();
    

    function onCreatePost(e) {
        e.preventDefault();
        const postData = {
        FullName,
        cardNo,
        bankName,
        cvv,
        validdate,
        amount
           
        };

        axios
            .post(
                `http://localhost:8086/payment/addpayment
                `,
                postData,
            )
            .then(() => {
              props.onClick( history.push("/cust_home/success")) 
    
            });
    }
     


    return (
      <Container maxWidth="xs">
      <div className="login__form">
        <Typography component="h1" variant="h5">
          PaymentDetails
        </Typography>
        <form onSubmit={onCreatePost}>
        <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="FULL NAME"
            type="text"
            value={FullName}
            onChange={(e) => setFullName(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="CARD NO"
            type="text"
            value={cardNo}
            onChange={(e) => setcardNo(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="BANK NAME"
            type="text"
            value={bankName}
            onChange={(e) => setbankName(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="CVV"
            type="password"
            pattern="[0-9]*"
            maxLength="3"
           value={cvv}
            onChange={(e) => setcvv(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="validdate"
            type="text"
            value={validdate}
            onChange={(e) => setavaliddate(e.target.value)}
            
          />
           <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="AMOUNT TO BE PAID"
            type="text"
            value={amount}
            onChange={(e) => setamount(e.target.value)}
           />

           <Button className="login__button" type="submit" block color="primary" >
        PAY
          </Button>
         
        </form>
      </div>
    </Container>
  );
} 
export default Payment;