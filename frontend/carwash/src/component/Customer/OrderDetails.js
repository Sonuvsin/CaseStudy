import axios from 'axios';
import { useState } from 'react';
import {TextField,FormControl,InputLabel,Select,MenuItem} from "@material-ui/core";
import Button from "react-bootstrap/Button";
import Grid from "@material-ui/core/Grid";
import Container from "@material-ui/core/Container";
import { Link } from "react-router-dom";
import Avatar from "@material-ui/core/Avatar";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import "./Order.css";
import Washpack from '../../services/Washpack';
import { useHistory } from "react-router-dom";

 function OrderDetails(props) {

    const [Name, setName] = useState('');
    const [carName, setcarName] = useState('');
    const [carModel, setcarModel] = useState('');
    const [phoneNo, setphoneNo] = useState('');
    const [address, setaddress] = useState('');
    const [date, setdate] = useState('');
    const [washpackName, setwashpackName] = useState('');
    let history = useHistory();
    

    function onCreatePost(e) {
        e.preventDefault();
        const postData = {
         Name,   
         carName,
         carModel,
         phoneNo,
         address,
         date,
         washpackName
           
        };

       
     

        axios
            .post(
                `http://localhost:8080/user/addorder`,
                postData,
            )
            .then(() => {
              props.onClick( history.push("/cust_home/payment")) 
    
            });
    }
    return (
      <Container maxWidth="xs">
      <div className="login__form">
        <Typography component="h1" variant="h5">
          OrderDetails
        </Typography>
        <form onSubmit={onCreatePost}>
        <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Name"
            type="text"
            value={Name}
            onChange={(e) => setName(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="carName"
            type="text"
            value={carName}
            onChange={(e) => setcarName(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="carModel"
            type="text"
            value={carModel}
            onChange={(e) => setcarModel(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Phone No"
            type="text"
            pattern="[0-9]*"
            maxLength="10"
           value={phoneNo}
            onChange={(e) => setphoneNo(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="address"
            type="text"
            value={address}
            onChange={(e) => setaddress(e.target.value)}
            
          />
          <FormControl fullWidth>
 <InputLabel id="demo-simple-select-label"> ..washpack</InputLabel>
  <Select
   
            fullWidth
    value={washpackName}
    label="Age"
    onChange={(e) => setwashpackName(e.target.value)}
  >
    
    <MenuItem value={11}>Silver A1A </MenuItem>
    <MenuItem value={12}>Gold A1A</MenuItem>
    <MenuItem value={13}>platinum A1A</MenuItem>
    <MenuItem value={14}>Diamond A1A</MenuItem>
    <MenuItem value={15}>Premimum A1A</MenuItem>
  </Select>
</FormControl>
          
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            type="date"
            value={date}
            onChange={(e) => setdate(e.target.value)}
            
          />
           
           <Button className="login__button" type="submit" block color="primary" >
            Book and Pay
          </Button>
         
        </form>
      </div>
    </Container>
  );
} 
export default OrderDetails;