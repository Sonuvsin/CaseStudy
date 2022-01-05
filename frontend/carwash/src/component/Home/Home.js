import React from "react";
import Navbar from "./Navbar";
import WhyUs from "./WhyUs";
import Login from "./Login";
import AdminLogin from "../Admin/AdminLogin";
import Contact from "./Contact";
import Working from "./Working";
import Footer from "./Footer";
import {BrowserRouter, Switch, Link} from 'react-router-dom';
import { Route } from 'react-router-dom';
import SignUp from "./SignUp";
import Customer from "../Customer/Customer";
import Admin  from "../Admin/Admin"


function Home() {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
      <Route exact path="/" component={WhyUs} />
        <Route exact path="/whyus" component={WhyUs} />
        <Route exact path="/working" component={Working} />
        <Route exact path="/contact" component={Contact} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/sign-up" component={SignUp} />*/
        <Route path="/admin_login" component={AdminLogin} />
        <Route path="/admin_home" component={Admin} />
        <Route path="/cust_home" component={Customer} />
      </Switch>
      <Footer />
    </BrowserRouter>
  );
}

export default Home;
