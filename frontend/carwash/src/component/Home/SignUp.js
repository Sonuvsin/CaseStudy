import axios from 'axios';
import { useState } from 'react';
import "./Login.css";
import TextField from "@material-ui/core/TextField";
import Button from "react-bootstrap/Button";
import Grid from "@material-ui/core/Grid";
import Container from "@material-ui/core/Container";

import { Link } from "react-router-dom";
import { useHistory } from "react-router-dom";
import Avatar from "@material-ui/core/Avatar";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import "./Login.css";

 function SignUp(props) {
 
    const [name, setName] = useState('');
    const [username, setusername] = useState('');
    const [contact, setContact] = useState('');
    const [emailId, setEmailId] = useState('');
    const [password, setPassword] = useState('');
    let history = useHistory();
    
 
    

    function onCreatePost(e) {
        e.preventDefault();
        const postData = {
          name,
          username,
          contact,
          emailId,
          password
           
        };
     

        axios
            .post(
                `http://localhost:8080/user/adduser`,
                postData,
            )
            .then(() => {
               props.onClick( history.push("/cust_home")) 
               
               
    
            });
    }
    return (
      <Container maxWidth="xs">
      <div className="login__form">
        <Avatar>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Register
        </Typography>
        <form onSubmit={onCreatePost}>
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Name"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
           
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="username"
            type="text"
            value={username}
            onChange={(e) => setusername(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Contact"
            type="text"
           value={contact}
            onChange={(e) => setContact(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="EmailId"
            type="text"
            value={emailId}
            onChange={(e) => setEmailId(e.target.value)}
            
          />
          <TextField
            variant="outlined"
            margin="normal"
            fullWidth
            label="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            
          />

           <Button className="login__button" type="submit" block color="primary"  >
            Sign Up
          </Button> 
          <Grid className="login__grid" container>
            <Grid item>
              <Link className="link" to="/login">
                {"Already have an account? Sign In"}
              </Link>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );
} 
export default SignUp;