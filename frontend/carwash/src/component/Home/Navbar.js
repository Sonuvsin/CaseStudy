import React, { useEffect, useState } from "react";
import "./Navbar1.css";
import { Link, NavLink } from "react-router-dom";

function Navbar() {
  const [show, setShow] = useState(false);

  useEffect(() => {
    window.addEventListener("scroll", () => {
      if (window.scrollY > 100) {
        setShow(true);
      } else setShow(false);
    });
    return () => {
      window.removeEventListener("scroll", () => {
        console.log("");
      });
    };
  }, []);

  return (
    <nav className={`nav ${show && "nav__scroll"}`}>
      <a href="/">
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
          to="/whyus"
        >
          <b>WHY US?</b>
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/working"
        >
          <b>HOW IT WORKS</b>
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/contact"
        >
          <b>CONTACT US</b>
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/login"
        >
          <b>LOGIN</b>
        </NavLink>
      </div>
    </nav>
  );
}

export default Navbar;
