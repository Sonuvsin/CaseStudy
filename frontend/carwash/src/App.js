import React from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./component/Home/Home";
import Customer from "./component/Customer/Customer";
import Admin from "./component/Admin/Admin";

function App() {
  return (
    <Router>
      <Home />
      <Switch>
      <Route exact path="/" component={Home} />
      <Route path="/cust_home" component={Customer} />
      <Route path="/admin_home" component={Admin} />
      </Switch>
    </Router>
  );
}

export default App;

