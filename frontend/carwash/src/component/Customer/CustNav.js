import React, { useEffect, useState } from "react";
import "./Navbar.css";
import { Link, NavLink } from "react-router-dom";


function CustNav() {
  const [show, setShow] = useState(false);

  useEffect(() => {
    window.addEventListener("scroll", () => {
      if (window.scrollY > 100) {
        setShow(true);
      } else setShow(false);
    });
    return () => {
      window.removeEventListener("scroll", () => {});
    };
  }, []);


  return (
    <nav className={`nav ${show && "nav__scroll"}`}>
      <a href="/cust_home">
        <img
          className="nav__logo"
          src="https://static6.depositphotos.com/1025962/562/v/600/depositphotos_5621793-stock-illustration-car-wash.jpg"
          alt="A1A LOGO"
        />
      
      </a>
      <div className="logotext">
        <h2><b>A1A CAR WASH</b></h2>
      </div>
      
      <div
        className={`nav__container nav__borderXwidth ${
          show && "nav__containerscroll nav__borderXwidthscroll"
        }`}
      >
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/cust_home"
        >
          HOME
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/cust_home/contact"
        >
          CONTACT US
        </NavLink>
      
        <NavLink
         /* onClick={logout}*/
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/login"
        >
          LOGOUT
        </NavLink>
      </div>
    </nav>
  );
}

export default CustNav;