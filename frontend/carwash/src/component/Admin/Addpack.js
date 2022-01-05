import axios from 'axios';
import { useState } from 'react';
import TextField from "@material-ui/core/TextField";
import Button from "react-bootstrap/Button";
import Grid from "@material-ui/core/Grid";
import Container from "@material-ui/core/Container";
import { Link } from "react-router-dom";

import Typography from "@material-ui/core/Typography";
import "./Order.css";

 function OrderDetails(props) {
 
    const [name, setname] = useState('');
    const [description, setdescription] = useState('');
    const [cost, setcost] = useState('');
   
    
    

    function onCreatePost(e) {
        e.preventDefault();
        const postData = {
        name,
        description,
        cost
           
        };
     

        axios
            .post(
                `http://localhost:8081/admin/washpack`,
                postData,
            )
            .then((response) => {
                props.onClick();
                console.log(response);
                props.history.push("/payment");
    
            });
    }
    return (
      <Container maxWidth="xs">
      <div className="login__form">
        <Typography component="h1" variant="h5">
          ADD WASH PACK
        </Typography>
        <form onSubmit={onCreatePost}>
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="WashPackName"
            type="text"
            value={name}
            onChange={(e) => setname(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Description"
            type="text"
            value={description}
            onChange={(e) => setdescription(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="COST"
            type="text"
            pattern="[0-9]*"
            maxLength="10"
           value={cost}
            onChange={(e) => setcost(e.target.value)}
            
          />
         
           
           <Button className="login__button" type="submit" block color="primary" >
            ADD NEW PACK
          </Button>
    
        </form>
      </div>
    </Container>
  );
} 
export default OrderDetails;