import React, { useEffect } from "react";
import AdminNav from "./AdminNav";
import { Switch, Route } from "react-router-dom";
import Order from "./appointment";
import AddPack from "./Addpack"
import Login from "./AdminLogin";
import Amount from "./amount";
function Admin(){

return (
    <div>
      <AdminNav />
      <Switch>
      <Route exact path="/admin_home" component={Order} />
      <Route exact path="/admin_home/addpack" component={AddPack} />
      <Route exact path="/admin_login" component={Login} />
      <Route exact path="/admin_home/payment" component={Amount} />
      </Switch>
    </div>
  );
}

export default Admin;