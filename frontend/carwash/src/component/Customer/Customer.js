
import React, { useState } from "react";
import { BrowserRouter , Switch, Route, Link } from "react-router-dom";
import CustNav from "./CustNav";
import Footer from "./Footer";
import Home from "./Home";
import Login from "../Home/Login";
import Contact from "./Contact";
import Payment from "./payment";
import OrderDetails from "./OrderDetails";
import success from "./success"




function Customer() {
  const [showItem, setShowItem] = useState(false);
  return (
    <BrowserRouter>
      <CustNav />
      <Switch>
      <Route exact path="/" component={Home} />
      <Route exact path="/cust_home" component={Home} />
      <Route exact path="/cust_home/contact" component={Contact} />
      <Route exact path="/cust_home/order" component={OrderDetails} />
      <Route path="/login" component={Login} />
      <Route path="/cust_home/payment" component={Payment} />
      <Route path="/cust_home/success" component={success} />
    

      </Switch>
      <Footer />
    </BrowserRouter>
  );
}

export default Customer;