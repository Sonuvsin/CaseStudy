
import React, { Component, useContext, useState, Fragment } from "react";
import { Formik, Form, Field } from "formik";
import { useHistory, useLocation,Link } from "react-router-dom";
import * as Yup from "yup";
import _get from "lodash.get";
import "./Login.css";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Grid from "@material-ui/core/Grid";



toast.configure()

const LoginSchema = Yup.object().shape({
  password: Yup.string().required("Password is required!"),
  username: Yup.string().required("username is required!"),
  
});

const Login = () => {

   /**To Show Add Toastify Text */
   const notify = () => {
    toast("USER LoggedIn Successfully!!!", {
      position: "top-center",
      autoClose: 2000,
    });
  };

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const history = useHistory();
  const location = useLocation();
  const fromUrl = _get(location, "state.from.pathname");
  const signInSuccess = (userData) => {
    if (fromUrl) {
      history.push(fromUrl);
    } else {
      history.push("/cust_home");
    }
  };

  const login = (userData) => {
    fetch("http://localhost:8682/auth", {
      method: "POST",
      headers: {
        "content-type": "application/json",
        accept: "application/json",
        "Access-Control-Allow-Origin": "*",
      },
      body: JSON.stringify({
        username: userData.username,
        password: userData.password,
      }),
    })
      .then((response) => response.json())
      .then((response) => {
        if (response.error) {
          alert("your userId and password is not correct");
        } else {
          const userData = {
            token: response,
            name: username,
          };
          signInSuccess(userData);
          console.log(response);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <Formik
      initialValues={{
        username: "",
        password: "",
      }}
      validationSchema={LoginSchema}
      onSubmit={async (values, { resetForm }) => {
        try {
          const userData = { ...values };
          resetForm();
          notify();
          login(userData);
        } catch (err) {
          console.error(err);
        }
      }}
    >
      {() => (
        <Form>
           <div className="booking-container">
           <h1 className="booking">USER LOGIN</h1>
           <hr></hr>
            <div className="inner">
            
              <label><b>User Name</b></label>
              <Field name="username" type="text" placeholder="Enter username"  />
             
         
              <label><b>Password</b></label>
              <Field name="password"  type="password" placeholder="password"   
            />


              
              <button
                className="btn btn-success"
                type="submit"
                onClick={() => {}}
              >
                Sign In
              </button>
              <Grid className="login__grid" container>
            <Grid item xs>
              <Link className="link" to="/admin_login">
                Sign In as a Member?
              </Link>
            </Grid>
            <Grid item>
              <Link className="link" to="/sign-up">
                {"Don't have an account? Sign Up"}
              </Link>
            </Grid>
          </Grid>
            </div>
          </div>
        </Form>
      )}
    </Formik>
  );
};
export default Login;