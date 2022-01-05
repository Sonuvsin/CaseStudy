import React, { useEffect, useState } from "react";
import { Link, NavLink } from "react-router-dom";
import "./Navbar3.css";
import AuthService from "../../services/UserService";

function AdminNav() {
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

  const logout = () => {
    AuthService.logout();
  };


  return (
    <nav className={`nav ${show && "nav__scroll"}`}>
      <a href="/admin_home">
        <img
          className="nav__logo"
          src="https://static6.depositphotos.com/1025962/562/v/600/depositphotos_5621793-stock-illustration-car-wash.jpg"
          alt="A1A LOGO"
        />
      </a>
      <div
        className={`nav__container nav__borderXwidth ${
          show && "nav__containerscroll nav__borderXwidthscroll"
        }`}
      >
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/admin_home"
        >
          SONU SINGH
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/admin_home/addpack"
        >
          ADD SERVICE
        </NavLink>
        <NavLink
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/admin_home/payment"
        >
          PAYMENT
        </NavLink>

        <NavLink
        
          className={`nav__link ${show && "nav__linkscroll"}`}
          to="/admin_login"
        >
          LOGOUT
        </NavLink>
      </div>
    </nav>
  );
}

export default AdminNav;